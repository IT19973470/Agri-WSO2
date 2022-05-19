package lk.agri.controller;
import lk.agri.dto.UserAccountDTO;
import lk.agri.entity.Item;
import lk.agri.entity.UserAccount;
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

//    @GetMapping(value = "/getItems")
//    public ResponseEntity getItems() {
//        return ResponseEntity.ok(buyerService.getItems());
//    }


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
