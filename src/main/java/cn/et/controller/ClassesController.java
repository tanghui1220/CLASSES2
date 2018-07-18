package cn.et.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.bean.Classes;
import cn.et.service.impl.ClassesServiceImpl;
import cn.et.service.impl.StudentServiceImpl;
import cn.et.utils.ResultList;

@Controller
public class ClassesController {

	@Autowired
	ClassesServiceImpl classesServiceImpl;
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@RequestMapping("/classesadd")
	public String addClasses(String c_name,String c_number){
		
		System.out.println(c_name+"..."+c_number);
		
		int number = Integer.parseInt(c_number);
		
		
		int tempInt = classesServiceImpl.addClasses(c_name,number);
		
		//return "addClasses.jsp";
		return "";
	}
	
	@RequestMapping("/classes/delete")
	@ResponseBody
	public String delete(@RequestParam("c_id") String c_id) {
		
		System.out.println(c_id+"....");
		int id = Integer.parseInt(c_id);
		
		
		classesServiceImpl.deleteClasses(id);
		/**
		 * 在删除班级的时候,学生也要跟着删除
		 */
		studentServiceImpl.deleteStudents(id);
		
		return "";
	}
	
	/***
	 * 查询使用的是模糊查询
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/classes/query")
	@ResponseBody
	public Classes query(@RequestParam("id") String id) {
		
		int c_id = Integer.parseInt(id);
		
		Classes calsseslist = classesServiceImpl.queryClasses(c_id);
		
		return calsseslist;
	}
	
	@RequestMapping("/classes/update")
	@ResponseBody
	public Classes update(@RequestParam("c_id") String c_id,@RequestParam("c_name") String c_name,@RequestParam("c_number") String c_number) {
		
		System.out.println("修改的数据为:"+c_name+","+c_number);
		
		int id = Integer.parseInt(c_id);
		
		int number = Integer.parseInt(c_number);
		
		classesServiceImpl.update(id,c_name,number);
		
		return null;
	}
	
	/**
	 * 由点击时进来展示所有的并跳转到jsp的方法
	 * @param model
	 * @return
	 */
	@RequestMapping("/classes/querys")
	@ResponseBody
	public ResultList<Classes> query(
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
		
		List<Classes> list = classesServiceImpl.findSells(search,offset,limit);
		
		System.out.println(list);
		
		/***
		 * 拿到总的数据 条数
		 */
		int total = classesServiceImpl.sums(search);
		
		System.out.println(total);
		
		return new ResultList<>(list,total);
		
	}
	
}
