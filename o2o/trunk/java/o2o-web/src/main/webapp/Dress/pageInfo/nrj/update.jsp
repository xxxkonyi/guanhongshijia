<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/Dress/include/top.jsp" %>
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

<script type="text/javascript">
	function submit(){
		if($("#form1").checkall()){
		document.form1.submit();
	}
}
$(function(){
	$("#form1").validate();
})
</script>
<table width="100%" border="1" cellspacing="2" cellpadding="0" class="tab2">
<tr>
<td style="border:none; vertical-align:top">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
   <tr>
        <td class="tab2_tou"><a href="javascript:submit();">
        	<img src="<%=request.getContextPath()%>/Dress/img/submit_btn.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="javascript:location.reload();">
			<img src="<%=request.getContextPath()%>/Dress/img/biao_03.gif" border="0" /></a></td>
		<td class="tab2_tou" >
			<a href="<%=request.getContextPath()%>/html/manage/nrj/list">
			<img src="<%=request.getContextPath()%>/Dress/img/return_btn.gif" border="0" /></a></td>

<td>&nbsp;</td>
</tr>
</table>

</td>
</tr>

<tr>
<td style="border:#c5c5c5 solid 1px; vertical-align:top">

<form  name="form1" id="form1" action="<%=request.getContextPath() %>/html/manage/nrj" method="post">
<input type="hidden" name="_method" value="put" />
<input type="hidden" name="nrj_id" value="${ info.nrj_id }"/>
  <table cellspacing="0" cellpadding="0" class="table3_da">
   
  <tr style="height:25px;background-image:url(<%=request.getContextPath()%>/Dress/img/biao_22top.gif); background-repeat:repeat-x;color: #ffffff;">
    <td colspan="4" ><strong>修改女人街商家</strong></td>
  </tr>
    <tr>
    <td class="discription" style="width: 150px;" ><span style="color:#ff0000">*</span>商家名称:</td>
									<td>
							<select name="shangJiaInfo.shangjia_id" class="noNull" msg="商家名称不能为空！" style="width:140px; height:23px;" >
									 <option id="fkzt1" value="">请选择</option>
									 <c:forEach var='Info' items='${sjinfo }' varStatus='index'>
						  <option value="${Info.shangjia_id }" <c:if test="${Info.shangjia_id==info.shangJiaInfo.shangjia_id}">selected</c:if>>${Info.name }</option>
						  </c:forEach>
						</select>
									</td>
									</tr>
     <tr>
     <tr>
     <td class="discription" style="width: 150px;">排序:</td>
  	  <td ><input name="nrj_count" id="nrj_count" dataType="int" value="${ info.nrj_count }"/></td>
  </tr>
  
  
  
 </table>
</form>
</td>
</tr>
</table>
