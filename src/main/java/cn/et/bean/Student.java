package cn.et.bean;

/***
 * 学生
 * @author 唐辉
 *
 */
public class Student {
	
	private int s_id;
	private String s_name;
	private int c_id;
	public Student() {
		super();
	}
	public Student(int s_id, String s_name, int c_id) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.c_id = c_id;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	
	

}
