<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<%@include file="/WEB-INF/page/common/header.jsp"%>
<title>线索列表 - 线索管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		客户关系管理
		<span class="c-gray en">&gt;</span>
		线索管理
		<a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
			<i class="Hui-iconfont" id="shuaxin">&#xe68f;</i>
		</a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<input type="text" class="input-text" style="width: 250px" placeholder="输入线索名称" id="" name="">
			<button type="submit" class="btn btn-success" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜线索
			</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
					<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
				</a>
				<a href="javascript:;" onclick="clue_add('添加线索','${path}/clue/add','800','500')" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i> 添加线索
				</a>
			</span>
			<span class="r">
				共有数据：<strong>${requestScope.count }</strong> 条
			</span>
		</div>
		<table class="table table-border table-bordered table-bg table-sort">
			<thead>
				<tr>
					<th scope="col" colspan="12">线索列表</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">序号</th>
					<th width="100">公司</th>
					<th width="100">联系人</th>
					<th width="100">电话</th>
					<th width="100">尊称</th>
					<th width="100">下次联系时间</th>
					<th width="100">联系内容</th>
					<th width="100">创建时间</th>
					<th width="100">创建者</th>
					<th width="100">负责人</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="item" varStatus="status">
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""><input type="hidden" name="id" value="${item.id }" /></td>
						<td>${status.index+1 }</td>
						<td>${item.companyName }</td>
						<td>${item.contactName }</td>
						<td>${item.phone }</td>
						<td><c:if test="${item.sex==0 }">男</c:if> <c:if test="${item.sex==1 }">女</c:if> <c:if test="${item.sex==2 }">保密</c:if></td>
						<td><fmt:formatDate value="${item.nxtm }" pattern="yyyy-MM-dd" /></td>
						<td>${item.content }</td>
						<td><fmt:formatDate value="${item.crtm }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td>${item.userName }</td>
						<td>${item.ownerName }</td>
						<td class="td-manage">
							<a title="编辑" href="javascript:;" onclick="clue_edit('线索编辑','${path}/clue/edit?id=${item.id }','800','500')" class="ml-5" style="text-decoration: none">
								<i class="Hui-iconfont">&#xe6df;</i></a> 
							<a title="领取" href="javascript:;" onclick="clue_receive(this,${item.id})" class="ml-5" style="text-decoration: none">
								<i class="Hui-iconfont">&#xe605;</i></a>
							<a title="删除" href="javascript:;" onclick="clue_del(this,${item.id})" class="ml-5" style="text-decoration: none">
								<i class="Hui-iconfont">&#xe6e2;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<%@include file="/WEB-INF/page/common/footer.jsp"%>
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript" src="${applicationScope.path }/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="${applicationScope.path }/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${applicationScope.path }/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/* 表格排序 */
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,11]}// 制定列不参与排序
		]
	});
	
});
/*线索-增加*/
function clue_add(title,url,w,h){
	layer_show(title,url,w,h);
	
}

/*线索-删除*/
function clue_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${path}/clue/deleteOne?id='+id,
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}
function clue_receive(obj,id){
	layer.confirm('确认要领取吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${path}/clue/receiveOne?id='+id,
			dataType: 'json',
			success: function(data){
				if(data>0){
					$(obj).parents("tr").remove();
					layer.msg('已删除!',{icon:1,time:1000});
				} else{
					layer.msg('删除失败',{icon:2,time:1000})
				}
			},
			error:function(data) {
				console.log(data);
			},
		});		
	});
}

/*线索-编辑*/
function clue_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
</script>
</body>
</html>