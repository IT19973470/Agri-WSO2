package lk.agri.service;

import lk.agri.dto.ItemDTO;
import lk.agri.dto.CartDTO;
import lk.agri.entity.Item;
import lk.agri.entity.CartDetail;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FarmerService {

    ItemDTO addItem(Item item, MultipartFile file);

    List<ItemDTO> getItems(String email);

//    public CartDetail addCart(CartDetail cart);

    public List<ItemDTO> AllCards();



//    public List<CartDTO> getAllCarts(String nic);

    public ItemDTO updateItem(String ID, Item item, MultipartFile file);

    public List<ItemDTO> getCardsByTitle(String title);

    boolean deleteCart(String nic, String itemID);

    boolean removeItem(String id);
}
