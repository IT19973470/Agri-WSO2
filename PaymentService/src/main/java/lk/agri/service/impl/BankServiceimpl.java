package lk.agri.service.impl;

import lk.agri.dto.PurchaseDTO;
import lk.agri.entity.Purchase;
import lk.agri.repository.PurchaseRepository;
import lk.agri.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BankServiceimpl implements BankService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase addPayment(Purchase purchase) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        purchase.setTransactionID("T" + dateTime);
        purchase = purchaseRepository.save(purchase);
        return purchase;

    }
}
