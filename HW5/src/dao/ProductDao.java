package dao;

import model.Product;
import java.util.List;

public interface ProductDao {

	boolean addProduct(Product product); // 新增產品
    boolean updateProduct(Product product); // 更新產品
    boolean deleteProduct(int id); // 刪除產品
    Product getProductById(int id); // 透過 ID 查詢產品
    List<Product> getAllProducts(); // 查詢所有產品
}