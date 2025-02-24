package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConsumerDao;
import model.Consumer;
import util.DbConnection;

public class ConsumerDaoImpl implements ConsumerDao {
	private static Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(Consumer consumer) {
		String sql = "insert into consumer(consumerno, name, username, password, address, mobile) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, consumer.getConsumerno());
			preparedStatement.setString(2, consumer.getName());
			preparedStatement.setString(3, consumer.getUsername());
			preparedStatement.setString(4, consumer.getPassword());
			preparedStatement.setString(5, consumer.getAddress());
			preparedStatement.setString(6, consumer.getMobile());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Consumer> selectAll() {
		String sql = "select * from consumer";
		List<Consumer> list = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Consumer consumer = new Consumer();
				consumer.setId(resultSet.getInt("id"));
				consumer.setConsumerno(resultSet.getString("consumerno"));
				consumer.setName(resultSet.getString("name"));
				consumer.setUsername(resultSet.getString("username"));
				consumer.setPassword(resultSet.getString("password"));
				consumer.setAddress(resultSet.getString("address"));
				consumer.setMobile(resultSet.getString("mobile"));
				list.add(consumer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Consumer> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from consumer where username=? and password=?";
        List<Consumer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Consumer consumer = new Consumer();
                consumer.setId(resultSet.getInt("id"));
                consumer.setConsumerno(resultSet.getString("consumerno"));
                consumer.setName(resultSet.getString("name"));
                consumer.setUsername(resultSet.getString("username"));
                consumer.setPassword(resultSet.getString("password"));
                consumer.setAddress(resultSet.getString("address"));
                consumer.setMobile(resultSet.getString("mobile"));
                list.add(consumer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	@Override
	public List<Consumer> selectById(int id) {
		 String sql = "select * from consumer where id=?";
	        List<Consumer> list = new ArrayList<>();
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement(sql);
	            preparedStatement.setInt(1, id);

	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.next()) {
	                Consumer consumer = new Consumer();
	                consumer.setId(resultSet.getInt("id"));
	                consumer.setConsumerno(resultSet.getString("consumerno"));
	                consumer.setName(resultSet.getString("name"));
	                consumer.setUsername(resultSet.getString("username"));
	                consumer.setPassword(resultSet.getString("password"));
	                consumer.setAddress(resultSet.getString("address"));
	                consumer.setMobile(resultSet.getString("mobile"));
	                list.add(consumer);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	@Override
	public List<Consumer> selectByUsername(String username) {
		String sql = "select * from consumer where username=?";
        List<Consumer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Consumer consumer = new Consumer();
                consumer.setId(resultSet.getInt("id"));
                consumer.setConsumerno(resultSet.getString("consumerno"));
                consumer.setName(resultSet.getString("name"));
                consumer.setUsername(resultSet.getString("username"));
                consumer.setPassword(resultSet.getString("password"));
                consumer.setAddress(resultSet.getString("address"));
                consumer.setMobile(resultSet.getString("mobile"));
                list.add(consumer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

	@Override
	public void update(Consumer consumer) {
		String sql = "update consumer set name=?, username=?, password=?, address=?, mobile=? where id=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, consumer.getName());
            preparedStatement.setString(2, consumer.getUsername());
            preparedStatement.setString(3, consumer.getPassword());
            preparedStatement.setString(4, consumer.getAddress());
            preparedStatement.setString(5, consumer.getMobile());
            preparedStatement.setInt(6, consumer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void delete(int id) {
		  String sql = "delete from consumer where id=?";
	        try {
	            PreparedStatement preparedStatement = conn.prepareStatement(sql);
	            preparedStatement.setInt(1, id);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
