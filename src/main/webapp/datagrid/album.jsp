<%@page pageEncoding="UTF-8" %>
<script type="text/javascript">


    $(function () {
        var toolbar = [
            {
                iconCls: "icon-tip",
                text: "专辑详情",
                handler: function () {
                    var row = $("#adg").edatagrid("getSelected");
                    if (row != null) {
                        if (typeof row.id == "string") {
                            $("#ChapterAudio").dialog({
                                href: "${pageContext.request.contextPath}/datagrid/ChapterGet.jsp?url=" + row.url
                            });
                            $("#ChapterAudio").dialog("open");
                        } else {
                            $("#AlbumDialog").dialog({
                                href: "${pageContext.request.contextPath}/datagrid/albumGet.jsp?id=" + row.id
                            });
                            $("#AlbumDialog").dialog("open");s
                        }
                    } else {
                        alert("请选择专辑或音频！")
                    }
                }
            }, '-',
            {
                iconCls: "icon-add",
                text: "添加专辑",
                handler: function () {
                    $("#addAlbum").dialog("open");
                }
            }, '-',
            {
                iconCls: "icon-add",
                text: "添加音频",
                handler: function () {
                    var row = $("#adg").edatagrid("getSelected");
                    if (row != null) {
                        if(typeof row.id=="")
                        $("#addChapter").dialog({
                            href: "${pageContext.request.contextPath}/datagrid/addChapter.jsp?id=" + row.id
                        });
                        $("#addChapter").dialog("open");
                    } else {
                        alert("请选择专辑")
                    }
                }
            }, '-',
            {
                iconCls: "icon-undo",
                text: "下载音频",
                handler: function () {
                    var row = $("#adg").edatagrid("getSelected");
                    if (row != null) {
                        if (typeof row.id == "string") {
                            location.href = "${pageContext.request.contextPath}/chapter/dol?url=" + row.url
                        } else {
                            alert("请选择音频！");
                        }
                    } else {
                        alert("请先选择音频！")
                    }
                }
            }
        ]
        $('#adg').treegrid({
            url: "${pageContext.request.contextPath}/album/getAll",
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名称', width: 100, align: 'left'},
                {field: 'duration', title: '时长', width: 80, align: 'center'},
                {field: 'size', title: '大小', width: 80, align: 'center'},
                {field: 'uploadDate', title: '上架时间', width: 80, align: 'center'}
            ]],
            toolbar: toolbar,
            pagination: true,
            pageSize: 4,
            pageList: [1, 2, 4, 6],
            fitColumns: true,
            fit: true,
            onDblClickRow: function (row) {
                if (row != null) {
                    if (typeof row.id == "string") {
                        $("#ChapterAudio").dialog({
                            href: "${pageContext.request.contextPath}/datagrid/ChapterGet.jsp?url=" + row.url
                        });
                        $("#ChapterAudio").dialog("open");
                    } else {
                        $("#AlbumDialog").dialog({
                            href: "${pageContext.request.contextPath}/datagrid/albumGet.jsp?id=" + row.id
                        });
                        $("#AlbumDialog").dialog("open");s
                    }
                } else {
                    alert("请选择专辑或音频！")
                }
            }
        });
        $("#AlbumDialog").dialog({
            title: '专辑详情',
            closed: true,
            resizable: true,
            width: 1024,
            height: 768,
            href: "${pageContext.request.contextPath}/datagrid/albumGet.jsp"
        });
        $("#addAlbum").dialog({
            title: '添加专辑',
            closed: true,
            resizable: true,
            width: 400,
            height: 280,
            href: "${pageContext.request.contextPath}/datagrid/addAlbum.jsp"
        });
        $("#addChapter").dialog({
            title: '添加音频',
            closed: true,
            resizable: true,
            width: 400,
            height: 280,
            href: "${pageContext.request.contextPath}/datagrid/addChapter.jsp"
        });
        $("#ChapterAudio").dialog({
            title: '音频播放',
            closed: true,
            resizable: true,
            width: 335,
            height: 70,
            href: "${pageContext.request.contextPath}/datagrid/ChapterGet.jsp"
        });

    })

</script>
<table id="adg"></table>
<div id="AlbumDialog"></div>
<div id="addAlbum"></div>
<div id="addChapter"></div>
<div id="ChapterAudio"></div>

