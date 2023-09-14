package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dao.ProductDao;
import at.ac.htlwrn.dao.PurchaseOrderDao;
import at.ac.htlwrn.dto.ProductDto;
import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.exception.OrderAlreadyExistsException;
import at.ac.htlwrn.exception.ProductDoesNotExistException;
import at.ac.htlwrn.model.OrderedProducts;
import at.ac.htlwrn.model.Product;
import at.ac.htlwrn.model.PurchaseOrder;
import at.ac.htlwrn.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service(value = "purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private static Logger logger = LogManager.getLogger(PurchaseOrderServiceImpl.class);

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public PurchaseOrder save(PurchaseOrderDto orderDto) {
        Validate.notNull(orderDto, "orderDto must not be null");

        logger.info("Saving Order new orderDto {}", orderDto.getName());

        Optional<PurchaseOrder> order = purchaseOrderDao.findByName(orderDto.getName());
        if (order.isPresent()) {
            logger.warn("Purchase Order {} already exists", orderDto.getName());
            throw new OrderAlreadyExistsException("Order already exists!");
        }
        PurchaseOrder newOrder = new PurchaseOrder();
        newOrder.setAnrede(orderDto.getAnrede());
        newOrder.setCity(orderDto.getCity());
        newOrder.setZipCode(orderDto.getZipCode());
        newOrder.setCanceled(orderDto.getCanceled());
        newOrder.setDate(orderDto.getDate());
        newOrder.setName(orderDto.getName());
        newOrder.setFinished(orderDto.getFinished());
        newOrder.setPrice(orderDto.getPrice());
        newOrder.setStreet(orderDto.getStreet());
        newOrder.setVorname(orderDto.getVorname());
        newOrder.setName(orderDto.getName());

        copyProductList(orderDto, newOrder);

        return purchaseOrderDao.save(newOrder);
    }

    //TODO Fehler hier :-(

    private void copyProductList(PurchaseOrderDto orderDto, PurchaseOrder order) {
        if (orderDto.getProductList() != null) {
            order.setProductList(new ArrayList<>());
            for (ProductDto productDto : orderDto.getProductList()) {
                Assert.notNull(productDto, "productDto must not be null");
                Assert.notNull(productDto.getId(), "productDto.Id must not be null");
                addProductToList(productDto, order);
            }
        }
    }

    private void addProductToList(ProductDto productDto, PurchaseOrder order) {
        Product product = productDao.findById(productDto.getId())
                .orElseThrow(ProductDoesNotExistException::new);
        OrderedProducts orderedProduct = new OrderedProducts();
        orderedProduct.setPurchaseOrder(order);
        orderedProduct.setProduct(product);
        orderedProduct.setQuantity(productDto.getQuantity());

        order.getProductList().add(orderedProduct);
    }

    @Override
    public List<PurchaseOrder> find(boolean canceled, boolean done) {
        if(canceled && done) {
            logger.debug("Find all Orders");
            return (List<PurchaseOrder>) purchaseOrderDao.findAll();
        } else if (done) {
            logger.debug("Find all Orders where Finished is set");
            return purchaseOrderDao.findAllByFinishedIsNotNull();
        } else if (canceled) {
            logger.debug("Find all Orders where canceled is set");
            return purchaseOrderDao.findAllByCanceledIsNotNull();
        } else {
            logger.debug("Find all Orders wher canceled and finished is Null");
            return purchaseOrderDao.findAllByCanceledIsNullAndFinishedIsNull();
        }
    }

    @Override
    public void cancel(Long id) {
        Validate.notNull(id, "id must not be null!");

        Optional<PurchaseOrder> order = purchaseOrderDao.findById(id);
        if (order.isPresent()) {
            if (order.get().getFinished() == null) {
                logger.debug("Cancel order with id {}", order.get().getId());
                Date date = new Date();
                order.get().setCanceled(date);
                purchaseOrderDao.save(order.get());
            } else {
                logger.warn("Order with id {} already finished", order.get().getId());
            }
        } else {
            logger.error("Order not found! Nothing canceled");
        }
    }

    @Override
    public void finish(Long id) {
        Validate.notNull(id, "id must not be null!");

        Optional<PurchaseOrder> order = purchaseOrderDao.findById(id);
        if (order.isPresent()) {
            if (order.get().getCanceled() == null) {
                logger.debug("Finish order with id {}", order.get().getId());
                Date date = new Date();
                order.get().setFinished(date);
                purchaseOrderDao.save(order.get());
            } else {
                logger.warn("Order with id {} already canceled", order.get().getId());
            }
        } else {
            logger.error("Order not found! Nothing Finished");
        }
    }

    @Override
    public PurchaseOrder findById(Long id) {
        Validate.notNull(id, "id must not be null");
        logger.debug("Find order by id {}", id);
        Optional<PurchaseOrder> order = purchaseOrderDao.findById(id);
        return order.orElse(null);
    }
}
