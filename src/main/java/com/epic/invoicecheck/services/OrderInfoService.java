package com.epic.invoicecheck.services;

import com.epic.invoicecheck.entity.OrderInfo;
import com.epic.invoicecheck.repository.OrderInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderInfoService {
    private final OrderInfoRepository orderInfoRepository;

    public List<OrderInfo> getOrderInfo(String orderNr, String supplireNr){
        return orderInfoRepository.findByCOrderNrAndFirmNr(orderNr,supplireNr);
    }
}
