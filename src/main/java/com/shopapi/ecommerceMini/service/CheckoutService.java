package com.shopapi.ecommerceMini.service;

import com.shopapi.ecommerceMini.config.AppProperties;
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
    private final AppProperties props;

    public CheckoutService(Map<String, PaymentService> mapPayment, AppProperties props) {
        this.mapPayment = mapPayment;
        this.props = props;
    }
    public String pay(String method, BigDecimal amount){
        BigDecimal max = props.payment().maxAmount();
        if (amount.compareTo(max) > 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Số tiền vượt hạn mức " + max);
        }

        PaymentService paymentService = mapPayment.get(method);
        if (paymentService == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Phương thức không hợp lệ" + method
                    + ". Hỗ trợ: " + mapPayment.keySet());
        }
        return paymentService.pay(amount);
    }
}
