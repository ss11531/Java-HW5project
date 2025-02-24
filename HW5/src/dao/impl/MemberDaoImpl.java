package dao.impl;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
	public static void main(String[] args) {
		/*EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setEmployeeno("E001");
        employee.setName("John Doe");
        employee.setUsername("johndoe");
        employee.setPassword("password123");
        employee.setAddress("123 Elm Street");
        employee.setMobile("123-456-7890");
        employeeDao.add(employee);
        System.out.println("Employee added!");*/
}
	
	private static Connection conn = DbConnection.getDb();

	@Override
	public void add(Member member) {
		String SQ = "insert into member(employeeno, name, username, password, address, mobile)" + "values(?,?,?,?,?,?)";
		try {

			PreparedStatement preparedstatement = conn.prepareStatement(SQ);
			preparedstatement.setString(1, member.getEmployeeno());
			preparedstatement.setString(2, member.getName());
			preparedstatement.setString(3, member.getUsername());
			preparedstatement.setString(4, member.getPassword());
			preparedstatement.setString(5, member.getAddress());
			preparedstatement.setString(6, member.getMobile());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Member> selectAll() {
		String sql = "select * from member";
		List<Member>  l = new ArrayList();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				Member m = new Member();
				m.setId(resultset.getInt("id"));
				m.setEmployeeno(resultset.getString("employeeno"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Member> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from member where username=? and password=?";
		List<Member> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2,  password);
			
			ResultSet resultset = preparedstatement.executeQuery();
			
			while (resultset.next()) {
				Member m = new Member();
				m.setId(resultset.getInt("id"));
				m.setEmployeeno(resultset.getString("employeeno"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				l.add(m); 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}


	@Override
	public List<Member> selectById(int id) {
		String sql = "select * from member where id=?";
		List<Member> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);

			ResultSet resultset = preparedstatement.executeQuery();
			
			if (resultset.next()) {
				Member m = new Member();
				m.setId(resultset.getInt("id"));
				m.setEmployeeno(resultset.getString("employeeno"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
				l.add(m);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}


	@Override
	public List<Member> selectByUsername(String username) {
		String sql = "select * from member where username=?";
		List<Member> l = new ArrayList();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);

			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				Member m = new Member();
				m.setId(resultset.getInt("id"));
				m.setEmployeeno(resultset.getString("employeeno"));
				m.setName(resultset.getString("name"));
				m.setUsername(resultset.getString("username"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setMobile(resultset.getString("mobile"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}


	@Override
	public void update(Member member) {
		String sql = "update member set name=?,username=?,password=?,address=?,mobile=? where id=?";
		
		try{
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, member.getEmployeeno());
			preparedstatement.setString(2, member.getName());
			preparedstatement.setString(3, member.getUsername());
			preparedstatement.setString(4, member.getPassword());
			preparedstatement.setString(5, member.getAddress());
			preparedstatement.setString(6, member.getMobile());
			preparedstatement.setInt(7, member.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		try {
		String sql = "delete from member where id=?";
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
