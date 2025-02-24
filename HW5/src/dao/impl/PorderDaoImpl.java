package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {
	public static void main(String[] args) {
		

	}
	private static Connection conn=DbConnection.getDb();

	@Override
	public void add(Porder porder) {
		String Sql="insert into porder(name,water,dry,exquisite,doll) values(?,?,?,?,?)";//確定SQL語法
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(Sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getWater());
			preparedstatement.setInt(3, porder.getDry());
			preparedstatement.setInt(4, porder.getExquisite());
			preparedstatement.setInt(5, porder.getDoll());
			preparedstatement.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}


	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder;";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setWater(resultset.getInt("water"));
				porder.setDry(resultset.getInt("dry"));
				porder.setExquisite(resultset.getInt("exquisite"));
				porder.setDoll(resultset.getInt("doll"));
				l.add(porder);
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Porder> selectById(int id) {
		String Sql="select * from  porder where id=?";
		List<Porder> l=new ArrayList();
		try {
			
			PreparedStatement preparedstatement=conn.prepareStatement(Sql);
			preparedstatement.setInt(1, id);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setWater(resultset.getInt("water"));
				porder.setDry(resultset.getInt("dry"));
				porder.setExquisite(resultset.getInt("exquisite"));
				porder.setDoll(resultset.getInt("doll"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set name=?,water=?,dry=?,exquisite=?,doll=? where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getWater());
			preparedstatement.setInt(3, porder.getDry());
			preparedstatement.setInt(4, porder.getExquisite());
			preparedstatement.setInt(5, porder.getDoll());
			preparedstatement.setInt(6, porder.getId());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
