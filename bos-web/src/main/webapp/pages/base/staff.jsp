<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery核心类库 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<!-- 导入easyui类库 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/js/easyui/ext/portal.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/default.css">	
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.portal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easyui/ext/jquery.cookie.js"></script>
<script
	src="${pageContext.request.contextPath }/js/easyui/locale/easyui-lang-zh_CN.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function doAdd(){
		//alert("增加...");
		$('#addStaffWindow').window("open");
	}
	
	function doView(){
		$('#findStaffWindow').window("open");
	}
	
	function doDelete(){
		var a = $("#grid").datagrid("getSelections")
		var ids = new Array()
		for (var i = 0; i < a.length; i++) {
			ids[i] = a[i].id
		}
		$.post(
			"${pageContext.request.contextPath}/staff/delete",
			{"ids":ids.join(",")},
			function x(data) {
				// 0为失败
				if (data == 0){
					$.messager.alert('提示','删除失败，请联系管理员',"warning");
				}
				location.href = "${pageContext.request.contextPath}/page/base_staff"
			},
			"json"
		)
	}
	
	function doRestore(){
		var a = $("#grid").datagrid("getSelections")
		var ids = new Array()
		for (var i = 0; i < a.length; i++) {
			ids[i] = a[i].id
		}
		$.post(
			"${pageContext.request.contextPath}/staff/restore",
			{"ids":ids.join(",")},
			function x(data) {
				// 0为失败
				if (data == 0){
					$.messager.alert('提示','删除失败，请联系管理员',"warning");
				}
				location.href = "${pageContext.request.contextPath}/page/base_staff"
			},
			"json"
		)
	}
	//工具栏
	var toolbar = [
	{
		id : 'button-view',
		text : '查询',
		iconCls : 'icon-search',
		handler : doView
	}, {
		id : 'button-add',
		text : '增加',
		iconCls : 'icon-add',
		handler : doAdd
	}, {
		id : 'button-delete',
		text : '作废',
		iconCls : 'icon-cancel',
		handler : doDelete
	},{
		id : 'button-save',
		text : '还原',
		iconCls : 'icon-save',
		handler : doRestore
	}];
	// 定义列
	var columns = [[ {
		field : 'id',
		checkbox : true,
	},{
		field : 'name',
		title : '姓名',
		width : 120,
		align : 'center'
	}, {
		field : 'telephone',
		title : '手机号',
		width : 120,
		align : 'center'
	}, {
		field : 'haspda',
		title : '是否有PDA',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="1"){
				return "有";
			}else{
				return "无";
			}
		}
	}, {
		field : 'deltag',
		title : '是否作废',
		width : 120,
		align : 'center',
		formatter : function(data,row, index){
			if(data=="1"){
				return "已作废"
			}else{
				return "正常使用";
			}
		}
	}, {
		field : 'standard',
		title : '取派标准',
		width : 120,
		align : 'center'
	}, {
		field : 'station',
		title : '所谓单位',
		width : 200,
		align : 'center'
	} ] ];
	
	$(function(){
		// 先将body隐藏，再显示，不会出现页面刷新效果
		$("body").css({visibility:"visible"});

		//取派员信息表格
		$('#grid').datagrid( {
			iconCls : 'icon-forward',
			fit : true,
			border : false,
			rownumbers : true,
			striped : true,
			pageList: [30,50,100],
			pagination : true,
			toolbar : toolbar,
			url : "${pageContext.request.contextPath}/staff/list",
			idField : 'id',
			columns : columns,
			onDblClickRow : doDblClickRow
		});
		
		// 添加取派员窗口
		$('#addStaffWindow').window({
	        title: '添加取派员',
	        width: 400,
	        modal: true,
	        shadow: true,
	        closed: true,
	        height: 400,
	        resizable:false
	    });

		// 修改取派员窗口
		$('#editStaffWindow').window({
			title: '编辑取派员',
			width: 400,
			modal: true,
			shadow: true,
			closed: true,
			height: 400,
			resizable:false
		});

		// 寻找取派员窗口
		$('#findStaffWindow').window({
			title: '查找取派员',
			width: 400,
			modal: true,
			shadow: true,
			closed: true,
			height: 400,
			resizable:false
		});

		$("#save").click(function () {
			$("#staffForm").form({
				url:"${pageContext.request.contextPath}/staff/add",
				onSubmit: function(){
					// 做一些检查
					// 返回false来防止提交;
					var v = $("#staffForm").form("validate")
					if (!v) {
						$.messager.alert('警告','数据验证错误','warning');
					}
					return v
				},

				success:function(data){
					if (data != 0){
						$.messager.show({
							title:'提示',
							msg:'添加成功！',
							timeout:1000,
							showType:'show',
							style:{
								top:document.body.scrollTop+document.documentElement.scrollTop,
							}
						});
					}
				}
			});
			$('#staffForm').submit();
		})

		$("#find").click(function () {
			$("#findStaffForm").form({
				url:"${pageContext.request.contextPath}/staff/findStaffs",
				onSubmit: function(){
					// 做一些检查
					// 返回false来防止提交;
					var v = document.querySelector("#findStaffForm").elements
					// 记录有多少input的值为空，最少有一个input不为空
					var totle = 0
					for (var i = 0; i < v.length; i++) {
						if (v[i].value == ""){
							totle++
						}

						if (totle > 2){
							$.messager.alert('错误','至少输入一个查询条件','error');
						}
					}
				},
				success:function(data){
					data = eval('(' + data + ')');
					$('#grid').datagrid('loadData', data);
					$('#findStaffWindow').window('close');
				}
			});
			$('#findStaffForm').submit();
		})

		$("#edit").click(function () {
			// 提交表单
			$('#editStaffForm').form('submit', {
				url: "${pageContext.request.contextPath}/staff/editStaff",
				onSubmit: function(){
					var isValid = $('#editStaffForm').form('validate');
					if (!isValid){
						$.messager.alert("错误", "输入的数据有误", "error")
					}
					console.log(isValid)
					return isValid;	// 返回false,将阻止表单提交
				},
				success: function(data){
					if (data == "1"){
						$.messager.show({
							title:'提示',
							msg:'修改成功',
							timeout:1000,
							showType:'slide'
						});
					}

					window.location.href = "${pageContext.request.contextPath}/page/base_staff"
				}
			});
		})

		//自定校验， 长度最小值
		$.extend($.fn.validatebox.defaults.rules, {
			minLength: {
				validator: function(value, param){
					return value.length >= param[0];
				},
				message: '名字最少2位'

			}
		});

		//自定校验， 手机号
		$.extend($.fn.validatebox.defaults.rules, {
			isphone: {
				validator: function(value, param){
					var reg = /^1[3578][0-9]{9}$/
					return reg.test(value)
				},
				message: '手机号格式有误'
			}
		});
	});

	function doDblClickRow(rowIndex, rowData){
		$('#editStaffWindow').window("open");
		$("#editStaffForm").form("load", rowData)
	}
