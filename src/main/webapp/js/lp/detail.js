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

var chartCommonOption = {
    type: 'line',
    data: {
        datasets: [{
            label: 'test',
            backgroundColor: 'rgba(0, 0, 0, 0)',
            borderColor: 'rgba(91, 192, 222, 0.8)',
            borderWidth: 1,
            pointHitRadius: 3,
            fill: true,
            lineTension: 0.2,
            spanGaps: true
        }]
    },
    options: {
        legend: {
            display: false
        },
        responsive: true,
        maintainAspectRatio: false,
        animation: false,
        tooltips: {
            callbacks: {
                label: function (tooltipItem, data) {
                    var datasetLabel = data.datasets[tooltipItem.datasetIndex].label || 'Other';
                    var value = commafy(data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index]);
                    return datasetLabel + ': ' + value + " 원";
                }
            }
        },
        scales: {
            yAxes: [{
                ticks: {
                    callback: function (value, index, values) {
                        return commafy(value) + " 원";
                    }
                }
            }]
        }
    }
};

function goListPage() {
    location.replace("/lp");
}

var chartOption = $.extend(true, {}, chartCommonOption);
chartOption.data.datasets[0].label = 'price';
var chartInstance;

function initEvent() {
    $('.btn-back-to-list').on('click', function () {
        goListPage();
    });

    var request = {};
    request.mid = $('.lp-item-mid').val();
    request.cid = $('.lp-item-cid').val();
    $.ajax({
            url: "/lp/history",
            type: 'POST',
            cache: false,
            data: $.toJSON(request),
            dataType: 'json',
            accept: "application/json",
            contentType: "application/json; charset=utf-8",

            success: function (data) {
                if (data.code !== undefined && data.code === 0) {
                    console.log(data);
                    chartOption.data.labels = data.result.labels;
                    chartOption.data.datasets[0].data = data.result.priceHistoryDatas;
                    var chart = document.getElementById('price-chart');
                    chartInstance = new Chart(chart, chartOption);
                } else {
                    alert('check shopping url');
                }
            },
            error: function (request, status, error) {
                alert('check shopping url or something');
            }
        }
    );


}

$(document).ready(function () {
    initEvent();

});