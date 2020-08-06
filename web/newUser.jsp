<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/6
  Time: 9:32
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
                        <TD height=25>&nbsp;您现在的位置：新增用户</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD></TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>

                <form method="POST" action="/newUser" id="form">
                    <input type="hidden" value="addUser" name="step">
                    <p>手机号码：<input type="text" name="phone" size="20" id="phone"><span id="phone_err"></span></p>
                    <p>漫游状态：<input type="radio" name="manyou" value="P" checked>省内漫游
                        <input type="radio" name="manyou" value="D">国内漫游
                        <input type="radio" name="manyou" value="I">国际漫游</p>
                    <p>通话级别：<input type="radio" value="L" checked name="jibie">本地通话
                        <input type="radio" name="jibie" value="D">国内长途
                        <input type="radio" name="jibie" value="I">国际长途</p>
                    <p>客户ID：<input type="text" name="id" size="20" value="${requestScope.id}" readonly></p>
                    <p>账号ID：<input type="text" name="zhanghao" size="20" id="zhanghao"><span id="zhanghao_err"></span></p>
                    <p>密码：<input type="password" name="password" size="20" id="password"></p>
                    <p><input type="button" value="完成>>" name="B1" id="btn"><input type="reset" value="全部重写" name="B2"></p>
                </form>


            </TD>
        </TR>
        </TBODY></TABLE>
    <BR></CENTER></BODY>
<script src="js/jquery-3.3.1.min.js">
</script>
<script>
    $(document).ready(function () {
        var phone = $("#phone");
        phone.blur(function () {
            var phone_num = phone.val();
            $.ajax({
                url:"/newUser",
                dataType:"text",
                data:"phone="+phone_num+"&step=checkphone",
                type:"post",
                success:function (data) {
                    var phone_err = $("#phone_err");
                    phone_err.html(data);
                }

            })

        })


        var zhanghao = $("#zhanghao");
        var password =$("#password")
        password.blur(function () {
            var zhanghao_num = zhanghao.val();
            var password = $("#password").val();
            $.ajax({
                url:"/newUser",
                dataType:"text",
                data:"zhanghao="+zhanghao_num+"&step=checkzhanghao"+"&password="+password,
                type:"post",
                success:function (data) {
                    var zhanghao_err = $("#zhanghao_err");
                    zhanghao_err.html(data);
                }

            })

        })


        var btn = $("#btn");
        btn.click(function () {
            $.ajax({
                url:"newUser",
                dataType:"text",
                data:"step=final&zhanghao="+zhanghao.val(),
                type:"post",
                async:false,
                success:function (data) {
                    alert(data);

                }
            })

        })

    })
</script>
</HTML>

