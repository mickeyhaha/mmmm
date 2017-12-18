<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>退款管理</title>
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
		<h5>退款列表 </h5>
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
	<form:form id="searchForm" modelAttribute="refund" action="${ctx}/refund/refund/" method="post" class="form-inline">
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
			<shiro:hasPermission name="refund:refund:add">
				<table:addRow url="${ctx}/refund/refund/form" title="退款"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="refund:refund:edit">
			    <table:editRow url="${ctx}/refund/refund/form" title="退款" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="refund:refund:del">
				<table:delRow url="${ctx}/refund/refund/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="refund:refund:import">
				<table:importExcel url="${ctx}/refund/refund/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="refund:refund:export">
	       		<table:exportExcel url="${ctx}/refund/refund/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column refundNo">退款编号</th>
				<th  class="sort-column customer.id">客户编号</th>
				<th  class="sort-column order.id">订单编号</th>
				<th  class="sort-column orderAmount">订单金额</th>
				<th  class="sort-column applyAmount">申请退款金额</th>
				<th  class="sort-column refundAmount">实际退款金额</th>
				<th  class="sort-column reason">退款原因</th>
				<th  class="sort-column attachment">图片说明</th>
				<th  class="sort-column state">退款状态</th>
				<th  class="sort-column applyTime">申请时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="refund">
			<tr>
				<td> <input type="checkbox" id="${refund.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看退款', '${ctx}/refund/refund/form?id=${refund.id}','800px', '500px')">
					${refund.refundNo}
				</a></td>
				<td>
					${refund.customer.id}
				</td>
				<td>
					${refund.order.id}
				</td>
				<td>
					${refund.orderAmount}
				</td>
				<td>
					${refund.applyAmount}
				</td>
				<td>
					${refund.refundAmount}
				</td>
				<td>
					${refund.reason}
				</td>
				<td>
					${refund.attachment}
				</td>
				<td>
					${refund.state}
				</td>
				<td>
					<fmt:formatDate value="${refund.applyTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<shiro:hasPermission name="refund:refund:view">
						<a href="#" onclick="openDialogView('查看退款', '${ctx}/refund/refund/form?id=${refund.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="refund:refund:edit">
    					<a href="#" onclick="openDialog('修改退款', '${ctx}/refund/refund/form?id=${refund.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="refund:refund:del">
						<a href="${ctx}/refund/refund/delete?id=${refund.id}" onclick="return confirmx('确认要删除该退款吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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