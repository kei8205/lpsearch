<!DOCTYPE html>
<html>
<head>
    <title>low price searcher : list</title>
    <meta http-equiv="Expires" content="-1">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="No-Cache">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="/css/bootstrap.min.css?ts=20170830000001">
    <script type='text/javascript' src="/js/libs/jquery-3.2.1.min.js?ts=20170830000001"></script>
    <script type='text/javascript' src="/js/libs/jquery.json.js?ts=20170830000001"></script>
    <script type='text/javascript' src="/js/libs/popper.min.js?ts=20170830000001"></script>
    <script type='text/javascript' src="/js/libs/mustache.min.js?ts=20170830000001"></script>
    <script type='text/javascript' src="/js/libs/bootstrap.min.js?ts=20170830000001"></script>
    <script type='text/javascript' src="/js/lp/list.js?ts=20170830000001"></script>
</head>
<body>
<div class="container-fluid">
    <hr/>
    <div class="row">
        <div class="col-md-10">
            <input type="hidden" class="lp-user-seq" value="${user.seq}">
        </div>
        <div class="col-md-2">
            <button class="btn-add-inrerested-item btn btn-block btn-outline-warning">+ item</button>
        </div>
    </div>
    <hr/>
<#list interestedItemList as item>
    <div class="interested-item-row row flex-row align-items-center"
         data-item-cid='${item.cid?c}'
         data-item-mid='${item.mid?c}'
         style="cursor: pointer">
        <div class="col-md-2"><img class="img-fluid" src="${item.thumbUrl}"></div>
        <div class="col-md-8">
            <div class="d-flex">${item.title}</div>
            <div class="d-flex">등록 당시 : ${item.initialLowPrice}원</div>
            <div class="d-flex">현재 최저 : ${item.legendaryPrice}원 @${item.legendaryPriceDatetime?datetime}</div>
        </div>
        <div class="col-md-2">
            <#if item.active>
                <button class="btn-item-register btn btn-block btn-outline-primary" disabled>notify : activate</button>
            <#else>
                <button class="btn-item-register btn btn-block btn-outline-secondary" disabled>notify : deactivate</button>
            </#if>
        </div>
    </div>
    <hr/>
</#list>
</div>
</body>
</html>