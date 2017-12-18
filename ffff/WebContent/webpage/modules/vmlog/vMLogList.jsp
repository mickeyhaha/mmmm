<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>售货机日志管理</title>
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
		<h5>售货机日志列表 </h5>
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
	<form:form id="searchForm" modelAttribute="vMLog" action="${ctx}/vmlog/vMLog/" method="post" class="form-inline">
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
			<shiro:hasPermission name="vmlog:vMLog:add">
				<table:addRow url="${ctx}/vmlog/vMLog/form" title="售货机日志"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vmlog:vMLog:edit">
			    <table:editRow url="${ctx}/vmlog/vMLog/form" title="售货机日志" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vmlog:vMLog:del">
				<table:delRow url="${ctx}/vmlog/vMLog/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vmlog:vMLog:import">
				<table:importExcel url="${ctx}/vmlog/vMLog/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="vmlog:vMLog:export">
	       		<table:exportExcel url="${ctx}/vmlog/vMLog/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column vmId">售货机id</th>
				<th  class="sort-column vmName">售货机名称</th>
				<th  class="sort-column mobile">手机号码</th>
				<th  class="sort-column type">日志类型（购物开门，补货开门）</th>
				<th  class="sort-column openTime">开门时间</th>
				<th  class="sort-column closeTime">关门时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="vMLog">
			<tr>
				<td> <input type="checkbox" id="${vMLog.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看售货机日志', '${ctx}/vmlog/vMLog/form?id=${vMLog.id}','800px', '500px')">
					${vMLog.vmId}
				</a></td>
				<td>
					${vMLog.vmName}
				</td>
				<td>
					${vMLog.mobile}
				</td>
				<td>
					${vMLog.type}
				</td>
				<td>
					${vMLog.openTime}
				</td>
				<td>
					${vMLog.closeTime}
				</td>
				<td>
					<shiro:hasPermission name="vmlog:vMLog:view">
						<a href="#" onclick="openDialogView('查看售货机日志', '${ctx}/vmlog/vMLog/form?id=${vMLog.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="vmlog:vMLog:edit">
    					<a href="#" onclick="openDialog('修改售货机日志', '${ctx}/vmlog/vMLog/form?id=${vMLog.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="vmlog:vMLog:del">
						<a href="${ctx}/vmlog/vMLog/delete?id=${vMLog.id}" onclick="return confirmx('确认要删除该售货机日志吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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