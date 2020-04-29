package onlineShop1.dao;

import java.io.IOException;
import onlineShop1.model.Cart;

public interface CartDao {
    Cart getCartById(int cartId);
}

