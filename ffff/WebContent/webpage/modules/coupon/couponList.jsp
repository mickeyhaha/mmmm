<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>优惠券管理</title>
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
		<h5>优惠券列表 </h5>
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
	<form:form id="searchForm" modelAttribute="coupon" action="${ctx}/coupon/coupon/" method="post" class="form-inline">
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
			<shiro:hasPermission name="coupon:coupon:add">
				<table:addRow url="${ctx}/coupon/coupon/form" title="优惠券"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="coupon:coupon:edit">
			    <table:editRow url="${ctx}/coupon/coupon/form" title="优惠券" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="coupon:coupon:del">
				<table:delRow url="${ctx}/coupon/coupon/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="coupon:coupon:import">
				<table:importExcel url="${ctx}/coupon/coupon/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="coupon:coupon:export">
	       		<table:exportExcel url="${ctx}/coupon/coupon/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column type">优惠券类型: 代金券，满减，满赠</th>
				<th  class="sort-column name">优惠券名称</th>
				<th  class="sort-column discountAmount">优惠金额</th>
				<th  class="sort-column totalCount">优惠券总数</th>
				<th  class="sort-column leftCount">优惠券剩余数量</th>
				<th  class="sort-column orderAmount">订单金额需满。0表示任意金额</th>
				<th  class="sort-column vmIds">设备ids，逗号分隔</th>
				<th  class="sort-column deliverPerDay">每日分发数</th>
				<th  class="sort-column recvPerUser">每用户限制领取数量</th>
				<th  class="sort-column customerType">能领取的客户类型</th>
				<th  class="sort-column startTime">开始时间</th>
				<th  class="sort-column endTime">结束时间</th>
				<th  class="sort-column expireDay">有效天数</th>
				<th  class="sort-column userOrderAmount">消费满多少可用,0表示无门槛</th>
				<th  class="sort-column userVmIds">可用券设备</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="coupon">
			<tr>
				<td> <input type="checkbox" id="${coupon.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看优惠券', '${ctx}/coupon/coupon/form?id=${coupon.id}','800px', '500px')">
					${coupon.type}
				</a></td>
				<td>
					${coupon.name}
				</td>
				<td>
					${coupon.discountAmount}
				</td>
				<td>
					${coupon.totalCount}
				</td>
				<td>
					${coupon.leftCount}
				</td>
				<td>
					${coupon.orderAmount}
				</td>
				<td>
					${coupon.vmIds}
				</td>
				<td>
					${coupon.deliverPerDay}
				</td>
				<td>
					${coupon.recvPerUser}
				</td>
				<td>
					${coupon.customerType}
				</td>
				<td>
					<fmt:formatDate value="${coupon.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${coupon.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${coupon.expireDay}
				</td>
				<td>
					${coupon.userOrderAmount}
				</td>
				<td>
					${coupon.userVmIds}
				</td>
				<td>
					<shiro:hasPermission name="coupon:coupon:view">
						<a href="#" onclick="openDialogView('查看优惠券', '${ctx}/coupon/coupon/form?id=${coupon.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="coupon:coupon:edit">
    					<a href="#" onclick="openDialog('修改优惠券', '${ctx}/coupon/coupon/form?id=${coupon.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="coupon:coupon:del">
						<a href="${ctx}/coupon/coupon/delete?id=${coupon.id}" onclick="return confirmx('确认要删除该优惠券吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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