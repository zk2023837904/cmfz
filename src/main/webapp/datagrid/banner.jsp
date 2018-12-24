<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">
    $(function () {
        var toolbar = [{
            iconCls: "icon-add",
            text: "添加",
            handler: function () {
                $("#addBanner").dialog("open");
            }
        }, '-', {
            iconCls: "icon-edit",
            text: "修改",
            handler: function () {

                var row = $("#bdg").edatagrid("getSelected");
                if (row != null) {
                    //编辑指定行
                    var index = $("#bdg").edatagrid("getRowIndex", row);
                    $("#bdg").edatagrid("editRow", index);
                } else {
                    alert("请先选中行")
                }
            }
        }, '-', {
            iconCls: "icon-remove",
            text: "删除",
            handler: function () {
                var row = $("#bdg").edatagrid("getSelected");

                if (row != null) {

                    $.messager.confirm("确认对话框", "是否删除", function (r) {
                        if (r) {
                            $.ajax({
                                type: "GET",
                                url: "${pageContext.request.contextPath }/banner/delete",
                                data: "id=" + row.id + "&imgPath=" + row.imgPath,
                                dataType: "JSON",
                                success: function (result) {
                                    $.messager.show({
                                        title: "标题",
                                        msg: "删除成功！"
                                    });
                                    $("#bdg").edatagrid("load");
                                }
                            });
                        }
                    });
                } else {
                    alert("请选中目标！")
                }

            }
        }, '-', {
            iconCls: "icon-save",
            text: "保存",
            handler: function () {
                $("#bdg").edatagrid("saveRow");
            }
        }
        ];
        $('#bdg').edatagrid({
            url: '${pageContext.request.contextPath}/banner/getAll',
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            destroyUrl: "${pageContext.request.contextPath}/banner/delete",
            columns: [[
                {field: 'title', title: '名称', width: 100, align: 'center'},
                {
                    field: 'status', title: '状态', width: 100, align: 'center', editor: {
                        type: "text", options: {required: true}
                    }
                },
                {field: 'pubDate', title: '时间', width: 100, align: 'center'}
            ]],
            pagination: true,
            pageSize: 4,
            pageList: [1, 2, 4, 6],
            toolbar: toolbar,
            fitColumns: true,
            fit: true,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="' + "${pageContext.request.contextPath}" + rowData.imgPath + '" style="height:120px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addBanner").dialog({
            title: '添加图片',
            closed: true,
            resizable: true,
            width: 400,
            height: 280,
            href: "${pageContext.request.contextPath}/datagrid/addBanner.jsp"
        });
    })

</script>
<table id="bdg"></table>
<div id="addBanner"></div>