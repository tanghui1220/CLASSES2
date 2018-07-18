
package cn.et.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.bean.Classes;
import cn.et.bean.Student;
import cn.et.service.impl.ClassesServiceImpl;
import cn.et.service.impl.StudentServiceImpl;
import cn.et.utils.ResultList;

@Controller
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	@Autowired
	ClassesServiceImpl classesServiceImpl;
	
	@PostMapping("/student/add")
	public String addStudent(String s_name,String c_id){
		
		System.out.println(s_name+"..."+c_id);
		
		int id = Integer.parseInt(c_id);
		/**
		 * 用于判断添加学生班级id 是否存在
		 */
		List<Classes> classes = classesServiceImpl.queryClassesId(id);
		
		System.out.println(classes);
		
		if(classes.size() == 0) {
			System.out.println("班级id不存在,添加失败..");
			
			return "/addStudent.jsp";
		}else {
		
		studentServiceImpl.addStudent(s_name, id);
		
		return "/findStudent.jsp";
		}
	}
	
	@RequestMapping("/student/delete")
	@ResponseBody
	public String delete(@RequestParam("s_id") String s_id) {
		
		System.out.println(s_id+"....");
		int id = Integer.parseInt(s_id);
		
		studentServiceImpl.deleteStudent(id);
		
		return "";
	}
	
	
	@RequestMapping("/student/update")
	@ResponseBody
	public Classes update(@RequestParam("s_id") String s_id,@RequestParam("s_name") String s_name,@RequestParam("c_id") String c_id) {
		
		int sid = Integer.parseInt(s_id);
		int cid = Integer.parseInt(c_id);
		
		studentServiceImpl.updateStudent(sid, s_name, cid);
		
		return null;
	}
	
	/**
	 * 由点击时进来展示所有的并跳转到jsp的方法
	 * @param model
	 * @return
	 */
	@RequestMapping("/studnet/querys")
	@ResponseBody
	public ResultList<Student> query(
			//当前页,默认是第一页
			@RequestParam(name="offset",defaultValue="1")int offset,
			//每一页显示多少条数据,默认是5条
			@RequestParam(name="limit",defaultValue="5")int limit,
			//@RequestParam(value="birthDate",required=false)String birthDate,
			@RequestParam(value="search",defaultValue="")String search
			
			) {
		
		/***
		 * 测试插件是否 ok 
		 */
		
		System.out.println(search+".."+offset+".."+limit);
		
		List<Student> list = studentServiceImpl.findSells(search, offset, limit);
		
		System.out.println(list);
		
		/***
		 * 拿到总的数据 条数
		 */
		int total = studentServiceImpl.sums(search);
		
		System.out.println(total);
		
		return new ResultList<>(list,total);
		
	}
	
}
