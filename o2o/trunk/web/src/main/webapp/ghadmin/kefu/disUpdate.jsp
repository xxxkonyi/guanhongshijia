<%@ page import="cn.com.dyninfo.o2o.furniture.sys.Constants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin-inc/top.jsp" %>
<%--
  ~ Copyright (c) 2009-2016 SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~ All rights reserved.
  ~
  ~ This file contains valuable properties of  SHENZHEN Eternal Dynasty
  ~ Technology Co.,Ltd.,  embodying  substantial  creative efforts  and
  ~ confidential information, ideas and expressions.    No part of this
  ~ file may be reproduced or distributed in any form or by  any  means,
  ~ or stored in a data base or a retrieval system,  without  the prior
  ~ written permission  of  SHENZHEN Eternal Dynasty Technology Co.,Ltd.
  ~
  --%>


<script type="text/JavaScript">
/*
function submit(){
	var i=document.getElementById("reduceValue").value;
	var j=document.getElementById("maxAmouont").value;
	var k=document.getElementById("constraintValue").value;
	var d=document.getElementById("discountValue").value;
	if($("#reduceValue").val()==""||$("#maxAmouont").val()==""||$("#constraintValue").val()==""||$("#beginTime").val()==""||$("#name").val()==""||$("#endTime").val()==""){
		alert("带*号的选项不能为空！");
		return;
	}
	if(isNaN(i)==true){
		alert("抵扣金额只能输入数字(小数、整数)");
		return;
	}
	if(isNaN(d)==true){
		alert("折扣率只能输入数字(小数、整数)");
		return;
	}
	if(($("#discountValue").val()<1)||($("#discountValue").val()>9.9)) {
		alert("折扣率应在1-9.9之间！");
		return;
	}
	if(isNaN(j)==true){
		alert("最大抵扣金额只能输入数字(小数、整数)");
		return;
	}
	if(isNaN(k)==true){
		alert("满多少可用只能输入数字(小数、整数)");
		return;
	}
	var myDate=new Date().toLocaleDateString();
	var beginTime=document.getElementById("beginTime").value;
	var endTime=document.getElementById("endTime").value;
	var d1 = new Date(beginTime.replace(/\-/g, "\/"));
	var d2 = new Date(endTime.replace(/\-/g, "\/"));
	var md=new Date(myDate.replace(/\-/g, "\/"))
	if(beginTime!=""&&endTime!=""&&d1 >=d2)
	{
		alert("开始日期不能大于等于结束日期！");
		return;
	}
	if(beginTime!=""&&myDate!=""&&d1<=md){
		alert("开始日期不能小于等于当前日期！");
		return;
	}
    document.form1.submit();
}*/
</script>

<script src="<%=request.getContextPath()%>/client/js/vendor-bundle.js?v=1.5.2"></script>
<script src="<%=request.getContextPath()%>/client/js/AgoraRtcAgentSDK-1.5.2.js?v=1.5.2"></script>

<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2" height="100%" style="vertical-align:top;">
<tr>
	<td class="tab2_top" >
			
	</td>
</tr>
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
<%--   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
		<a href="<%=request.getContextPath()%>/html/manage/coupon/list">
			<img src="<%=request.getContextPath()%>/img/return_btn.gif" border="0" />
		</a></td>

<td>&nbsp;</td>
</tr>--%>
</table>

</td>
</tr>
	<tr><td></td></tr>
<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form name="form1" id="post" action="<%=request.getContextPath() %>/html/manage/coupon" method="post">
<input type="hidden" name="_method" value="PUT"/>
<input type="hidden" name="id" value="" />
<input type="hidden" name="isSys" value="0" />
  <table cellspacing="0" cellpadding="0" class="table3_da">
   <thead>
	<tr>
		<td colspan="6">
			<strong>进入云导购视频</strong>
		</td>
	</tr>
	</thead>
  <tr>
    <td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span>房间号:</td>
    <td>
    	<input type="text" id="name" name="name" value="${roomName}" /></td>

    </tr>
	<tr>
	  <td style="width: 20%;" class="discription"><span style="color:#ff0000">*</span>商品ID号:</td>
	  <td>
		  <input type="text" id="goodsId" name="name" value="${goodsId}" /></td>
	</tr>

	  <td>
		  <a href="<%=request.getContextPath()%>/ghadmin/client/index.html?room=${roomName}" class="zhu2">
			  j进入视频
		  </a>
	  </td>
</table>
</form>
  </td>
</tr>
</table>
  </body>
</html>
