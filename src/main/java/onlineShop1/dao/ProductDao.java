package onlineShop1.dao;

import java.util.List;

import onlineShop1.model.Product;

public interface ProductDao {
    
    Product getProductById(int productId);

    void deleteProduct(int productId);
    
    void addProduct(Product product);
    
    void updateProduct(Product product);
    
    List<Product> getAllProducts();
}
