package com.service;

import com.entites.Product;
import com.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showProductList() {
        return productRepository.getProductList();
    }

    public Product getProductById(int id) {
        Product product = productRepository.findOneById(id);
        return product;
    }

    public void addNewProduct(Product product) {
        for (int i = 0; i < productRepository.getProductList().size(); i++) {
            if (product.getId() == productRepository.getProductList().get(i).getId()) {
                return;
            }
        }
        productRepository.addNewProduct(product);
    }

    public ProductService() {
    }
}
