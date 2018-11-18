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
	
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
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
					<th width="25"></th>
					<th width="40">序号</th>
					<th width="100">公司</th>
					<th width="100">客户状态</th>
					<th width="100">负责人</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list }" var="item" varStatus="status">
					<tr class="text-c">
						<td><input type="radio" value="${item.id }" name="selectId"></td>
						<td>${status.index+1 }</td>
						<td>${item.companyName }</td>
						<td class="cusStatus">${item.cusStatus }</td>
						<td>${item.ownerName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onclick="submit()">
			</div>
		</div>
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
		  {"orderable":false,"aTargets":[0]}// 制定列不参与排序
		]
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
});
function submit(){
	var $id=$(":radio:checked");
	var id = $id.val();
	var $companyName = $id.parent().next().next();
	var companyName = $companyName.text();
	setTimeout(function() {
	        var index = parent.layer.getFrameIndex(window.name);
	        parent.window.setCompanyName(companyName,id);
	        parent.layer.close(index);
	    },
	    "1000");
}
</script>
</body>
</html>