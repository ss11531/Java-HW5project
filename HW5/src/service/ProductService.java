package service;

import java.util.List;
import model.Product;

public interface ProductService {

	boolean addProduct(Product product);

	boolean updateProduct(Product product);

	boolean deleteProduct(int id);

	Product getProductById(int id);

	List<Product> getAllProducts();
}
