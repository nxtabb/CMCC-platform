<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.hrbeu.Entity.TCustomer" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/5
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=gb2312">
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>
    <link href="css/style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<CENTER>
    <TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
        <TBODY>
        <TR>
            <TD width=173><A href="http://www.chinamobile.com/index.asp"><IMG
                    height=74 src="images/logo.gif" width=173 border=0></A></TD>
            <TD vAlign=top align=right>
                <TABLE width="100%" border=0 cellPadding=0 cellSpacing=0>
                    <TBODY>
                    <TR bgColor=#2650a6>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
                    </TR>
                    <TR bgColor=#FFFFFF>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                        <TD><img src="images/spacer.gif" width="1" height="1"></TD>
                    </TR>
                    <TR>
                        <TD><img src="images/pic01.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic04.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic03.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic02.gif" width="115" height="55"></TD>
                        <TD><img src="images/pic05.gif" width="115" height="55"></TD>
                    </TR></TBODY></TABLE></TD></TR>
        <TR>
            <TD height="12" colSpan=2 align=right bgColor=#d4dced>


                <img src="images/spacer.gif" width="1" height="1">
                <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                    <TR>
                    </TR></TBODY></TABLE>

            </TD></TR>
        <TR>
            <TD colSpan=2><IMG height=2 src="images\blank(1).gif" width=1></TD></TR></TBODY></TABLE>
    <TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
        <TBODY>
        <TR vAlign=top>
            <TD width=173 bgColor=#c9d3e9 rowSpan=2>
                <%@include file="left.jsp"%>
            <TD width="2">
                <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                        <TD height=25>&nbsp;您现在的位置：新增客户>第二步</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD></TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>
                <form method="POST" action="/newUser" id="cus_form">
                    <input type="hidden" name="step" value="custouser">
                    <%TCustomer customer = (TCustomer) request.getAttribute("customer");%>
                    <%Map<String,String> map = new HashMap<String, String>();
                    map.put("D","居民身份证");
                    map.put("A","军官证");
                    map.put("P","护照");%>
                    <p>证件类型：<%=map.get((String) request.getAttribute("zhengjian"))%></p>
                    <p>证件号码：${requestScope.idcode}</p>
                    <p>姓名：<input type="text" name="name" size="20" value="${requestScope.customer.customer_Name}"></p>
                    <input type="hidden" value="<%=(String) request.getAttribute("zhengjian")%>" name="zhengjian">
                    <input type="hidden" value="${requestScope.idcode}" name="idcode">
                    <c:choose>
                    <c:when test="${requestScope.customer.customer_Sex=='M'}">
                        <p>性别：<input type="radio"  name="sex" checked value="M">男&nbsp;&nbsp;
                        <input type="radio" name="sex" value="F">女</p></c:when>
                        <c:when test="${requestScope.customer.customer_Sex=='F'}">
                            <p>性别：<input type="radio"  name="sex"  value="M">男&nbsp;&nbsp;
                                <input type="radio" name="sex" checked value="F">女</p>
                        </c:when>
                        <c:otherwise>
                            <p>性别：<input type="radio"  name="sex" checked  value="M">男&nbsp;&nbsp;
                                <input type="radio" name="sex" value="F">女</p>
                        </c:otherwise>
                    </c:choose>
                    <p>生日：<input type="text" name="birthday" size="20" value="${requestScope.customer.customer_Birthday}" id="birthday"></p>
                    <p>联系地址：<input type="text" name="address" size="20" value="${requestScope.customer.customer_Address}"></p>
                    <p>　</p>
                    <p><input type="button" value="下一步>>" name="B1" id="btn"><input type="reset" value="全部重写" name="B2"></p>
                </form>

            </TD>
        </TR>
        </TBODY></TABLE>
    <BR></CENTER></BODY>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function () {
        var flag = true;
        var btn = $("#btn");
        var birthday = $("#birthday");
        birthday.blur(function () {
            var reg=/^\d{4}-\d{1,2}-\d{1,2}$/;
            var birthday_val = birthday.val();
            if(reg.test(birthday_val)){
                flag = true;
            }
            else {
                flag = false;
            }

        })
        btn.click(function () {
            if(flag){
                var form = $("#cus_form");
                form.submit();
            }else {
                alert("输入信息格式有误");
            }

        })

    })
</script>
</HTML>

