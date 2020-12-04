<html>
<#include "../common/header.ftl">

<body>
<div class="box">
    <form action="/seller/admin/load_login"  accept-charset="utf-8" method="post">
        <div><h1></h1></div>
        <div class="item">
            <label class="label-tips" for="adminName">用户名</label>
            <input type="text" id="u" name="adminName" />
        </div>
        <div class="item">
            <label class="label-tips" for="password">密码:</label>
            <input type="password" id="password" name="password"  />
        </div>
        <input type="submit" name="登录" class="submit"/>
        <a href="/seller/admin/register" target="_blank">注册</a>
    </form>
</div>

</body>
</html>