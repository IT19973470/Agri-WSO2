package lk.agri.service.impl;

import lk.agri.dto.ItemDTO;
import lk.agri.dto.CartDTO;
import lk.agri.entity.Item;
import lk.agri.entity.Cart;
import lk.agri.entity.CartPK;
import lk.agri.repository.ItemRepository;
import lk.agri.repository.CartRepository;
import lk.agri.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CartRepository cartRepository;
    @Value("${image.path}")
    private String filePath;

    @Override
    public ItemDTO addItem(Item item, MultipartFile file) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        item.setItemId("I" + dateTime);

        try {
            if (file != null) {
                String filePathCur = filePath + "\\items";
                Path root = Paths.get(filePathCur);
                if (!Files.exists(root)) {
                    Files.createDirectories(Paths.get(filePathCur));
                }
                try {
                    Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()));
                } catch (FileAlreadyExistsException e) {
                    e.printStackTrace();
                }
                item.setImgName("items/" + StringUtils.cleanPath(file.getOriginalFilename()));
                item.setImgType(file.getContentType());
            } else {
                item.setImgName(null);
                item.setImgType(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ItemDTO(itemRepository.save(item));
    }

    @Override
    public Cart addCart(Cart cart) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        cart.setCartPK(new CartPK(cart.getUserAccount().getEmail(), cart.getItem().getItemId(), true));
//
//        for (Card card : cart.getCard()) {
//            cart.setCartPK(new CartPK(cart.getUserAccount().getNic(),card.getCardId()));
//
//        }
        cart.setUserAccount(cart.getUserAccount());

        return cartRepository.save(cart);
    }

    @Override
    public List<ItemDTO> AllCards() {
        List<Item> items = itemRepository.findAll();
        List<ItemDTO> cardDTOS = new ArrayList<>();

        for (Item item : items) {
            cardDTOS.add(new ItemDTO(item));
        }
        return cardDTOS;
    }

    @Override
    public List<ItemDTO> getAllCards(String nic) {
        List<Item> items = itemRepository.findAllByUserAccountEmail(nic);
        List<ItemDTO> cardDTOS = new ArrayList<>();

        for (Item item : items) {
            cardDTOS.add(new ItemDTO(item));
        }
        return cardDTOS;
    }

    @Override
    public List<CartDTO> getAllCarts(String nic) {
        List<CartDTO> cardDTOS = new ArrayList<>();
        List<Cart> cart = cartRepository.findAllByUserAccountEmail(nic);
        for (Cart cart1 : cart) {
            CartDTO cartDTO = new CartDTO();
            cartDTO.setQuantity(cart1.getQuantity());
            cartDTO.setItem(cart1.getItem());
            // cartDTO.setUserAccount(cart1.getUserAccount());
            cardDTOS.add(cartDTO);
        }
        return cardDTOS;
    }

    @Override
    public ItemDTO updateItem(String ID, Item item) {
        Optional<Item> cardOptional = itemRepository.findById(ID);
        if (cardOptional.isPresent()) {
            Item itemObj = cardOptional.get();
            itemObj.setDescription(item.getDescription());
            itemObj.setPrice(item.getPrice());
            return new ItemDTO(itemRepository.save(itemObj));
        }
        return null;
    }

    @Override
    public List<ItemDTO> getCardsByTitle(String cardTitle) {

//        List<Item> items = itemRepository.findAllByCardTitle(cardTitle);
        List<ItemDTO> cardDTOS = new ArrayList<>();
//        for (Item item : items){
//            cardDTOS.add(new CardDTO(item));
//        }
        return cardDTOS;
    }

    @Override
    @Transactional
    public boolean deleteCart(String nic, String itemID) {
        cartRepository.deleteByUserAccountEmailAndItemItemId(nic, itemID);
        return true;
    }

}
