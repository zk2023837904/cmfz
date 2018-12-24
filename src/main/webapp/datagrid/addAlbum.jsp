<%@page pageEncoding="utf-8"  isELIgnored="false" %>
<script type="text/javascript">
    $(function () {

        $("#at").textbox({
            required: true
        });
        $("#ac").textbox({
            required: true
        });
        // 初始化 表单控件-密码
        $("#as").textbox({
            required: true
        });
        $("#aa1").textbox({
            required: true
        });
        $("#ab").textbox({
            required: true
        });
        $("#ab1").textbox({
            required: true
        });
        $("#ap").datebox({
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
        $("#aaok").linkbutton({
            iconCls: "icon-save",
            plain: true,
            onClick: function () {
                $.messager.confirm("确认对话框", "是否添加", function (r) {
                    if (r) {
                        $("#addAlbumForm").form("submit", {
                            url: "${pageContext.request.contextPath}/album/insert",
                            onSubmit: function () {
                                return $("#addAlbumForm").form("validate");
                            },
                            success: function () {
                                $("#addAlbum").dialog("close");
                                $.messager.show({
                                    title: "标题",
                                    msg: "保存成功！"
                                });
                                $("#adg").treegrid("reload");
                            }
                        });
                        $("#addAlbumForm").form("clear");
                    }
                });
            }
        });
    });
</script>
<form id="addAlbumForm" method="post" enctype="multipart/form-data">
    名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<input id="at" name="title"/></br>
    章节数量:<input id="ac" name="count"/></br>
    图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:<input id="ai" type="file" name="file1"/></br>
    评&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;分:<input id="as" name="score"/></br>
    作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者:<input id="aa1" name="author"/></br>
    播&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;音:<input id="ab" name="broadcast"/></br>
    简&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;介:<input id="ab1" name="brief"/></br>
    日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期:<input id="ap" name="pubDate"/></br>
    <a id="aaok"/>
</form>

