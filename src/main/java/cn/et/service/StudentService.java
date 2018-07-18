package cn.et.service;

import java.util.List;
import java.util.Map;

import cn.et.bean.Classes;
import cn.et.bean.Student;

public interface StudentService {

	public void addStudent(String s_name,int c_id);
	
	public void deleteStudent(int s_id);
	
	public List<Student> findSells(String search,int offset,int limit);
	
	public int sums(String search);
	
	public void updateStudent(int s_id,String s_name,int c_id);
	
	/**
	 * 在删除班级的时候,相对应的学生信息也要跟着删除.
	 * @param c_id
	 */
	public void deleteStudents(int c_id);	
}
