package cn.et.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.et.bean.Classes;

@Mapper
public interface ClassesMapper {

	public int addClasses(@Param("c_name") String c_name,@Param("c_number") int c_number);
	
	public int deleteClasses(@Param("c_id") int c_id);
	
 //   @Update("update classes set c_name=#{classes.getC_name} where c_id=#{classes.getC_id}")
	public int UpdateClasses(@Param("classes") Classes classes);
	
  //  @Select("select * from classes where c_id=#{c_id}")
	public Classes queryClasses(@Param("c_id") int c_id);
	
	/**
	 * 拿到参数进行分页
	 * @param search
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<Classes> findSells(@Param("search") String search,@Param("offset") int offset,@Param("limit") int limit);
	
	/**
	 * 根据条件查询班级的数量
	 * @param search
	 * @return
	 */
	public int sums(@Param("search") String search);
	
	/**
	 * 根据条件查询班级
	 * 
	 * @param index
	 * @param limit
	 * @param c_name
	 * @return
	 */
	public List<Classes> selectAllClasses(@Param("index") int index,@Param("limit") int limit,@Param("c_name") String c_name);
	
	/***
	 * 根据添加查询班级的总数量
	 * @param c_name
	 * @return
	 */
	public int selectAllClassesCount(@Param("c_name") String c_name);
	
	public void update(@Param("c_id") int c_id,@Param("c_name") String c_name,@Param("c_number") int c_number);
	
	public List<Classes> queryClassesId(@Param("c_id") int c_id);
}
