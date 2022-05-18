package lk.agri.service.impl;

import lk.agri.dto.ItemDTO;
import lk.agri.dto.UserAccountDTO;
import lk.agri.entity.Item;
import lk.agri.entity.UserAccount;
import lk.agri.repository.ItemRepository;
import lk.agri.repository.UserAccountRepository;
import lk.agri.service.TraderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TraderServiceImpl implements TraderService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public UserAccountDTO updateTrader(String nic, UserAccount userAccount) {
        Optional<UserAccount> userAccountOptional = userAccountRepository.findById(nic);
        if (userAccountOptional.isPresent()) {
            UserAccount userAccountobj = userAccountOptional.get();
            userAccountobj.setPassword(userAccount.getPassword());
            userAccountobj.setAddress(userAccount.getAddress());
            userAccountobj.setName(userAccount.getName());
            userAccountobj.setEmail(userAccount.getEmail());
            userAccountobj.setContactNo(userAccount.getContactNo());
            return new UserAccountDTO(userAccountRepository.save(userAccountobj));
        }
        return null;
    }

    @Override
    public UserAccountDTO addAccount(UserAccount userAccount) {
            return new UserAccountDTO(userAccountRepository.save(userAccount));
    }

    @Override
    public ItemDTO addItem(Item item) {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmss"));
        item.setItemId("Item"+dateTime);
        item.setUserAccount(item.getUserAccount());

        return new ItemDTO(itemRepository.save(item));
    }

    @Override
    public List<ItemDTO> getAllCards(String nic) {
        List<Item> items = itemRepository.findAllByUserAccountEmail(nic);
        List<ItemDTO> cardDTOS = new ArrayList<>();

        for (Item item : items){
            cardDTOS.add(new ItemDTO(item));
        }
        return cardDTOS;
    }

    @Override
    public ItemDTO updateItem(String ID, Item item) {
        Optional<Item> cardOptional = itemRepository.findById(ID);
        if (cardOptional.isPresent()) {
            Item itemObj = cardOptional.get();
            itemObj.setDescription(item.getDescription());
//            itemObj.setImage(item.getImage());
            itemObj.setPrice(item.getPrice());
            return new ItemDTO(itemRepository.save(itemObj));
        }
        return null;
    }
}
