var $viframe = null, $iframe;
var $ep = null;

$(function () {
    $viframe = $("#videoIframe"); $iframe = $('#iframe');
    $('.video-info .title').html(res.title+"&nbsp;&nbsp;<span></span>");
    $ep = $('.video-info>.title span');

    // 集数排序 对于番剧： 第(\d+)集 > OVA(\d+) > SP(\d+) > 备用(\d+)
    // 对于剧场版：　正片 > 备用
    var dict = {'第': 0, 'O': 1, 'S': 2, '正': 3, '备':4};
    res.episodeList.sort(function (r0, r1) {
        var c0 = r0.ind.charAt(0), c1 = r1.ind.charAt(0);
        if(c0==c1){
            var reg = /(\d+\.?\d?).*?(\d+\.?\d?)/;
            if (!reg.test(r0.ind+r1.ind))
                return 0;
            return RegExp.$1-RegExp.$2;
        }
        return dict[c0]-dict[c1];
    });

    if(!cv || cv>=res.episodeList.length)
        cv = 0;
    $iframe.attr('src', res.episodeList[cv].src);
    $ep.text(res.episodeList[cv].ind);

    var $eps = $(".episodes");
    for (let r of res.episodeList){
    $eps.append('<div class="episode">' +
                    '<button class="btn btn-block" name="'+r.src+'" onclick="play(this)">'+r.ind+'</button>' +
                '</div>');
    }

    // getComment(res.id);
});

function play(btn) {
    if($viframe==null) return;
    $viframe.html('<iframe id="iframe" src="'+btn.name+'" frameborder="0"' +
        '            class="auto-adjust auto-ratio" webkitallowfullscreen="" mozallowfullscreen="" allowfullscreen="">' +
        '          </iframe>');
    $('.episode>.btn').css('color', 'black');
    $(btn).css('color', '#fd4c5c');
    $ep.text(btn.innerText);
};



function getComment(aid){
    $.get('/bangumi/comment', {aid: aid}, function (pageRes) {
        var commentList = $('.commentList');
        for(let r of pageRes.content){
            var commentDiv = $('<div class="commentDiv">\n' +
                '                   <img src="'+r.cpic+'" alt="" class="img-circle">\n' +
                '                   <h5><a href="/user/'+r.cuserId+'">'+r.cuser+'</a> <i style="">发表于'+r.ctime+'</i></h5>\n' +
                '               </div>');
            var comment = $('            <div class="comment">\n' +
                '                        <div class="text">'+r.ctext+'</div>\n' +
                '                        <i value=0>展开 <li class="glyphicon glyphicon-menu-down"></li></i>\n' +
                '                        <div class="starAndrepaly"><a class="star"><li class="glyphicon glyphicon-thumbs-up"></li> '+r.stars+'赞</a><a class="reply" style="margin-left: 15px;"><li class="glyphicon glyphicon-comment"></li> 回复</a>\n' +
                '                            <div class="replyDiv" value=0>\n' +
                '                                <textarea rows="4" placeholder="回复 @'+r.cuser+'"></textarea>\n' +
                '                                <a class="btn btn-danger">回复</a>\n' +
                '                            </div>\n' +
                '                        </div>\n' +
                '                        </div>');


            $.get('/bangumi/reply', {cid: r.cid}, function (res) {
                console.log(res);
                for(let r of res){
                    comment.append('<div class="commentDiv">\n' +
                        '                            <img src="'+r.cpic+'" alt="" class="img-circle">\n' +
                        '                            <h5><a href="/user/'+r.cuserId+'">'+r.cuser+'</a> <i style="">发表于'+r.ctime+'</i></h5>\n' +
                        '                            <div class="comment">\n' +
                        '                                <div class="text">回复 <a href="/user/'+r.ruserId+'">@ '+r.ruser+'：</a><br>'+r.ctext+'</div>\n' +
                        '                                <i value=0>展开 <li class="glyphicon glyphicon-menu-down"></li></i>\n' +
                        '                                <div class="starAndrepaly"><a class="star"><li class="glyphicon glyphicon-thumbs-up"></li> '+r.stars+'赞</a><a class="reply" style="margin-left: 15px;"><li class="glyphicon glyphicon-comment"></li> 回复</a>\n' +
                        '                                    <div class="replyDiv" value=0>\n' +
                        '                                        <textarea rows="4" placeholder="回复 @'+r.cuser+'"></textarea>\n' +
                        '                                        <a class="btn btn-danger">回复</a>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                            </div>\n' +
                        '                        </div>')
                }
            },'json');

            commentDiv.append(comment);
            commentList.append(commentDiv);


            var page = $('           <ul class="pager">\n' +
                '                        <li><a href="javascript:void(0);" class="front"><span aria-hidden="true"></span>上一页</a></li>&nbsp;&nbsp;\n' +
                '                        <li><a href="javascript:void(0);" class="next">下一页<span aria-hidden="true"></span></a></li>\n' +
                '                        <li style="float: right">当前第'+pageRes.pageNum+'页，共'+pageRes.totalPages+'页/'+pageRes.totalSize+'个, 跳至<input onkeyup="this.value=this.value.replace(/\\D/g,\'\')" onafterpaste="this.value=this.value.replace(/\\D/g,\'\')" type="text">页</li>\n' +
                '                    </ul>')

            commentList.append()
        }
    }, 'json')
}

