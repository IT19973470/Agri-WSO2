package lk.agri.dto;
import lk.agri.entity.Item;
import lk.agri.entity.UserAccount;

public class CartDTO {
    private int quantity;
    private Item item;
    private UserAccount userAccount;

    public CartDTO() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
