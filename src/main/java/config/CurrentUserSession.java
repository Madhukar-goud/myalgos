package config;

import lombok.Data;

@Data
public class CurrentUserSession {
    private Integer userId;
    private Integer productId;

    public CurrentUserSession(Integer userId, Integer productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
