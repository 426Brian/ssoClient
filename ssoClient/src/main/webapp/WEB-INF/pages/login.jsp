<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"></meta>
    <title>AJAX LightBox Sample</title>
    <style type="text/css">
        #lightbox {/*该层为高亮显示层*/
            BORDER-RIGHT: #fff 1px solid;
            BORDER-TOP: #fff 1px solid;
            DISPLAY:none;
            Z-INDEX: 9999; /*设置该层在网页的最上端,设置足够大*/
            BACKGROUND: #fdfce9; /*设置背景色*/
            LEFT: 50%;
            MARGIN: -120px 0px 0px -150px;
            BORDER-LEFT: #fff 1px solid;
            WIDTH: 300px;
            BORDER-BOTTOM: #fff 1px solid;
            POSITION: absolute;
            TOP: 50%;
            HEIGHT: 150px;
            TEXT-ALIGN: left
        }
        #overlay {/*该层为覆盖层*/
            DISPLAY: none;
            Z-INDEX: 9998; /*设置高亮层的下方*/
            FILTER: alpha(opacity=80); /*设置成透明*/
            LEFT: 0px;
            WIDTH: 100%;
            POSITION: absolute;
            margin:0px 0px -300px 0px;
            TOP: 0px;
            HEIGHT: 100%;
            BACKGROUND-COLOR: #000;
            moz-opacity: 0.8;
            opacity: .80
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<!--该层为覆盖层 -->
<div id="overlay"></div>
<!--/该层为覆盖层 -->
<!--该层为高亮显示层 -->
<div id="lightbox" name="lightbox">
    <!--/该层为高亮显示层 -->
    <form name="form1" method="post" action="">
        <table width="100%" height="22" border="0" cellpadding="0" cellspacing="0" style="font-size:12px;">
            <tr>
                <td align="center" bgcolor="#999999">用户登录</td>
            </tr>
        </table>
        <table width="243" height="102" border="0" align="center" cellpadding="0" cellspacing="0" style="font-size:12px;">
            <tr>
                <td width="70" valign="bottom">用户名：</td>
                <td width="173" valign="bottom"><label>
                    <input type="text" name="textfield">
                </label></td>
            </tr>
            <tr>
                <td valign="bottom">密码：</td>
                <td valign="bottom"><label>
                    <input type="text" name="textfield2">
                </label></td>
            </tr>
            <tr>
                <td valign="bottom"><label>
                    <input type="submit" name="Submit" value="提交">
                </label></td>
                <td valign="bottom"><label>
                    <input name="Submit2" type="reset"  value="重置">
                </label></td>
            </tr>
        </table>

    </form>
</div>
<script>
    $(function(){
        show();
    });

    function show()
    {
        box1=document.getElementById("lightbox");
        box2=document.getElementById("overlay");
        box1.style.display='block';
        box2.style.display='block';

    }
</script>

</body>
</html>
