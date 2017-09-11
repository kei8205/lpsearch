<!DOCTYPE html>
<html>
<head>
    <title>low price searcher : detail</title>
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
    <script type='text/javascript' src="/js/lp/register.js?ts=20170830000001"></script>
</head>
<body>
<div class="container-fluid">
    <hr/>
    <div class="row">
        <div class="col-md-10">
            <input type="hidden" class="lp-user-seq" value="${user.seq}">
        </div>
        <div class="col-md-2">
            <button class="btn-back-to-list btn btn-block btn-outline-primary">to list</button>
        </div>
    </div>
    <hr/>

    <div class="input-group">
        <span class="input-group-addon">http://shopping.naver.com/detail/detail.nhn?</span>
        <input class="input-shop-url form-control" type="text">
        <button class="btn-check-naver-shopping-url btn btn-warning">check</button>
    </div>

    <hr/>

    <div class="item-check-container">
    </div>
</div>
</body>

<script id="check-item" type="x-tmpl-mustache">
<div class="root-register-item row flex-row align-items-center"
data-item-cid='{{cid}}'
data-item-mid='{{mid}}'
data-item-title='{{title}}'
data-item-thumb='{{thumbUrl}}'
data-item-initial-price='{{initPrice}}'>
    <div class="col-md-3"></div>
    <div class="col-md-2"><img class="img-fluid" src="{{thumbUrl}}"></div>
    <div class="col-md-5">
        <div class="d-flex">{{title}}</div>
        <div class="d-flex">{{formatted_init_price}}원</div>
    </div>
    <div class="col-md-2"><button class="btn-item-register btn btn-block btn-outline-primary"> + save</button></div>
</div>
</script>
</html>