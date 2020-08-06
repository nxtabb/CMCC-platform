<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/4
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>中国移动业务管理系统</title>
  <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
  <style type="text/css">
    body {
      background-color: #cccccc;
      margin-top: 10px;
    }
  </style>
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<BODY LEFTMARGIN=0 MARGINWIDTH=0>
<!-- ImageReady Slices (index.psd) -->
<TABLE WIDTH=750 BORDER=0 align="center" CELLPADDING=0 CELLSPACING=0>
  <TR>
    <TD ROWSPAN=2>
      <img src="images/index_01.gif" WIDTH=444 HEIGHT=237 ALT=""></TD>
    <TD>
      <img src="images/index_02.gif" WIDTH=306 HEIGHT=99 ALT=""></TD>
  </TR>
  <TR>
    <TD>
      <img SRC="images/index_03.gif" WIDTH=306 HEIGHT=138 ALT=""></TD>
  </TR>
  <tr>
    <TD ROWSPAN=2>
      <IMG SRC="images/index_04.gif" WIDTH=444 HEIGHT=363 ALT=""></TD>
    <td width="306" height="185" background="images/index_05.gif"><table width="250" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><form  action="/check" method="post" name="login" id="login_form">
          <div align="center">
            <table width="100%"  border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="30"><div align="center"><strong>用户名：</strong>
                  <input name="Operator_ID" type="text" id="Operator_ID">
                  <br>
                </div><span id="error1">${error1}</span></td>
              </tr>
              <tr>
                <td height="30"><div align="center"><strong>密&nbsp;&nbsp;&nbsp;码：</strong>
                  <input name="Operator_Pwd" type=password id="Operator_Pwd"><br>
                </div><span id="error2">${error2}</span></td>
              </tr>
              <tr>
                <td height="30">
                  <div align="center">
                    <input class="f2" type="button" size="4" value="进入系统" id="btn" name="Submit">
                  </div></td>
              </tr>
            </table>
          </div>
        </form></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <TD>
      <img src="images/index_06.gif" width="" 306 height="" 178 alt=""></TD>
  </tr>
</TABLE>
</BODY>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
  $(document).ready(function () {

    var flag = false;
    var btn = $("#btn");
    var username_input = $("#Operator_ID");
    var password_input = $("#Operator_Pwd");
    var span1 = $("#error1");
    var span2 = $("#error2");
    username_input.blur(function () {
      if(username_input.val().length==0){
        span1.html("用户名不能为空");
        flag = false;
      }
      else {
        span1.html("");
        flag = true;
      }

    })
    password_input.blur(function () {
      if(password_input.val().length==0){
        span2.html("密码不能为空");
        flag = false;
      }
      else {
        span2.html("");
        flag = true;
      }

    })

    btn.click(function () {
      var form = $("#login_form");
      if(flag){
        form.submit();
      }
      else {
        alert("输入信息有误");
      }
    })
  })

</script>
</html>
