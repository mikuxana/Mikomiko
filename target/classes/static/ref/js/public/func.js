if(!sta) $.post('/statistic/insert/'+res.id, function (res) {
    console.log(res);
});

sendToIframe();

$.post('/statistic/views/'+res.id+'/'+(parseInt($('#views').text())+1));

$('#stars').click(function () {
    var pre = $(this).prev();
    pre.text(parseInt(pre.text())+1);
}).mouseout(function () {
    $.post('/statistic/stars/'+res.id+'/'+$(this).prev().text());
});

