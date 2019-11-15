<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Photos Robots</title>
    <#include "../../layout/head.ftl" />
</head>

<body>

<#include "../../layout/header.ftl" />
<div class="container-fluid">
    <div class="row">
        <#include "../../layout/menu.ftl" />

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="sub-header">Section title</h1>
            <div class="form-horizontal">
                <div class="form-group form-group-lg">
                    <label class="col-sm-1 control-label" for="formGroupInputLarge">Dir</label>
                    <div class="col-sm-11">
                        <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../../layout/footer.ftl"/>
<script>
    $('#fileFolderMore').change(function(e){
        // console.log(e)
        var files = e.target.files;
        var tar = e.target;
        console.log(tar.value)
        console.log(files)
    })
    $('#fileFolderOne').change(function(e){
        // console.log(e)
        var files = e.target.files;
        console.log(files)
    })

</script>
</body>
</html>
