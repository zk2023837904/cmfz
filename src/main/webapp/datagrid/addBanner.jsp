<%@page pageEncoding="utf-8" %>
<script type="text/javascript">
    $(function () {

        $("#bt").textbox({
            required: true
        });
        $("#bs").textbox({
            required: true
        });
        // 初始化 表单控件-密码
        $("#bd").textbox({
            required: true,
        });
        $("#bp").datebox({
            required: true,
            formatter: function (date) {
                var y = date.getFullYear();
                var m = date.getMonth() + 1;
                var d = date.getDate();
                return y + "-" + m + "-" + d;
            },
            parser: function (s) {
                var t = Date.parse(s);
                if (!isNaN(t)) {
                    return new Date(t);
                } else {
                    return new Date();
                }
            }
        });


        $("#bok").linkbutton({
            iconCls: "icon-save",
            plain: true,
            onClick: function () {
                $.messager.confirm("确认对话框", "是否添加", function (r) {
                    if (r) {
                        $("#addBannerform").form("submit", {
                            url: "${pageContext.request.contextPath }/banner/insert",
                            onSubmit: function () {
                                return $("#addBannerform").form("validate");
                            },
                            success: function () {
                                $("#addBanner").dialog("close");
                                $.messager.show({
                                    title: "标题",
                                    msg: "保存成功！"
                                });
                                $("#bdg").edatagrid("reload");
                            }
                        });
                        $("#addBannerform").form("clear");
                    }
                });
            }
        });
    });
</script>
<form id="addBannerform" method="post" enctype="multipart/form-data">
    名称：<input id="bt" name="title"/></br>
    图片：<input id="bi" type="file" name="file1"/></br>
    状态：<input id="bs" name="status"/></br>
    日期：<input id="bp" name="pubDate"/></br>
    描述：<input id="bd" name="description"/></br>

    <a id="bok"/>
</form>

