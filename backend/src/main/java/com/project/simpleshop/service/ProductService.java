package com.project.simpleshop.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired; 
import com.project.simpleshop.model.Product;
import com.project.simpleshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        // Logic to fetch all products from the database
        return repository.findAll();
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getOriginalFilename());
        product.setImageType(imgFile.getContentType());
        product.setImageData(imgFile.getBytes());
        return repository.save(product);
    }

    public Product updateProduct(int id, Product updatedProduct, MultipartFile imgFile) throws IOException {
        updatedProduct.setImageName(imgFile.getOriginalFilename());
        updatedProduct.setImageType(imgFile.getContentType());
        updatedProduct.setImageData(imgFile.getBytes());
        return repository.save(updatedProduct);
    }
    
    public void deleteProduct(int id) {
        repository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repository.searchProducts(keyword);
    }
}
