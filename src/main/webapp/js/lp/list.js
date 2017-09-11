function goAddItemPage() {
    location.replace("/lp/detail");
}

function initEvent() {
    $('.btn-add-inrerested-item').on('click', function () {
        goAddItemPage();
    });

    $('.interested-item-row').on('click', function () {
        var userSeq = $('.lp-user-seq').val();
        var listItem = $(this);
        var mid = listItem.attr('data-item-mid');
        var cid = listItem.attr('data-item-cid');
        location.replace("/lp/detail?us=" + userSeq + "&mid=" + mid + "&cid=" + cid);
    });
}

$(document).ready(function () {
    initEvent();
});