package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class CheckoutService {
    private final Map<String, PaymentService> mapPayment;

    public CheckoutService(Map<String, PaymentService> mapPayment) {
        this.mapPayment = mapPayment;
    }
    public String pay(String method, BigDecimal amount){
        PaymentService paymentService = mapPayment.get(method);
        if (paymentService == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Phương thức không hợp lệ" + method
                    + ". Hỗ trợ: " + mapPayment.keySet());
        }
        return paymentService.pay(amount);
    }
}
