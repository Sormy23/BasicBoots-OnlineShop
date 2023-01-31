package at.ac.htlwrn.service.impl;

import at.ac.htlwrn.dao.PurchaseOrderDao;
import at.ac.htlwrn.dto.PurchaseOrderDto;
import at.ac.htlwrn.model.PurchaseOrder;
import at.ac.htlwrn.service.PurchaseOrderService;
import org.springframework.stereotype.Service;

import at.ac.htlwrn.exception.UserAlredyExistsException;
import at.ac.htlwrn.model.User;
import at.ac.htlwrn.service.UserService;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service(value = "purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;

    @Override
    public PurchaseOrder save(PurchaseOrderDto order) {
        Validate.notNull(order);
        Validate.notNull(order.getId(), "order must not be null")

        logger.info("Saving Order new order {}", order.getId());
        return null;
    }

    @Override
    public List<PurchaseOrder> find(boolean storniert, boolean erledigt) {
        return null;
    }

    @Override
    public void cancel(PurchaseOrderDto orderDto) {

    }

    @Override
    public void finish(PurchaseOrderDto orderDto) {

    }
}
