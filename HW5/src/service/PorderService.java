package service;

import java.util.List;

import model.Porder;

public interface PorderService {

	//create
		void addPorder(Porder porder);
		
		//read
		String AllPorder();
		List<Porder> findAllPorder();	
		Porder findById(int id);
		
		//update
		void updatePorder(String name,int id);
		void updatePorder(int water,int dry,int exquisite,int doll,int id);
		void updatePorder(Porder porder);
		
		//delete
		void deletePorderById(int id);

	}
