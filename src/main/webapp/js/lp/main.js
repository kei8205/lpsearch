function goAddItemPage(){
    location.replace("/lp/detail");
}

function initEvent(){
    $('.btn-add-inrerested-item').on('click', function () {
       goAddItemPage();
    });
}

$(document).ready(function () {
    initEvent();
});