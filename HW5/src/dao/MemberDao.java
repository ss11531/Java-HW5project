package dao;

import java.util.List;

import model.Member;

public interface MemberDao {

	//create->void
		void add(Member member);
		
		//read->List
		List<Member> selectAll();//select * from member
		List<Member> selectUsernameAndPassword(String username,String password);//select * from member where username=? and password=?
		List<Member> selectById(int id);//資料調出來
		List<Member> selectByUsername(String username);
		
		//update->void
		void update(Member member);//資料調出來再回填回去
		
		//delete->void
		void delete(int id);

	}

