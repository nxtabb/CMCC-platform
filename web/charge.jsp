<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/5
  Time: 14:01
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
                        <TD height=25>&nbsp;您现在的位置：配置业务费用</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD></TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>



                <h2>收费细项</h2>
                <form method="POST" action="/charge">
                    <input type="hidden" name="method" value="charge1">
                    <p>收费项目：<select size="1" name="D1" id="charge1">
                        <option value="A">开户费</option>
                        <option value="B">漫游费</option>
                        <option value="C">押金</option>
                        <option value="D">入网费</option>
                        <option value="E">选号费</option>
                    </select></p>
                    <p>收费金额：<input type="text" name="Charge" size="20" value="10" id="money"></p>
                    <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
                </form>
                <hr>
                <h2>业务收费</h2>
                <form method="POST" action="/charge">
                    <input type="hidden" name="method" value="charge2">
                    <p>业务：<select size="1" name="D1">
                        <option>开户业务</option>
                    </select></p>
                    <p>收费项目：
                        <%List<String> list= (List<String>) request.getAttribute("list");%>

                        <input type="checkbox" name="C1" value="A"  <%for(String string:list){
                            if(string.equals("A")){
                        %> checked<%break;}
                        }%> >开户费
                        <input type="checkbox" name="C1" value="B"  <%for(String string:list){
                            if(string.equals("B")){
                        %> checked<%break;}
                        }%>>漫游费
                        <input type="checkbox" name="C1" value="C" <%for(String string:list){
                            if(string.equals("C")){
                        %> checked<%break;}}%>>押金
                        <input type="checkbox" name="C1" value="D"  <%for(String string:list){
                            if(string.equals("D")){
                        %> checked<%break;}
                        }%> >入网费
                        <input type="checkbox" name="C1" value="E" <%for(String string:list){
                            if(string.equals("E")){
                        %> checked<%break;}
                        }%>>选号费</p>
                    <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
                </form>

            </TD>
        </TR>
        </TBODY></TABLE>
    <BR></CENTER></BODY>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function () {
        var charge1 = $("#charge1");
        charge1.change(function () {
            var charge1_val = charge1.val();
            $.ajax({
                url:"/charge",
                type:"POST",
                dataType:"text",
                data:"D1="+charge1_val+"&method=ajax1",
                success:function (data) {
                    var money = $("#money");
                    money.val(data);
                }
            })

        })
    })
</script>
</HTML>

