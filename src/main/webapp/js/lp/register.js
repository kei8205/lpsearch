var checkedItemTemplate;

function commafy(num) {
    num = num || 0;
    scale = 2;

    var parts = ('' + num).split('.');
    var decimal = parts[0];
    var precision = parts[1] != undefined ? parts[1] : '';
    var i = L = decimal.length;
    var output = '';

    while (i--) {
        output = (i === 0 ? '' : ((L - i) % 3 ? '' : ',')) + decimal.charAt(i) + output;
    }

    if (precision.length > scale) {
        precision = precision.substr(0, scale);
    }

    if (precision != '') {
        output += '.' + precision;
    }

    return output;
}

function goListPage() {
    location.replace("/lp");
}

function drawCheckedItemInfo(result) {
    var checkedItemContainer = $('.item-check-container');
    checkedItemContainer.empty();

    var checkedItem = {};
    checkedItem.thumbUrl = result.thumbUrl;
    checkedItem.title = result.title;
    checkedItem.initPrice = result.initialLowPrice;
    checkedItem.formatted_init_price = commafy(result.initialLowPrice);
    checkedItem.cid = result.cid;
    checkedItem.mid = result.mid;

    var rendered = Mustache.render(checkedItemTemplate, checkedItem);
    checkedItemContainer.append(rendered);
}

function initRequiredElement() {
    checkedItemTemplate = $('#check-item').html();
    if (checkedItemTemplate !== undefined) {
        Mustache.parse(checkedItemTemplate);
    }
}

function initEvent() {
    $('.btn-back-to-list').on('click', function () {
        goListPage();
    });

    $('.btn-check-naver-shopping-url').on('click', function () {
        var targetUrl = $('.input-shop-url').val();
        var request = {};
        request.target = targetUrl;
        $.ajax({
                url: "/lp/check",
                type: 'POST',
                cache: false,
                data: $.toJSON(request),
                dataType: 'json',
                accept: "application/json",
                contentType: "application/json; charset=utf-8",

                success: function (data) {
                    if (data.code !== undefined && data.code === 0) {
                        drawCheckedItemInfo(data.result);
                    } else {
                        alert('check shopping url');
                    }
                },
                error: function (request, status, error) {
                    alert('check shopping url or something');
                }
            }
        );
    });

    $('.item-check-container').on('click','.btn-item-register', function () {
        var userSeq = $('.lp-user-seq').val();
        var itemInfo = $('.root-register-item');
        var request = {};
        request.userSeq = userSeq;
        request.mid = itemInfo.attr('data-item-mid');
        request.cid = itemInfo.attr('data-item-cid');
        request.title = itemInfo.attr('data-item-title');
        request.thumbUrl = itemInfo.attr('data-item-thumb');
        request.initialLowPrice = itemInfo.attr('data-item-initial-price');

        $.ajax({
                url: "/lp/add",
                type: 'POST',
                cache: false,
                data: $.toJSON(request),
                dataType: 'json',
                accept: "application/json",
                contentType: "application/json; charset=utf-8",

                success: function (data) {
                    if (data.code !== undefined && data.code === 0) {
                        goListPage();
                    } else {
                        alert('check shopping url');
                    }
                },
                error: function (request, status, error) {
                    alert('check shopping url or something');
                }
            }
        );
    });
}

$(document).ready(function () {
    initRequiredElement();
    initEvent();
});