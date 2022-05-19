package lk.agri.controller;

import lk.agri.entity.Cart;
import lk.agri.entity.CartDetail;
import lk.agri.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "buyer")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @GetMapping(value = "/getItems/{txt}")
    public ResponseEntity getItems(@PathVariable String txt) {
        return ResponseEntity.ok(buyerService.getItems(txt));
    }

    @PostMapping(value = "/addToCart")
    public ResponseEntity addToCart(@RequestBody CartDetail cart) {
        return ResponseEntity.ok(buyerService.addToCart(cart));
    }

    @PostMapping(value = "/addCart")
    public ResponseEntity addCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(buyerService.addCart(cart));
    }

    @GetMapping(value = "/getCart/{email}")
    public ResponseEntity getCart(@PathVariable String email) {
        return ResponseEntity.ok(buyerService.getCart(email));
    }
//    @PutMapping(value = "/update/{nic}")
//    public ResponseEntity<UserAccountDTO> updateApplication(@PathVariable String nic, @RequestBody UserAccount userAccount) {
//        return ResponseEntity.ok(traderService.updateTrader(nic, userAccount));
//    }
//
//    @PostMapping(value = "/addAccount")
//    public ResponseEntity addAccount(@RequestBody UserAccount userAccount){
//        return ResponseEntity.ok(traderService.addAccount(userAccount));
//    }
//    @PostMapping(value = "/addItem")
//    public ResponseEntity addItem(@RequestBody Item item){
//        return ResponseEntity.ok(traderService.addItem(item));
//    }
//    @GetMapping(value = "/getAllitems/{nic}")
//    public ResponseEntity getAlCards(@PathVariable String nic){
//        return ResponseEntity.ok(traderService.getAllCards(nic));
//    }
//    @PutMapping(value = "/updateItem/{id}")
//    public ResponseEntity updateItem(@PathVariable String id, @RequestBody Item item) {
//        return ResponseEntity.ok(traderService.updateItem(id, item));
//    }
}
