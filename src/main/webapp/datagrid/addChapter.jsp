<%@page pageEncoding="utf-8"  isELIgnored="false" %>
<script type="text/javascript">
    $(function () {

        $("#ct").textbox({
            required: true
        });
        $("#cs").textbox({
            required: true
        });
        // 初始化 表单控件-密码
        $("#cd").textbox({
            required: true
        });
        $("#cu").datebox({
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
        $("#cpd").combobox({
            editable:false,
            url:"${pageContext.request.contextPath }/album/getOne?id=" + $("#ChapterId").val(),
            textField:"title",
            valueField:"id",
            readOnly:true,
            onLoadSuccess:function(){
                $("#cpd").combobox("select",$("#ChapterId").val());
            }
        });
        $("#cok").linkbutton({
            iconCls: "icon-save",
            plain: true,
            onClick: function () {
                $.messager.confirm("确认对话框", "是否添加", function (r) {
                    if (r) {
                        $("#addChapterForm").form("submit", {
                            url: "${pageContext.request.contextPath}/chapter/insert",
                            onSubmit: function () {
                                return $("#addChapterForm").form("validate");
                            },
                            success: function () {
                                $("#addChapter").dialog("close");
                                $.messager.show({
                                    title: "标题",
                                    msg: "保存成功！"
                                });
                                $("#adg").treegrid("reload");
                            }
                        });
                        $("#addChapterForm").form("clear");
                    }
                });
            }
        });
    });
</script>
<form id="addChapterForm" method="post" enctype="multipart/form-data">
    名称:<input id="ct" name="title"/></br>
    大小:<input id="cs" name="size"/></br>
    时长:<input id="cd" name="duration"/></br>
    日期:<input id="cu" name="uploadDate"/></br>
    专辑:<input id="cpd" name="Alubm.id"  /><br/>
    音频:<input id="cf" type="file" name="file1"/></br>
    <input type="text" id="ChapterId" name ="chapterid" hidden="hidden" value="${param.id}"/>
    <a id="cok"/>
</form>

