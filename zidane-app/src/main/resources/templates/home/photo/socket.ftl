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
                    <div class="col-sm-11">
                        <input id="text" type="text" />
                        <button onclick="send()">Send</button>
                        <button onclick="closeWebSocket()">Close</button>
                        <div id="message">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../../layout/footer.ftl"/>
<script>
    var userID="888";
    var websocket=null;
    $(function(){
        connectWebSocket();
    })
    //建立WebSocket连接
    function connectWebSocket(){
        console.log("开始连接...");
        //建立webSocket连接
        websocket = new WebSocket("ws://127.0.0.1:8888/myHandler/ID="+userID);
        console.log("连接完成...");
        //打开webSokcet连接时，回调该函数
        websocket.onopen = function () {
            console.log("onpen");
        }
        //关闭webSocket连接时，回调该函数
        websocket.onclose = function () {
            //关闭连接
            console.log("onclose");
        }
        //接收信息
        websocket.onmessage = function (msg) {
            console.log(msg.data);
        }
    }

    //发送消息
    function send(){
        var postValue={};
        postValue.id=userID;
        postValue.message=$("#text").val();
        websocket.send(JSON.stringify(postValue));
    }

    //关闭连接
    function closeWebSocket(){
        if(websocket != null) {
            websocket.close();
        }
    }
</script>
</body>
</html>
