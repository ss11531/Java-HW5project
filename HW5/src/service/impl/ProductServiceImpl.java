package service.impl;

import java.util.List;
import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();
    

	@Override
	public boolean addProduct(Product product) {
		return productDao.addProduct(product);
	}

	@Override
	public boolean updateProduct(Product product) {
		 return productDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(int id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public Product getProductById(int id) {
		 return productDao.getProductById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		 return productDao.getAllProducts();
	}

   
}

