<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8"/>
    <title>iMarkdown, a free markdown online!</title>
    <link rel="stylesheet" href="${re.contextPath}/markdown/css/style.css"/>
    <link rel="stylesheet" href="${re.contextPath}/markdown/css/editormd.css"/>
</head>
<body>
<div id="layout">
    <div id="test-editormd">
        <textarea style="display:none;" id="textContent" name="textContent"></textarea>
        <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
        <textarea id="text" class="editormd-html-textarea" name="text"></textarea>
    </div>
</div>
<div>
    <button onclick="saveHtml()">保存</button>
</div>
<script src="${re.contextPath}/js/jquery.min.js"></script>
<script src="${re.contextPath}/markdown/js/editormd.js"></script>
<script type="text/javascript">
    var testEditor;

    $(function () {
        testEditor = editormd("test-editormd", {
            width: "90%",
            height: 640,
            syncScrolling: "single",
            path: "${re.contextPath}/markdown/lib/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/image",
            emoji: true,
            tex:true,
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            saveHTMLToTextarea: true
            // previewTheme : "dark"
        });
        editormd.katexURL = {
            js  : "/katex/katex",
            css : "/katex/katex"
        };
    });

    function saveHtml() {
        // console.log($("#text").text());
        console.log($("#textContent").text());
        $.ajax({
            url: "${re.contextPath}/imarkdown/insert",
            type: "post",
            async: true,
            data: {
                "articleContent": $("#textContent").text(),
                "articleHtml": $("#text").text()
            },
            dataType: "json",
            success: function (data) {
            alert(data.msg);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus); // paser error;
            }
        });
    }
</script>
</body>
</html>