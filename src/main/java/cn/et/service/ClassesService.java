package cn.et.service;

import java.util.List;
import java.util.Map;

import cn.et.bean.Classes;

public interface ClassesService {

	public int addClasses(String c_name,int c_number);
	
	public int deleteClasses(int c_id);
	
	public int UpdateClasses(Classes classes);
	
	public Classes queryClasses(int c_id);
	
	public List<Classes> findSells(String search,int offset,int limit);
	
	public int sums(String search);
	
	public List<Classes> selectAllClasses(int page,int limit,String c_name);
	
	public int selectAllClassesCount(String c_name);
	
	public void update(int c_id,String c_name,int c_number);
	
	public List<Classes> queryClassesId(int id);
	
}
