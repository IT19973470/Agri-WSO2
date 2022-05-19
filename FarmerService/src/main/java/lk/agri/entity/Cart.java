package lk.agri.entity;

import javax.persistence.*;

@Entity
public class Cart {

    @EmbeddedId
    private CartPK cartPK;
    private int quantity;

    @ManyToOne
    @JoinColumn(name="itemId",referencedColumnName = "itemId",insertable = false, updatable = false,nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="email",referencedColumnName = "email",insertable = false, updatable = false,nullable = false)
    private UserAccount userAccount;

//    @JoinColumn(name="purchased",referencedColumnName = "purchased",insertable = false, updatable = false,nullable = false)
//    private boolean purchased;


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

    public CartPK getCartPK() {
        return cartPK;
    }

    public void setCartPK(CartPK cartPK) {
        this.cartPK = cartPK;
    }

//    public boolean isPurchased() {
//        return purchased;
//    }
//
//    public void setPurchased(boolean purchased) {
//        this.purchased = purchased;
//    }
}
