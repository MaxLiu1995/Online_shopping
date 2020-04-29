package onlineShop1.service;

import onlineShop1.model.Cart;
import onlineShop1.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem(int cartItemId);

    void removeAllCartItems(Cart cart);
}
