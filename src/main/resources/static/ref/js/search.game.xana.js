
function write(res){
    for(var r of res)
        $('.col-sm-9').append('<div class="galDiv">\n' +
            '            <p>'+r.title+'</p>' +
            '            <ul>\n' +
            '                <a href="javascript:void(0);"><li class="glyphicon glyphicon-calendar"></li>'+r.sellDate+'</a>\n' +
            '                <a href="javascript:void(0);"><li class="glyphicon glyphicon-tags"></li>'+r.tags+'</a>\n' +
            '                <a href="javascript:void(0);"><li class="glyphicon glyphicon-eye-open"></li>'+r.views+'℃</a>\n' +
            '                <a href="javascript:void(0);"><li class="glyphicon glyphicon-comment"></li>'+r.comments+'</a>\n' +
            '            </ul>\n' +
            '            <div class="img">\n' +
            '                <a class="auto-adjust" href="/game/gal/'+r.id+'" title="'+r.title+'" target="_blank">\n' +
            '                    <img src="'+r.pic+'" alt="" class="auto-width">\n' +
            '                    <div class="auto-adjust des">\n' +
            '                        <span>'+r.des1+'</span>\n' +
            '                    </div>\n' +
            '                </a>\n' +
            '            </div>\n' +
            '        </div>');
}

$(function () {

    console.log(res);
/*    write(res.content);

    var path = location.pathname, next=res.pageNum+1, prev=res.pageNum-1, reg = /\/page\/\d+$/;
    var nextHref = reg.test(path)? path.replace(reg, '/page/'+next): path+'/page/'+next;
    var prevHref = path.replace(reg, '/page/'+prev);

    nextHref = nextHref.replace(/\/\/+/g, '/');
    prevHref = prevHref.replace(/\/\/+/g, '/');
    $('.next').attr('href', nextHref).click(function () {
        if(next>res.totalPages) {
            $(this).attr('href', 'javascript:void(0);');
            alert('もう最後のページでございますよね！');
        }
    });
    $('.front').attr('href', prevHref).click(function () {
        if(prev<1) {
            $(this).attr('href', 'javascript:void(0);');
            alert('もう最初のページでございますよね！');
        }
    });*/


});
