package lk.agri.controller;

import lk.agri.entity.Purchase;
import lk.agri.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "Bank/" + "payment")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping(value = "/addPayment")
    public ResponseEntity addpayment(@RequestBody Purchase purchase){
        return ResponseEntity.ok(bankService.addPayment(purchase));
    }

}
