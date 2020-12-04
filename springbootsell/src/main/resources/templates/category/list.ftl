<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--    边栏nav-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper">
        <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th style="border: 1px solid #ddd">类目编号</th>
                                <th style="border: 1px solid #ddd">类目名字</th>
                                <th style="border: 1px solid #ddd">类目编号</th>
                                <th style="border: 1px solid #ddd">创建时间</th>
                                <th style="border: 1px solid #ddd">更新时间</th>
                            </tr>
                            </thead>
                            <tbody>

                            <#list categoryList as category>
                                <tr class="success">
                                    <td style="background-color: #ffffff;border: 1px solid #ddd">${category.categoryId}</td>
                                    <td style="background-color: #ffffff;border: 1px solid #ddd">${category.categoryName}</td>
                                    <td style="background-color: #ffffff;border: 1px solid #ddd">${category.categoryType}</td>
                                    <td style="background-color: #ffffff;border: 1px solid #ddd">${category.createTime}</td>
                                    <td style="background-color: #ffffff;border: 1px solid #ddd">${category.updateTime}</td>
                                </tr>
                            </#list>


                            </tbody>
                        </table>
                    </div>
                </div>
        </div>
    </div>

</div>
</body>
</html>