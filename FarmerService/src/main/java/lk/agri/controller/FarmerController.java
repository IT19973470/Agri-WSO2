package lk.agri.controller;

import lk.agri.entity.Item;
import lk.agri.entity.CartDetail;
import lk.agri.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "farmer")
public class FarmerController {

    @Autowired
    private FarmerService itemService;

    @PostMapping(value = "/addItem")
    public ResponseEntity addItem(@RequestPart("item") Item item, @RequestParam(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.ok(itemService.addItem(item, file));
    }

    @GetMapping(value = "/getItems/{email}")
    public ResponseEntity getItems(@PathVariable String email) {
        return ResponseEntity.ok(itemService.getItems(email));
    }

    @PutMapping(value = "/updateItem/{id}")
    public ResponseEntity updateItem(@PathVariable String id, @RequestPart("item") Item item, @RequestParam(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.ok(itemService.updateItem(id, item, file));
    }

    @DeleteMapping(value = "/removeItem/{id}")
    public ResponseEntity removeItem(@PathVariable String id) {
        return ResponseEntity.ok(itemService.removeItem(id));
    }

//    @PostMapping(value = "/addCart")
//    public ResponseEntity addCart(@RequestBody CartDetail cart) {
//        return ResponseEntity.ok(itemService.addCart(cart));
//    }
//
//
//    @GetMapping(value = "/getAllCarts/{nic}")
//    public ResponseEntity getAllCarts(@PathVariable String nic) {
//        return ResponseEntity.ok(itemService.getAllCarts(nic));
//    }

    @GetMapping(value = "/AllCards")
    public ResponseEntity AllCards() {
        return ResponseEntity.ok(itemService.AllCards());
    }

    @GetMapping(value = "/card/{getByName}")
    public ResponseEntity getCardsByTitle(@PathVariable String getByName) {
        return ResponseEntity.ok(itemService.getCardsByTitle(getByName));
    }


    @DeleteMapping(value = "/deleteCart/{nic}/{itemID}")
    public ResponseEntity deleteCart(@PathVariable String nic, @PathVariable String itemID) {
        return ResponseEntity.ok(itemService.deleteCart(nic, itemID));
    }

}
