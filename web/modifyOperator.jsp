<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/5
  Time: 9:14
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
            <TD width=173><A href="http://www.10086.cn/index/hl/index_451_451.html"><IMG
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
                <%@ include file="left.jsp"%>

            <TD width="2">
                <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
                    <TBODY>
                    <TR>
                        <TD height=25>&nbsp;您现在的位置：新增操作员</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD></TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>
                <form method="POST" action="/crud" id="add_form">
                    <input type="hidden" name="method" value="add">
                    <p>登录ID：<input type="text" name="Operator_ID" size="20" id="Operator_ID" value="${requestScope.tOperator.operator_ID}" readonly><span id="id_error"></span></p>
                    <p>新密码：<input type="password" name="Operator_Pwd" size="20" id="Operator_Pwd"><span id="pwd_error"></span></p>
                    <p>确认新密码：<input type="password" name="Pwd_Confirm" size="20" id="Pwd_Confirm"></p>
                    <p>姓 名：<input type="text" name="Operator_Name" size="20" id="Operator_Name" value="${requestScope.tOperator.operator_Name}"></p>
                    <input type="hidden" value="${requestScope.tOperator.is_Admin}" id="isadmin" >
                    <p><input type="button" value="修改信息" name="B1" id="btn"></p>
                </form>
            </TD>
        </TR>
        </TBODY></TABLE>
    <BR></CENTER>
</BODY>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function () {
        var flag = false;
        var form = $("#add_form");
        //验证id号码:
        var Operator_ID_input = $("#Operator_ID");
        //验证密码：
        var Operator_Pwd_input = $("#Operator_Pwd");
        var Operator_Pwd_con_input = $("#Pwd_Confirm");
        Operator_Pwd_con_input.blur(function () {
            if(Operator_Pwd_input.val()!=Operator_Pwd_con_input.val()){
                $("#pwd_error").html("两次密码输入不一致");
                flag = false;
            }else {
                $("#pwd_error").html("");
                flag = true;
            }

        })
        //提交数据
        var btn = $("#btn");
        btn.click(function () {
            if(flag){
                //提交数据
                var Operator_ID = $("#Operator_ID").val();
                var Operator_Name = $("#Operator_Name").val();
                var Operator_Pwd = $("#Operator_Pwd").val();
                var Is_Admin = $("#isadmin").val()
                $.ajax({
                    url:"/crud",
                    type: "POST",
                    data: "method=update&Operator_ID="+Operator_ID+"&Operator_Name="+Operator_Name+"&Operator_Pwd="+Operator_Pwd+"&Is_Admin="+Is_Admin,
                    dataType: "text",
                    async :false,
                    success:function (data) {
                        alert(data);
                        window.location.assign("http://localhost:8080/main.jsp");

                    }

                })
            }
            else {
                alert("输入信息有误！")
            }
        })
    })
</script>
</HTML>

