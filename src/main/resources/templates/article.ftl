<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>show article</title>
    <link rel="stylesheet" href="${re.contextPath}/markdown/css/editormd.preview.min.css" />
    <link rel="stylesheet" href="${re.contextPath}/markdown/css/editormd.css"/>
</head>
<body>
<div id="editormd-html">
    　　<textarea style="display:none;" placeholder="markdown语言">${article.articleContent!''}</textarea>
</div>

<script src="${re.contextPath}/js/jquery.min.js"></script>
<script src="${re.contextPath}/markdown/lib/marked.min.js"></script>
<script src="${re.contextPath}/markdown/lib/prettify.min.js"></script>
<script src="${re.contextPath}/markdown/lib/raphael.min.js"></script>
<script src="${re.contextPath}/markdown/lib/underscore.min.js"></script>
<script src="${re.contextPath}/markdown/lib/sequence-diagram.min.js"></script>
<script src="${re.contextPath}/markdown/lib/flowchart.min.js"></script>
<script src="${re.contextPath}/markdown/lib/jquery.flowchart.min.js"></script>
<script src="${re.contextPath}/markdown/js/editormd.js"></script>

<script type="text/javascript">
    editormd.markdownToHTML("editormd-html", {
        htmlDecode      : "style,script,iframe",
        emoji           : true,
        taskList        : true,
        tex             : true,  // 默认不解析
        flowChart       : true,  // 默认不解析
        sequenceDiagram : true  // 默认不解析
    });
</script>
</body>
</html>