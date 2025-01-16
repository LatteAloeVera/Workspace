package com.ayberk.productmanagementsystem.Service;

import com.ayberk.productmanagementsystem.Model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product productDetails);
    void deleteProductById(Long id);
    List<Product> searchProductsByName(String name);
    List<Product> filterProductsByCategory(String category);
    List<Product> filterProductsByPriceRange(Double minPrice, Double maxPrice);

}
