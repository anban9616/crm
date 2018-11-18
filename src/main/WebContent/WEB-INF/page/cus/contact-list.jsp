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
<title>客户联系人列表 - 客户联系人管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		客户关系管理
		<span class="c-gray en">&gt;</span>
		客户联系人管理
		<a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
			<i class="Hui-iconfont" id="shuaxin">&#xe68f;</i>
		</a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<input type="text" class="input-text" style="width: 250px" placeholder="输入客户联系人名称" id="" name="">
			<button type="submit" class="btn btn-success" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜客户联系人
			</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
					<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
				</a>
				<a href="javascript:;" onclick="contact_add('添加客户联系人','${path}/contact/add','800','500')" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i> 添加客户联系人
				</a>
			</span>
			<span class="r">
				共有数据：<strong>${requestScope.count }</strong> 条
			</span>
		</div>
		<table class="table table-border table-bordered table-bg table-sort">
			<thead>
				<tr>
					<th scope="col" colspan="12">客户联系人列表</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">序号</th>
					<th width="100">公司</th>
					<th width="100">角色</th>
					<th width="100">联系人</th>
					<th width="100">职位</th>
					<th width="100">尊称</th>
					<th width="100">电话</th>
					<th width="100">邮箱</th>
					<th width="100">地址</th>
					<th width="100">备注</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="item" varStatus="status">
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""><input type="hidden" name="id" value="${item.id }" /></td>
						<td>${status.index+1 }</td>
						<td>${item.companyName }</td>
						<td class="role">${item.role }</td>
						<td>${item.contactName }</td>
						<td>${item.position }</td>
						<td class="sex">${item.sex }</td>
						<td>${item.phone }</td>
						<td>${item.email }</td>
						<td class="address">${item.address }</td>
						<td>${item.remark }</td>
						<td class="td-manage">
							<a title="编辑" href="javascript:;" onclick="contact_edit('客户联系人编辑','${path}/contact/edit?id=${item.id }','800','500')" class="ml-5"
								style="text-decoration: none">
								<i class="Hui-iconfont">&#xe6df;</i>
							</a> 
							<a title="删除" href="javascript:;" onclick="contact_del(this,${item.id})" class="ml-5" style="text-decoration: none">
								<i class="Hui-iconfont">&#xe6e2;</i>
							</a>
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
$(function(){
	/* 表格排序 */
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,11]}// 制定列不参与排序
		]
	});
	/* 地址填充 */
	$(".address").each(function() {
		var addressStr = $(this).text();
		var address = JSON.parse(addressStr);
		var p = address["province"];
		var c = address["city"];
		var d = address["district"];
		var detail = address["detail"];
		$(this).text(p+c+d+detail);
	});
	/*
	角色填充
	0-决策人 1-普通人 2-分项决策人 3-商务决策 4-技术决策 5-财务决策 6-使用人 7-意见影响人
	*/
	$(".role").each(function() {
		var roleVal = Number($(this).text());
		var roleStr;
		switch (roleVal) {
		case 0:
			roleStr = "决策人";
			break;
		case 1:
			roleStr = "普通人 ";
			break;
		case 2:
			roleStr = "分项决策人";
			break;
		case 3:
			roleStr = "商务决策";
			break;
		case 4:
			roleStr = "技术决策";
			break;
		case 5:
			roleStr = "财务决策";
			break;
		case 6:
			roleStr = "使用人";
			break;
		case 7:
			roleStr = "意见影响人";
			break;
		default:
			break;
		}
		$(this).text(roleStr);
	});
	/*性别填充*/
	$(".sex").each(function() {
		var sexVal = Number($(this).text());
		var sexStr;
		switch (sexVal) {
		case 0:
			sexStr = "男";
			break;
		case 1:
			sexStr = "女";
			break;
		case 2:
			sexStr = "保密";
			break;
		default:
			break;
		}
		$(this).text(sexStr);
	});
});
/*客户联系人-增加*/
function contact_add(title,url,w,h){
	layer_show(title,url,w,h);
	
}

/*客户联系人-删除*/
function contact_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${path}/contact/deleteOne?id='+id,
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


/*客户联系人-编辑*/
function contact_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
</script>
</body>
</html>