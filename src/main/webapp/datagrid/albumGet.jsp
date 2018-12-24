<%@page pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">

    $(function () {
        $("#Album").datagrid({
            fitColumns: true,
            url: "${pageContext.request.contextPath }/album/getOne?id=" + $("#Albumid").val(),
            title: "显示所有",
            fit: true,
            iconCls: "icon-man"
        });
    })

    function myCoverImage(value, row, index) {
        console.log(row)
        return "<img src='${pageContext.request.contextPath}" + row.coverImg + "' width='100px'  height='120px' ,></img >";
    }
</script>

<input type="text" id="Albumid" hidden="hidden" value="${param.id}"/>
<table id="Album">
    <thead>
    <tr>
        <th data-options="field:'title',width:10,">名称</th>
        <th data-options="field:'count',width:10">集数</th>
        <th data-options="field:'score',width:10">评分</th>
        <th data-options="field:'author',width:10">作者</th>
        <th data-options="field:'broadcast',width:10">播音</th>
        <th data-options="field:'pubDate',width:10">日期</th>
        <th data-options="field:'brief',width:20">内容</th>
        <th data-options="field:'xxx',width:20,formatter:myCoverImage">图片</th>
    </tr>
    </thead>
</table>
