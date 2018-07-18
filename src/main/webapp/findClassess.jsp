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
			return "<button type='button' onclick='showUpdate("+value+")' class='btn btn-info'>修改</button>"
			+"<button type='button' onclick='remove("+value+")' class='btn btn-danger'>删除</button>";
		}
		//<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">班级添加</button>
		function showUpdate(value){
			console.log(value);
			$("input[name='updata_c_id']").val(value);
			$('button[name="updbt"]').click();
		}
		function update(){
			var c_id=$("input[name='updata_c_id']").val();
			var c_name=$("input[name='updata_c_name']").val();
			var c_number=$("input[name='updata_c_number']").val();
			$.post("/classes/update",{c_id : c_id,c_name : c_name,c_number : c_number},function(){
				$(".table").bootstrapTable('refresh');
			},"json")
			window.location.reload(true);
		}
		
		function remove(c_id){
		
			$.post("/classes/delete",{c_id: c_id},function(){
				$("table").bootstrapTable('refresh');
			},"json")
			window.location.reload(true); 
		}
	
		function addClasses(){
			
			var c_name=$("input[name='c_name']").val();
			var c_number=$("input[name='c_number']").val();
			
			$.post("/classesadd",{c_name : c_name,c_number : c_number},function(){
				$("table").bootstrapTable('refresh');
			},"json")
			window.location.reload(true); 
		}
		
    </script>

<style type="text/css">

	#div2{ width:800px; height:600px; border:1px solid; margin: -300px -250px; position:absolute; top:50%; left:50%;}
	#updataD{
		width: 100px;
	}
</style>
</head>
<body>


<div id ="div2"> 
	
	<table
		class="table" 
		data-classes="table table-hover"
		data-toggle="table" 
		data-url="/classes/querys"
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
		<!-- <button type='button' onclick='addClasses()' class='btn btn-warning'>班级添加</button> -->
		<!-- <button type='button' class='btn btn-warning'><a href="addClasses.jsp">添加班级</a></button> -->
		
		<!-- bootstrap  的弹出框 -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">班级添加</button>
		
		<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content" style="text-align: center;">
		    	<h2>班级添加</h2>
		      	请输入班级名字:<input type="text" name="c_name" /><br /><br />
		      	请输入班级人数:<input type="text" name="c_number" /><br /><br />
		      	<button type='button' onclick='addClasses()' class='btn btn-warning'>班级添加</button><br /><br />
		    </div>
		  </div>
		</div>
		
		
		<!-- 可以根据 class='btn btn-warnings 来定义点击之后执行的代码-->
		
		<div class="modal fade bs-example-modal-lgs" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content" style="text-align: center;">
		    	<div class="updataD">
		    	<h2>班级修改</h2>
		      	班级id:<input type="text" name="updata_c_id" readonly class="form-control"/><br /><br />
		      	请输入新的班级名字:<input type="text" name="updata_c_name" class="form-control"/><br /><br />
		      	请输入新的班级人数:<input type="text" name="updata_c_number"  class="form-control"/><br /><br />
		      	<button type='button' onclick='update()' class='btn btn-warnings'>确定修改</button><br /><br />
		    	</div>
		    </div>
		  </div>
		</div>
		
		<button  name="updbt" type='button' class='btn btn-primary' data-toggle='modal' class='btn btn-warnings'data-target='.bs-example-modal-lgs'>修改</button>
		
		
		
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<button type='button' class='btn btn-warning'><a href="findStudent.jsp">返回学生管理</a></button>
			<tr>
				<th data-field="c_id">班级id</th>
				<th data-field="c_name">班级名称</th>
				<th data-field="c_number">班级人数</th>
				<th data-field="c_id" data-formatter="crud">操作</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>
</body>
</html>