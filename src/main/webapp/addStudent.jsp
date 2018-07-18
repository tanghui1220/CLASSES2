<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#div2{ width:600px; height:600px; border:1px solid red; margin: -300px -250px; position:absolute; top:50%; left:50%; font-size: 20px; }
</style>
</head>
<body>

<div id="div2" >
	<form action="/studentadd" method="post">
		<h1>学生添加</h1>
		学生名字: <input type="text" name ="s_name" required /><br />
		
		学生的班级id: <input type="text" name="c_id" required /><br />
		<input type="submit" value="提交" />
		<input type="reset" value="重置" />
		<button type='button'><a href="findStudent.jsp">返回学生管理</a></button>
		
	</form>
</div>

</body>
</html>