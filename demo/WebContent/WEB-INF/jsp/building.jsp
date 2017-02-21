<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>大厦详情</title>

<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
	type="text/css">

</head>

<body>

	<div id="wrapper">
	
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">大厦定位详情</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form   class="form-inline" action="${pageContext.request.contextPath }/building/list" method="post">
						<div class="form-group">
							<label for="building">大厦名称</label>
							<input type="text" class="form-control" id="building" value="${building }" name="building">
						</div>
						<div class="form-group">
							<label for="floor">楼层</label> 
							<input type="text" class="form-control" id="floor" value="${floor }" name="floor">
						</div>
	
						<div class="form-group">
							<label for="time">创建时间</label>
							<input type="text" class="form-control" id="time" value="${time }" name="time">
							
						</div>
						
						<input type ="hidden" name ="userid" value ="${userId}" />
						
						<button type="submit" class="btn btn-primary">查询</button>
						<button class="btn btn-primary " data-toggle="modal" data-target="#bleLocateDataAddDialog" type="button">添加定位信息</button>
					
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">大楼信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>					
									<th>大厦名称</th>
									<th>楼层</th>
									<th>corx</th>
									<th>cory</th>
									<th>时间</th>								
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="row">
									<tr>
										<td>${row.building}</td>
										<td>${row.floor}</td>
										<td>${row.corx}</td>
										<td>${row.cory}</td>
										<td>${row.time}</td>
										<td>
										<a href="#" class="btn btn-danger btn-xs" onclick="deleteBleLocateData(${row.id})">删除</a>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#bleLocateDataEditDialog" onclick="editBleLocateData(${row.id})">修改</a>
										</td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
						
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	
	
	<!--大厦编辑对话框 -->
	<div class="modal fade" id="bleLocateDataEditDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改定位信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_blelocateData_form">
						<input type="hidden" name="userid" value = '${userId}' />
						<input type="hidden"  id = "edit_id" name="id" value = '${id}' />
						<div class="form-group">
							<label for="building" class="col-sm-2 control-label">大厦名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_building" placeholder="大厦名称" name="building" value= '${building}'>
							</div>
						</div>
						<div class="form-group">
							<label for="floor" style="float:left;padding:7px 15px 0 27px;">楼层</label> 
							<div class="col-sm-10">
							<input type="text" class="form-control" id="edit_floor" placeholder="楼层" name="floor" value= '${floor}'/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="corx" style="float:left;padding:7px 15px 0 27px;">corx</label>
							<div class="col-sm-10"> 
								<input type="text" class="form-control" id="edit_corx" placeholder="corx" name="corx" value = "${corx}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="cory" style="float:left;padding:7px 15px 0 27px;">cory</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_cory" placeholder="cory" name="cory" value ="${cory }"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="cory" style="float:left;padding:7px 15px 0 27px;">时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_time" placeholder="时间" name="time" value ='${time}'/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updateBleLocateData()">保存修改</button>
				</div>
			</div>
		</div>
	</div>

	<!--添加大厦添加对话框 -->
	<div class="modal fade" id="bleLocateDataAddDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加定位信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="add_bleLocateData_form">
						<input type="hidden" id="userid" name="userid" value = '${userId}' />
						<div class="form-group">
							<label for="building" class="col-sm-2 control-label">大厦名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="building" placeholder="大厦名称" name="building" >
							</div>
						</div>
						<div class="form-group">
							<label for="floor" style="float:left;padding:7px 15px 0 27px;">楼层</label> 
							<div class="col-sm-10">
								<input type="text" class="form-control" id="floor" placeholder="楼层" name="floor" >
							</div>
						</div>
						
						<div class="form-group">
							<label for="corx" style="float:left;padding:7px 15px 0 27px;">corx</label>
							<div class="col-sm-10"> 
								<input type="text" class="form-control" id="corx" placeholder="corx" name="corx" >
							</div>
						</div>
						<div class="form-group">
							<label for="cory" style="float:left;padding:7px 15px 0 27px;">cory</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="cory" placeholder="cory" name="cory">
							</div>
						</div>
						
						<div class="form-group">
							<label for="time" style="float:left;padding:7px 15px 0 27px;">时间</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="time" placeholder="时间" name="time" >
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="addBleLocateData()">确认添加</button>
				</div>
	
	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath%>js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=basePath%>js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=basePath%>js/sb-admin-2.js"></script>
	
	<script type="text/javascript">
	
	/**信息回显*/
	function editBleLocateData(id) {
		
			$.ajax({
				type:"post",
				url:"<%=basePath%>building/toEdit.action",
				data:{"id":id},
				success:function(data) {
					$("#edit_id").val(data.id);
					$("#edit_floor").val(data.floor);
					$("#edit_building").val(data.building);
					$("#edit_corx").val(data.corx);
					$("#edit_cory").val(data.cory);
					$("#edit_time").val(data.time);
			
				}
			});
		}
	
	

	function addBleLocateData() {
		$.post("<%=basePath%>building/addBleLocateData.action",$("#add_bleLocateData_form").serialize(),function(data){
			if(data == "OK"){
				alert("大厦信息添加成功！");
			}else {
				alert("系统繁忙, 请稍后再试!");
			}
			window.location.reload();
		});
	}
	
	
		function deleteBleLocateData(id) {
			if(confirm('你确认要删除该条记录吗?')) {
				$.post("<%=basePath%>building/delBleLocateData.action",{"id":id},function(data){
					if(data == "OK"){
						alert("删除定位记录成功！");
					} else {
						alert("系统繁忙, 请稍后再试!");
					}
					window.location.reload();
				});
			}
		}

		
		function updateBleLocateData() {

			$.post("<%=basePath%>building/updateBleLocateData.action",$("#edit_blelocateData_form").serialize(),function(data){
				if(data == "OK"){
					alert("信息更新成功！");
				}else {
					alert("系统繁忙, 请稍后再试!");
				}
				window.location.reload();
			});
		}

	</script>

</body>

</html>
