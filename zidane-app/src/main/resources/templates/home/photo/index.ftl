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
            <h1 class="sub-header">Choose Directory</h1>
            <div class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-12">
                        <div class="input-group">
                            <input name="dirPath" type="text" class="form-control" aria-label="...">
                            <div class="input-group-btn">
                                <button id="startAnalysis" class="btn btn-success" type="button">Start Analysis</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="analysisModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                    <p>One fine body&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div><!-- /.modal-content -->
        </div>
    </div>

</div>
<#include "../../layout/footer.ftl"/>
<script>
    $("#startAnalysis").click(function () {
        $("#analysisModal").modal('show');
        if($("#dirPath").val()) {
            $.get("startAnalysis",{dirPath:$("#dirPath").val()}, function(data,status) {

            });
        }

    })
</script>
</body>
</html>
