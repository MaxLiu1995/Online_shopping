package onlineShop1.dao;


import onlineShop1.model.Cart;
import onlineShop1.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    
    void removeCartItem(int cartItemId);
    
    void removeAllCartItems(Cart cart);
}

