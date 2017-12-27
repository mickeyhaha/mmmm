<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>订单管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		});
	</script>
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content">
	<div class="ibox">
	<div class="ibox-title">
		<h5>订单管理列表 </h5>
		<div class="ibox-tools">
			<a class="collapse-link">
				<i class="fa fa-chevron-up"></i>
			</a>
			<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="fa fa-wrench"></i>
			</a>
			<ul class="dropdown-menu dropdown-user">
				<li><a href="#">选项1</a>
				</li>
				<li><a href="#">选项2</a>
				</li>
			</ul>
			<a class="close-link">
				<i class="fa fa-times"></i>
			</a>
		</div>
	</div>
    
    <div class="ibox-content">
	<sys:message content="${message}"/>
	
	<!--查询条件-->
	<div class="row">
	<div class="col-sm-12">
	<form:form id="searchForm" modelAttribute="order" action="${ctx}/order/order/" method="post" class="form-inline">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<table:sortColumn id="orderBy" name="orderBy" value="${page.orderBy}" callback="sortOrRefresh();"/><!-- 支持排序 -->
		<div class="form-group">
		 </div>	
	</form:form>
	<br/>
	</div>
	</div>
	
	<!-- 工具栏 -->
	<div class="row">
	<div class="col-sm-12">
		<div class="pull-left">
			<shiro:hasPermission name="order:order:add">
				<table:addRow url="${ctx}/order/order/form" title="订单管理"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="order:order:edit">
			    <table:editRow url="${ctx}/order/order/form" title="订单管理" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="order:order:del">
				<table:delRow url="${ctx}/order/order/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="order:order:import">
				<table:importExcel url="${ctx}/order/order/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="order:order:export">
	       		<table:exportExcel url="${ctx}/order/order/export"></table:exportExcel><!-- 导出按钮 -->
	       	</shiro:hasPermission>
	       <button class="btn btn-white btn-sm " data-toggle="tooltip" data-placement="left" onclick="sortOrRefresh()" title="刷新"><i class="glyphicon glyphicon-repeat"></i> 刷新</button>
		
			</div>
		<div class="pull-right">
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="search()" ><i class="fa fa-search"></i> 查询</button>
			<button  class="btn btn-primary btn-rounded btn-outline btn-sm " onclick="reset()" ><i class="fa fa-refresh"></i> 重置</button>
		</div>
	</div>
	</div>
	
	<!-- 表格 -->
	<table id="contentTable" class="table table-striped table-bordered table-hover table-condensed dataTables-example dataTable">
		<thead>
			<tr>
				<th> <input type="checkbox" class="i-checks"></th>
				<th  class="sort-column orderNo">订单编号</th>
				<th  class="sort-column outOrderNo">外部订单编号</th>
				<th  class="sort-column type">订单类型  1:原材料采购, 2 :产品销售</th>
				<th  class="sort-column state">订单状态:  支付成功 ，支付失败，异常待处理，异常已处理，异常忽略</th>
				<th  class="sort-column customer.id">下订单用户</th>
				<th  class="sort-column purchaseTime">交易时间</th>
				<th  class="sort-column source">订单来源：支付宝，微信</th>
				<th  class="sort-column vendingMachine.id">售货机id</th>
				<th  class="sort-column reader_no">读写器序列号</th>
				<th  class="sort-column originTotalPrice">原总价</th>
				<th  class="sort-column cut">促销减免金额</th>
				<th  class="sort-column voucher">优惠券抵扣</th>
				<th  class="sort-column payPrice">实际支付</th>
				<th  class="sort-column unitPrice">单价</th>
				<th  class="sort-column amount">数量</th>
				<th  class="sort-column rfidState">RFID状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="order">
			<tr>
				<td> <input type="checkbox" id="${order.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看订单管理', '${ctx}/order/order/form?id=${order.id}','800px', '500px')">
					${order.orderNo}
				</a></td>
				<td>
					${order.outOrderNo}
				</td>
				<td>
					${order.type}
				</td>
				<td>
					${order.state}
				</td>
				<td>
					${order.customer.id}
				</td>
				<td>
					<fmt:formatDate value="${order.purchaseTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${order.source}
				</td>
				<td>
					${order.vendingMachine.id}
				</td>
				<td>
					${order.reader_no}
				</td>
				<td>
					${order.originTotalPrice}
				</td>
				<td>
					${order.cut}
				</td>
				<td>
					${order.voucher}
				</td>
				<td>
					${order.payPrice}
				</td>
				<td>
					${order.unitPrice}
				</td>
				<td>
					${order.amount}
				</td>
				<td>
					${order.rfidState}
				</td>
				<td>
					<shiro:hasPermission name="order:order:view">
						<a href="#" onclick="openDialogView('查看订单管理', '${ctx}/order/order/form?id=${order.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="order:order:edit">
    					<a href="#" onclick="openDialog('修改订单管理', '${ctx}/order/order/form?id=${order.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="order:order:del">
						<a href="${ctx}/order/order/delete?id=${order.id}" onclick="return confirmx('确认要删除该订单管理吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
					</shiro:hasPermission>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
		<!-- 分页代码 -->
	<table:page page="${page}"></table:page>
	<br/>
	<br/>
	</div>
	</div>
</div>
</body>
</html>