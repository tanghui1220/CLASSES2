package cn.et.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.bean.Student;
import cn.et.mapper.StudentMapper;
import cn.et.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final static Logger log = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public void addStudent(String s_name, int c_id) {
		// TODO Auto-generated method stub
		log.debug("添加学生信息...");
		
		studentMapper.addStudent(s_name, c_id);
		
	}

	@Override
	public void deleteStudent(int s_id) {
		// TODO Auto-generated method stub
		log.debug("根据id删除学习信息.");
		
		studentMapper.deleteStudent(s_id);
	}

	@Override
	public List<Student> findSells(String search, int offset, int limit) {
		
		log.debug("查询学生信息..");
		
		List<Student> list = studentMapper.findSells(search, offset, limit);
		
		return list;
	}

	@Override
	public int sums(String search) {
		// TODO Auto-generated method stub
		log.debug("根据条件查询学生的数量.");
		
		int temp = studentMapper.sums(search);
		
		return temp;
	}

	@Override
	public void updateStudent(int s_id, String s_name, int c_id) {
		// TODO Auto-generated method stub
		log.debug("正在修改学生的信息..");
		
		studentMapper.update(s_id, s_name, c_id);
	}

	@Override
	public void deleteStudents(int c_id) {
		// TODO Auto-generated method stub
		log.debug("删除班级.删除对应的学生信息.");
		studentMapper.deleteStudents(c_id);
		
	}

}
