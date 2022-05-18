package lk.agri.dto;


import lk.agri.entity.Item;
import lk.agri.entity.UserAccount;

public class ItemDTO {

    private String itemId;
    private String description;
    private String price;
    private String imgName;
    private String imgType;

    private UserAccount userAccount;

    public ItemDTO(Item item) {
        this.itemId = item.getItemId();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.imgName = item.getImgName();
        this.imgType = item.getImgType();
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }
}
