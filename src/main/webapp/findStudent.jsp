<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/bootstrap-table/bootstrap-table.css">
    <link rel="stylesheet" href="assets/examples.css">
    <script src="assets/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/bootstrap-table/bootstrap-table.js"></script>
    <script src="assets/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    
<title>查询班级</title>

<script type="text/javascript">
</script>

<script type="text/javascript">
		function crud(value){
			return "<button type='button' onclick='update("+value+")' class='btn btn-warning'>修改</button>"+"<button type='button' onclick='remove("+value+")' class='btn btn-danger'>删除</button>";
		}
		
		function update(s_id){
			var s_name = prompt("请输入新的学生名字:","");
			var c_id = prompt("请输入新的班级id:","");
			$.post("/student/update",{s_id : s_id,s_name : s_name,c_id : c_id},function(){
				$("table").bootstrapTable('refresh');
			},"json")
			window.location.reload(true);
		}
		
		function remove(s_id){
			
			/* var s_id=$("th[data-field='s_id']").val(); */
			$.post("/student/delete",{s_id: s_id},function(){
				$("table").bootstrapTable('refresh');
			},"json")
			window.location.reload(true);
		}
	
		 function addStudent(){
			
			var s_name=$("input[name='s_name']").val();
			var c_id=$("input[name='c_id']").val();
			
			$.post("/student/add",{s_name : s_name,c_id : c_id},function(){
				$("table").bootstrapTable('refresh');
			},"json")
			window.location.reload(true);
		} 
		
		
		
    </script>

</head>
<body>

<style>
	#div2{ width:800px; height:600px; border:1px solid; margin: -300px -250px; position:absolute; top:50%; left:50%;}
</style>

<div id ="div2"> 
	
	<table
		class="table" 
		data-classes="table table-hover"
		data-toggle="table" 
		data-url="/studnet/querys"
		data-page-list="[2, 5]"
		data-page-size="10"
		data-data-field="result"
		data-show-columns="true" 
		data-pagination="true"
		data-side-pagination="server" 
		data-search="true"
		data-search-align="left" 
		data-striped="true"
	>
	
		<thead>
		<!-- <button type='button' onclick='addStudent()' class='btn btn-warning'>学生添加</button> -->
		<!-- <button type='button' class='btn btn-warning'><a href="addStudent.jsp">学生添加</a></button> -->
		
		<!-- bootstrap  的弹出框 -->
		 <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">学生添加</button>
		
		<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content" style="text-align: center;">
		    	<h2>班级添加</h2>
		      	请输入学生名字:<input type="text" name="s_name" /><br /><br />
		      	请输入学生班级id:<input type="text" name="c_id" /><br /><br />
		      	<button type='button' onclick='addStudent()' class='btn btn-warning'>学生添加</button><br /><br />
		    </div>
		  </div>
		</div> 
		
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<button type='button' class='btn btn-warning'><a href="findClassess.jsp">返回班级管理</a></button>
			<tr>
				<!-- <th data-field="s_id">学生id</th> -->
				<th data-field="s_name">学生名称</th>
				<th data-field="c_name">学生班级</th>
				<th data-field="s_id" data-formatter="crud">操作</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
 
<script>
$(function (){
    $("[data-toggle='popover']").popover();
});
</script>
</div>
</div>
</body>
</html>