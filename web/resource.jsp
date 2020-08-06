<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/5
  Time: 12:09
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
                        <TD height=25>&nbsp;您现在的位置：资源管理</TD>
                    </TR>
                    <TR>
                        <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif"
                                                 width=1></TD></TR>
                    <TR>
                        <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
        <TR vAlign=top>
            <TD height="600" bgColor=#f1f3f9>


                <form method="POST" action="/addmobile">
                    <p>号码类型：<input type="Radio"  name="Type" value="SIM" checked>SIM &nbsp;&nbsp;
                        <input type="Radio"  name="Type" value="UIM">UIM
                    </p>
                    <p>指定号段：从<input type="text" name="T1" size="20" id="from_num">
                        到
                        <input type="text" name="T2" size="20" id="to_num" >
                        <input type="button" value="提交" name="B1" id="btn">
                        <input type="reset" value="全部重写" name="B2">
                    </p>
                </form>
                <div><span id="error1"></span>
                    <span id="error2"></span></div>
                <hr>

            </TD>
        </TR>
        </TBODY></TABLE>
    <BR></CENTER></BODY>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
    $(document).ready(function () {
        var from_num_input = $("#from_num");
        var to_num_input = $("#to_num");
        var error1 = $("#error1");
        var error2 = $("#error2");
        var flag1 = false;
        var flag2 = false;
        var flag3 = false;
        from_num_input.blur(function () {
            var from_num = from_num_input.val();
            var reg = /^\d{11}$/;
            if(reg.test(from_num)){
                error1.html("");
                flag1 = true;
            }else {
                error1.html("初始号段格式有误");
                flag1 = false;
            }

        })

        to_num_input.blur(function () {
            var to_num = to_num_input.val();
            var reg = /^\d{11}$/;
            if(reg.test(to_num)){
                error2.html("");
                flag2 = true;
            }else {
                error2.html("结束号段格式有误");
                flag2 = false;
            }

        })


        var btn = $("#btn");
        btn.click(function () {
            var from_num = from_num_input.val();
            var to_num = to_num_input.val();
            var kaleibie = $("input[name='Type']:checked").val()
            if(from_num<to_num){
                $.ajax({
                    url:"/mobile",
                    dataType:"text",
                    type:"POST",
                    data:"R1="+kaleibie+"&T1="+from_num+"&T2="+to_num,
                    async:false,
                    success:function (data) {
                        alert(data);

                    }
                })
            }
            else {
                alert("输入的号段不符合规定");
            }

        })

    })
</script>
</HTML>

