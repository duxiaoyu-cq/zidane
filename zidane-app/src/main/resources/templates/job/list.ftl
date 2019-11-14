<html>
<head>
    <title>Job List</title>
</head>
<body>
    <#if job??>
        <h1>hello ${job.name!}!</h1>
    <#else>
        <h1>hello world!</h1>
    </#if>

    <h3>${date!}</h3>
    <h3>${DateUtil.format('yyyy/MM/dd HH:mm:ss')}</h3>
</body>
</html>