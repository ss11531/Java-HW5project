package service.impl;

import java.util.List;


import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl  implements PorderService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static PorderDaoImpl porderdaoImpl=new PorderDaoImpl();

	@Override
	public void addPorder(Porder porder) {
		if(porder.getWater()>=0 && porder.getDry()>=0 && porder.getExquisite()>=0 &&porder.getDoll()>=0)
		{
			porderdaoImpl.add(porder);
		}
		
	}

	@Override
	public String AllPorder() {
		List<Porder> l=porderdaoImpl.selectAll();
		String show="";
		for(Porder m:l)
		{
			int sum=m.getWater()*300+m.getDry()*400+m.getExquisite()*600+m.getDoll()*500;
			
			show +=show+"訂單編號:"+m.getId()+
					"\t客戶名稱:"+m.getName()+
					"\twater:"+m.getWater()+
					"\tdry:"+m.getDry()+
					"\texquisite:"+m.getExquisite()+
					"\tdoll:"+m.getDoll()+
					"\t金額:"+sum+"元\n";
		}
		
		return show;
	}


	@Override
	public List<Porder> findAllPorder() {
		return porderdaoImpl.selectAll();

	}


	@Override
	public Porder findById(int id) {
		Porder porder=null;
		if(id>0)
		{
			List<Porder> l=porderdaoImpl.selectById(id);
			if(l.size()>0)
			{
				porder=l.get(0);
			}
			
		}	
		
		return porder;
	}
	@Override
	public void updatePorder(String name, int id) {
		Porder m=findById(id);
		m.setName(name);
		porderdaoImpl.update(m);
		
	}

	@Override
	public void updatePorder(int water, int dry, int exquisite, int doll, int id) {
		Porder m=findById(id);
		   m.setWater(water);
		   m.setDry(dry);
		   m.setExquisite(exquisite);
		   m.setDoll(doll);
		   porderdaoImpl.update(m);
		
	}

	@Override
	public void updatePorder(Porder porder) {
		Porder m=findById(porder.getId());
		
	}

	@Override
	public void deletePorderById(int id) {
		if(id>0)
		{
			porderdaoImpl.delete(id);
		}
		
	}
}
