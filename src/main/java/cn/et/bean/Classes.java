package cn.et.bean;
/**
 * 班级
 * @author 唐辉
 *
 */
public class Classes {

	private int c_id;
	private String c_name;
	private int c_number;
	
	public Classes() {
		super();
	}
	
	public Classes(String c_name, int c_number) {
		super();
		this.c_name = c_name;
		this.c_number = c_number;
	}
	

	public Classes(int c_id, String c_name, int c_number) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_number = c_number;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_number() {
		return c_number;
	}

	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	
	
	
}
