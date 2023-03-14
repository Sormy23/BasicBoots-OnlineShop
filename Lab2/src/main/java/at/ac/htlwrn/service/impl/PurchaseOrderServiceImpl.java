package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dao.PurchaseOrderDao;
import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.exception.OrderAlreadyExistsException;
import at.ac.htlwrn.model.PurchaseOrder;
import at.ac.htlwrn.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service(value = "purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private static Logger logger = LogManager.getLogger(PurchaseOrderServiceImpl.class);

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;

    @Override
    public PurchaseOrder save(PurchaseOrderDto orderDto) {
        Validate.notNull(orderDto);
        Validate.notNull(orderDto.getId(), "orderDto must not be null");

        logger.info("Saving Order new orderDto {}", orderDto.getId());

        Optional<PurchaseOrder> order = purchaseOrderDao.findByName(orderDto.getName());
        if (order.isPresent()) {
            logger.warn("Purchase Order {} already exists", orderDto.getName());
            throw new OrderAlreadyExistsException("Order already exists!");
        }
        PurchaseOrder newOrder = new PurchaseOrder();
        newOrder.setAnrede(orderDto.getAnrede());
        newOrder.setCity(orderDto.getCity());
        newOrder.setCanceled(orderDto.getCanceled());
        newOrder.setDate(orderDto.getDate());
        newOrder.setName(orderDto.getName());
        newOrder.setFinished(orderDto.getFinished());
        newOrder.setPrice(orderDto.getPrice());
        newOrder.setStreet(orderDto.getStreet());
        newOrder.setVorname(orderDto.getVorname());
        newOrder.setName(orderDto.getName());

        return purchaseOrderDao.save(newOrder);
    }

    @Override
    public List<PurchaseOrder> find(boolean storniert, boolean erledigt) {
        if(storniert && erledigt) {
            logger.debug("Find all Orders");
            return (List<PurchaseOrder>) purchaseOrderDao.findAll();
        } else if (erledigt) {
            logger.debug("Find all Orders where Finished is set");
            return purchaseOrderDao.findAllByCanceledIsNotNull();
        } else if (storniert) {
            logger.debug("Find all Orders where canceled is set");
            return purchaseOrderDao.findAllByFinishedIsNotNull();
        } else {
            logger.debug("Find all Orders wher canceled and finished is Null");
            return purchaseOrderDao.findAllByCanceledIsNullAndFinishedIsNull();
        }
    }

    @Override
    public void cancel(PurchaseOrderDto orderDto) {
        Validate.notNull(orderDto);
        Validate.notNull(orderDto.getId(), "orderDto.id must not be null!");

        Optional<PurchaseOrder> order = purchaseOrderDao.findById(orderDto.getId());
        if (order.isPresent()) {
            if (order.get().getFinished() != null) {
                logger.debug("Cancel order with id {}", order.get().getId());
                Date date = new Date();
                order.get().setFinished(date);
            } else {
                logger.warn("Order with id {} already finished", order.get().getId());
            }
        } else {
            logger.error("Order not found! Nothing canceled");
        }
    }

    @Override
    public void finish(PurchaseOrderDto orderDto) {
        Validate.notNull(orderDto);
        Validate.notNull(orderDto.getId(), "orderDto.id must not be null!");

        Optional<PurchaseOrder> order = purchaseOrderDao.findById(orderDto.getId());
        if (order.isPresent()) {
            if (order.get().getCanceled() != null) {
                logger.debug("Finish order with id {}", order.get().getId());
                Date date = new Date();
                order.get().setFinished(date);
            } else {
                logger.warn("Order with id {} already canceled", order.get().getId());
            }
        } else {
            logger.error("Order not found! Nothing Finished");
        }
    }
}
