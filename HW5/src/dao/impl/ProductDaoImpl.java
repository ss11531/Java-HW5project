package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dao.ProductDao;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao {

	private static Connection conn = DbConnection.getDb();

	@Override
	public boolean addProduct(Product product) {
		String sql = "INSERT INTO product (productno, productname, price) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, product.getProductno());
			stmt.setString(2, product.getProductname());
			stmt.setDouble(3, product.getPrice());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		String sql = "UPDATE product SET productname = ?, price = ? WHERE id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, product.getProductname());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getId());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
	  }
	@Override
	public Product getProductById(int id) {
		String sql = "SELECT * FROM product WHERE id = ?";
	    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, id);
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                System.out.println("查詢到產品: " + rs.getString("productname"));
	                return new Product(
	                        rs.getInt("id"),
	                        rs.getString("productno"),
	                        rs.getString("productname"),
	                        rs.getDouble("price")
	                );
	            } else {
	                System.out.println("沒有找到對應的產品");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT * FROM product";
	    List<Product> products = new ArrayList<>();
	    
	    try (PreparedStatement stmt = conn.prepareStatement(sql);
	         ResultSet rs = stmt.executeQuery()) {
	        
	        while (rs.next()) {
	            products.add(new Product(
	                rs.getInt("id"),
	                rs.getString("productno"),
	                rs.getString("productname"),
	                rs.getDouble("price")
	            ));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return products;
	}
}