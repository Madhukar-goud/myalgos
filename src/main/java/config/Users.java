package config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Users {
    public Integer userId;
    public String userName;
    public List<Products> productsViewed;
    public List<Products> productsPurchased;

    public Users(Integer userId, String userName, List<Products> productsViewed, List<Products> productsPurchased) {
        this.userId = userId;
        this.userName = userName;
        this.productsViewed = productsViewed;
        this.productsPurchased = productsPurchased;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Products> getProductsViewed() {
        return productsViewed;
    }

    public void setProductsViewed(List<Products> productsViewed) {
        this.productsViewed = productsViewed;
    }

    public List<Products> getProductsPurchased() {
        return productsPurchased;
    }

    public void setProductsPurchased(List<Products> productsPurchased) {
        this.productsPurchased = productsPurchased;
    }
}
