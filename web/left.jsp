<%@ page import="com.hrbeu.Entity.TOperator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table cellSpacing=0 cellPadding=0 width=173 border=0>
    <tbody>
    <%TOperator tOperator = (TOperator) session.getAttribute("tOperator");%>


    <!--欢迎您：+姓名-->
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>
    <TR>
        <TD width=11 bgColor=#2650a6><IMG height=1
                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span style="color: white">欢迎您:<%=tOperator.getOperator_Name()%></span>
        </TD>
    </TR>
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>

    <!--判断是否是管理员-->
    <%
        if(tOperator.getIs_Admin().equals("Y")){
    %>
    <!--如果是 则显示如下链接-->
    <!--新增操作员-->
    <tr>
        <td width=11 height="29" bgColor=#2650a6><IMG height=1
                                                      src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></td>
        <td width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                class=nav
                href="/crud?method=add">新增操作员</A></td>
    </tr>
    <tr>
        <td bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></td></tr>



    <!--修改操作员-->
    <tr>
        <td width=11 bgColor=#2650a6><IMG height=1
                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></td>
        <td width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                class=nav
                href="/crud?method=beforeupadte&Operator_ID=<%=tOperator.getOperator_ID()%>">修改操作员</A></td>
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD>
    </TR>
    <TR>

    </TR>
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>



    <!--资源管理-->
    <TR>
        <TD width=11 bgColor=#2650a6><IMG height=1
                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                class=nav href="/mobile">资源管理</A></TD>
    </TR>
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>




    <!--配置业务费用-->
    <TR>
        <TD width=11 bgColor=#2650a6><IMG height=1 src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                class=nav
                href="/charge">配置业务费用</A></TD>
    </TR>

    <%
        }
    %>


    <!--否则显示公共部分-->
    <!--开户-->
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>
    <TR>
        <TD width=11 bgColor=#2650a6><IMG height=1
                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                class=nav
                href="/customer?step=1">开户</A></TD>
    </TR>
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>






    <!--退出-->
    <TR>
        <TD width=11 bgColor=#2650a6><IMG height=1
                                          src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
        <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                class=nav
                href="/logout">退出</A></TD>
    </TR>
    <TR>
        <TD bgColor=#ffffff colSpan=2><IMG height=1
                                           src="images/blank.gif" width=1 border=0></TD></TR>

    <TR align=middle>
        <TD colSpan=2 height=160>&nbsp;</TD></TR>
    <TR>
        <TD colSpan=2><IMG height=1 src="images/blank.gif"
                           width=1></TD></TR></tbody></table></td>
<TD width=2 rowSpan=3><IMG height=1 src="images\blank(1).gif" width=2></TD>