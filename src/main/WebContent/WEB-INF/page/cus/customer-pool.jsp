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
<title>客户列表 - 客户管理</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页
		<span class="c-gray en">&gt;</span>
		客户关系管理
		<span class="c-gray en">&gt;</span>
		客户管理
		<a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新">
			<i class="Hui-iconfont" id="shuaxin">&#xe68f;</i>
		</a>
	</nav>
	<div class="page-container">
		<div class="text-c">
			<input type="text" class="input-text" style="width: 250px" placeholder="输入客户名称" id="" name="">
			<button type="submit" class="btn btn-success" id="" name="">
				<i class="Hui-iconfont">&#xe665;</i> 搜客户
			</button>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
					<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
				</a>
				<a href="javascript:;" onclick="customer_add('添加客户','${path}/customer/add','800','500')" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i> 添加客户
				</a>
			</span>
			<span class="r">
				共有数据：<strong>${requestScope.count }</strong> 条
			</span>
		</div>
		<table class="table table-border table-bordered table-bg table-sort">
			<thead>
				<tr>
					<th scope="col" colspan="18">客户列表</th>
				</tr>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="40">序号</th>
					<th width="100">来源</th>
					<th width="100">公司</th>
					<th width="100">联系人</th>
					<th width="100">联系人电话</th>
					<th width="100">地址</th>
					<th width="100">客户状态</th>
					<th width="100">员工数</th>
					<th width="100">客户等级</th>
					<th width="100">客户行业</th>
					<th width="100">客户编号</th>
					<th width="100">备注</th>
					<th width="100">创建者</th>
					<th width="100">负责人</th>
					<th width="100">创建时间</th>
					<th width="100">更新时间</th>
					<th width="100">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="item" varStatus="status">
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""><input type="hidden" name="id" value="${item.id }" /></td>
						<td>${status.index+1 }</td>
						<td class="source">${item.source}</td>
						<td>${item.companyName }</td>
						<td>${item.contactName }</td>
						<td>${item.phone }</td>
						<td class="address">${item.address }</td>
						<td class="cusStatus">${item.cusStatus }</td>
						<td class="employees">${item.employees }</td>
						<td class="rank">${item.rank }</td>
						<td class="trade">${item.trade }</td>
						<td>${item.number }</td>
						<td>${item.remark }</td>
						<td>${item.userName }</td>
						<td>${item.ownerName }</td>
						<td><fmt:formatDate value="${item.crtm }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td><fmt:formatDate value="${item.mdtm }" pattern="yyyy-MM-dd hh:mm:ss" /></td>
						<td class="td-manage">
							<a title="编辑" href="javascript:;" onclick="customer_edit('客户编辑','${path}/customer/edit?id=${item.id }','800','500')" class="ml-5"
								style="text-decoration: none">
								<i class="Hui-iconfont">&#xe6df;</i>
							</a> 
							<a title="领取" href="javascript:;" onclick="customer_receive(this,${item.id})" class="ml-5" style="text-decoration: none">
								<i class="Hui-iconfont">&#xe605;</i></a>
							<a title="删除" href="javascript:;" onclick="customer_del(this,${item.id})" class="ml-5" style="text-decoration: none">
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
		  {"orderable":false,"aTargets":[0,17]}// 制定列不参与排序
		]
	});
	/* 来源填充*/
	$(".source").each(function(){
		var sourceVal = Number($(this).text());
		var sourceStr;
		switch (sourceVal) {
		case 0:
			sourceStr = "网络营销";
			break;
		case 1:
			sourceStr = "公开媒体";
			break;
		case 2:
			sourceStr = "合作伙伴";
			break;
		case 3:
			sourceStr = "员工介绍";
			break;
		case 4:
			sourceStr = "广告";
			break;
		case 5:
			sourceStr = "推销电话";
			break;
		case 6:
			sourceStr = "其他";
			break;
		default:
			break;
		}
		$(this).text(sourceStr);
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
	/* 客户状态 */
	$(".cusStatus").each(function(){
		var cusStatusVal = Number($(this).text());
		var cusStatusStr;
		switch (cusStatusVal) {
		case 0:
			cusStatusStr = "意向客户";
			break;
		case 1:
			cusStatusStr = "交易成交";
			break;
		case 2:
			cusStatusStr = "交易失败";
			break;
		default:
			break;
		}
		$(this).text(cusStatusStr);
	});
	/*员工数*/
	$(".employees").each(function(){
		var employeesVal = Number($(this).text());
		var employeesStr;
		switch (employeesVal) {
		case 0:
			employeesStr = "10人以下";
			break;
		case 1:
			employeesStr = "10-20人";
			break;
		case 2:
			employeesStr = "20-50人";
			break;
		case 3:
			employeesStr = "50人以上";
			break;
		default:
			break;
		}
		$(this).text(employeesStr);
	});
	/*客户行业*/
	$(".trade").each(function(){
		var tradeVal = Number($(this).text());
		var tradeStr;
		switch (tradeVal) {
		case 0:
			tradeStr = "IT教育";
			break;
		case 1:
			tradeStr = "电子商务";
			break;
		case 2:
			tradeStr = "对外贸易";
			break;
		case 3:
			tradeStr = "酒店旅游";
			break;
		case 4:
			tradeStr = "金融保险 ";
			break;
		case 5:
			tradeStr = "房产行业";
			break;
		case 6:
			tradeStr = "医疗保健";
			break;
		case 7:
			tradeStr = "政府机关 ";
			break;
		case 8:
			tradeStr = "其他";
			break;
		default:
			break;
		}
		$(this).text(tradeStr);
	});
});


/*客户-增加*/
function customer_add(title,url,w,h){
	layer_show(title,url,w,h);
}

/*客户-删除*/
function customer_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${path}/customer/deleteOne?id='+id,
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
/*客户领取*/
function customer_receive(obj,id){
	layer.confirm('确认要领取吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '${path}/customer/receiveOne?id='+id,
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已领取!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data);
			},
		});		
	});
}


/*客户-编辑*/
function customer_edit(title,url,w,h){
	layer_show(title,url,w,h);
}
</script>
</body>
</html>