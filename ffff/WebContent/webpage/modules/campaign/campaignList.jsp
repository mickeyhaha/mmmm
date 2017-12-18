<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/webpage/include/taglib.jsp"%>
<html>
<head>
	<title>促销管理</title>
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
		<h5>促销列表 </h5>
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
	<form:form id="searchForm" modelAttribute="campaign" action="${ctx}/campaign/campaign/" method="post" class="form-inline">
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
			<shiro:hasPermission name="campaign:campaign:add">
				<table:addRow url="${ctx}/campaign/campaign/form" title="促销"></table:addRow><!-- 增加按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="campaign:campaign:edit">
			    <table:editRow url="${ctx}/campaign/campaign/form" title="促销" id="contentTable"></table:editRow><!-- 编辑按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="campaign:campaign:del">
				<table:delRow url="${ctx}/campaign/campaign/deleteAll" id="contentTable"></table:delRow><!-- 删除按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="campaign:campaign:import">
				<table:importExcel url="${ctx}/campaign/campaign/import"></table:importExcel><!-- 导入按钮 -->
			</shiro:hasPermission>
			<shiro:hasPermission name="campaign:campaign:export">
	       		<table:exportExcel url="${ctx}/campaign/campaign/export"></table:exportExcel><!-- 导出按钮 -->
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
				<th  class="sort-column name">活动名称</th>
				<th  class="sort-column startTime">开始时间</th>
				<th  class="sort-column endTime">结束时间</th>
				<th  class="sort-column type">活动类型：满减，随机减，首单优惠</th>
				<th  class="sort-column discount">减免细节，以json格式存储。 满减：10-2,20-5,30-7 随机减：1-10 首单优惠：5</th>
				<th  class="sort-column vendingMachine.id">活动参与售货机Id，逗号分隔，0表示所有售货机</th>
				<th  class="sort-column campaignNo">活动编号</th>
				<th  class="sort-column state">活动状态: 开启，结束</th>
				<th  class="sort-column user.id">操作员id (User.id)</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="campaign">
			<tr>
				<td> <input type="checkbox" id="${campaign.id}" class="i-checks"></td>
				<td><a  href="#" onclick="openDialogView('查看促销', '${ctx}/campaign/campaign/form?id=${campaign.id}','800px', '500px')">
					${campaign.name}
				</a></td>
				<td>
					${campaign.startTime}
				</td>
				<td>
					${campaign.endTime}
				</td>
				<td>
					${campaign.type}
				</td>
				<td>
					${campaign.discount}
				</td>
				<td>
					${campaign.vendingMachine.id}
				</td>
				<td>
					${campaign.campaignNo}
				</td>
				<td>
					${campaign.state}
				</td>
				<td>
					${campaign.user.id}
				</td>
				<td>
					<shiro:hasPermission name="campaign:campaign:view">
						<a href="#" onclick="openDialogView('查看促销', '${ctx}/campaign/campaign/form?id=${campaign.id}','800px', '500px')" class="btn btn-info btn-xs" ><i class="fa fa-search-plus"></i> 查看</a>
					</shiro:hasPermission>
					<shiro:hasPermission name="campaign:campaign:edit">
    					<a href="#" onclick="openDialog('修改促销', '${ctx}/campaign/campaign/form?id=${campaign.id}','800px', '500px')" class="btn btn-success btn-xs" ><i class="fa fa-edit"></i> 修改</a>
    				</shiro:hasPermission>
    				<shiro:hasPermission name="campaign:campaign:del">
						<a href="${ctx}/campaign/campaign/delete?id=${campaign.id}" onclick="return confirmx('确认要删除该促销吗？', this.href)"   class="btn btn-danger btn-xs"><i class="fa fa-trash"></i> 删除</a>
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