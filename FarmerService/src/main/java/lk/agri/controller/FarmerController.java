package lk.agri.controller;

import lk.agri.entity.Item;
import lk.agri.entity.CartDetail;
import lk.agri.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping(value = "farmer")
public class FarmerController {

    @Autowired
    private FarmerService itemService;

    @PostMapping(value = "/addItem/{description}/{price}/{qty}/{email}")
//    public ResponseEntity addItem(@RequestPart("item") Item item, @RequestParam(value = "file", required = false) MultipartFile file) {
    public ResponseEntity addItem(@PathVariable String description, @PathVariable double price, @PathVariable int qty, @PathVariable String email, @RequestParam(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.ok(itemService.addItem(new Item(null, description, price, qty, email), file));
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

}
