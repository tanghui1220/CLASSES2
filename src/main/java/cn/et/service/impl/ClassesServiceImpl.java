package cn.et.service.impl;


import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.bean.Classes;
import cn.et.mapper.ClassesMapper;
import cn.et.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService{

	private final static Logger log = Logger.getLogger(ClassesServiceImpl.class);
	
	@Autowired
	ClassesMapper classesMapper;

	@Override
	public int addClasses(String c_name,int c_number) {
		
		log.debug("正在进行班级的添加...");
		
		int tempInt = classesMapper.addClasses(c_name,c_number);
		
		if(tempInt == 1) {
			log.debug("班级添加成功.");
		}else {
			log.debug("班级添加失败.");
		}
		return tempInt;
	}

	@Override
	public int deleteClasses(int c_id) {
		
		log.debug("正在删除班级...");
		int tempInt = classesMapper.deleteClasses(c_id);
		if(tempInt == 1) {
			log.debug("班级删除成功!");
		}else {
			log.debug("班级删除失败...");
		}
		return tempInt;
	}

	@Override
	public int UpdateClasses(Classes classes) {
		
		log.debug("正在修改班级信息...");
		int tempInt = classesMapper.UpdateClasses(classes);
		if(tempInt == 1) {
			log.debug("修改班级成功.修改的信息为:"+classes);
		}else {
			log.debug("修改班级信息失败.");
		}
		return tempInt;
	}

	@Override
	public Classes queryClasses(int c_id) {

		log.debug("正在查询班级信息.");
		Classes classes = classesMapper.queryClasses(c_id);
		if(classes == null) {
			log.debug("班级查询失败.");
		}else {
			log.debug("查询的班级信息是:"+classes);
		}
		return classes;
	}

	@Override
	public List<Classes> findSells(String search, int offset, int limit) {
		
		log.debug("查询全部的班级..");
		List<Classes> list = classesMapper.findSells(search,offset,limit);
		
		return list;
	}

	@Override
	public int sums(String search) {
		// TODO Auto-generated method stub
		log.debug("根据条件查询班级的数量.");
		int sum = classesMapper.sums(search);
		return sum;
	}

	@Override
	public List<Classes> selectAllClasses(int page, int limit, String c_name) {
		
		int index = (page-1)*limit;
		
		log.debug("正在查询班级信息...");
		List<Classes> list = classesMapper.selectAllClasses(index,limit,c_name);
		
		return list;
	}

	@Override
	public int selectAllClassesCount(String c_name) {
		// TODO Auto-generated method stub
		
		log.debug("根据条件查询班级的数量...");
		int sum = classesMapper.selectAllClassesCount(c_name);
		return sum;
	}

	@Override
	public void update(int c_id, String c_name, int c_number) {
		// TODO Auto-generated method stub
		log.debug("正在修改班级信息.");
		classesMapper.update(c_id,c_name,c_number);
		
	}

	@Override
	public List<Classes> queryClassesId(int c_id) {
		
		log.debug("用于查询班级id是否存在.");
		List<Classes> classesList = classesMapper.queryClassesId(c_id);
		return classesList;
	}

}
