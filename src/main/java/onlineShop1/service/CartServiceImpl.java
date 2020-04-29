package onlineShop1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import onlineShop1.dao.CartDao;
import onlineShop1.model.Cart;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
   	 return cartDao.getCartById(cartId);
    }
}