</script>	
</head>
<body class="easyui-layout" style="visibility:hidden;">
	<div region="center" border="false">
    	<table id="grid"></table>
	</div>
	<div class="easyui-window" title="对收派员进行添加或者修改" id="addStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="save" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>
		
		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="staffForm" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true" validType="minLength[2]"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td><input type="text" name="telephone" class="easyui-validatebox" required="true" validType="isphone"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="checkbox" name="haspda" value="1" />
						是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>
						</td>
					</tr>
					</table>
			</form>
		</div>
	</div>

	<div class="easyui-window" title="查找" id="findStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="find" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >查找</a>
			</div>
		</div>

		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="findStaffForm" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<!-- TODO 这里完善收派员添加 table -->
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td><input type="text" name="telephone"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="easyui-window" title="对收派员进行修改" id="editStaffWindow" collapsible="false" minimizable="false" maximizable="false" style="top:20px;left:200px">
		<div region="north" style="height:31px;overflow:hidden;" split="false" border="false" >
			<div class="datagrid-toolbar">
				<a id="edit" icon="icon-save" href="#" class="easyui-linkbutton" plain="true" >保存</a>
			</div>
		</div>

		<div region="center" style="overflow:auto;padding:5px;" border="false">
			<form id="editStaffForm" method="post">
				<table class="table-edit" width="80%" align="center">
					<tr class="title">
						<td colspan="2">收派员信息</td>
					</tr>
					<tr>
						<td>
							<input type="hidden" name="id">
						</td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="name" class="easyui-validatebox" required="true" validType="minLength[2]"/></td>
					</tr>
					<tr>
						<td>手机</td>
						<td><input type="text" name="telephone" class="easyui-validatebox" required="true" validType="isphone"/></td>
					</tr>
					<tr>
						<td>单位</td>
						<td><input type="text" name="station" class="easyui-validatebox" required="true"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="checkbox" name="haspda" value="1" />
							是否有PDA</td>
					</tr>
					<tr>
						<td>取派标准</td>
						<td>
							<input type="text" name="standard" class="easyui-validatebox" required="true"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>	