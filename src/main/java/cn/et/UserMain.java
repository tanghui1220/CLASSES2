package cn.et;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(value = "cn.et.mapper")
public class UserMain {

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(UserMain.class, args);
	}
}
