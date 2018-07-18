package cn.et.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.et.bean.Student;

@Mapper
public interface StudentMapper {

	public void addStudent(@Param("s_name") String s_name,@Param("c_id") int c_id);
	
	public int deleteStudent(@Param("s_id") int s_id);
	
	public List<Student> findSells(@Param("search") String search,@Param("offset") int offset,@Param("limit") int limit);
	
	public int sums(@Param("search") String search);
	
	public void update(@Param("s_id") int s_id,@Param("s_name") String s_name,@Param("c_id") int c_id);
	
	public void deleteStudents(@Param("c_id") int c_id);
}
