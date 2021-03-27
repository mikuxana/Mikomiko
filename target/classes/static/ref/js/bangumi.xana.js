var filterDiv = {
    type: ['全部', '恋爱', '校园', '战斗', '热血', '奇幻', '搞笑', '冒险', '青春',
        '萌系', '催泪', '治愈', '猎奇', '伪娘', '后宫', '百合', '萝莉', '魔法', '异世界', '美少女'],
    status: ['全部', '连载中', '已完结', '即将上映'],
    area:['全部', '日本', '国产', '欧美'],
    yyyy: ['全部', 2020, 2019, 2018, 2017, 2016, 2015, 2014, 2013, 2012, '更早'],
    ssss: ['全部', '1月', '4月', '7月', '10月'],
};

function urlVarRep(vars, val, flag) {
    var r1 = new RegExp("&+"+vars+'=[^&]*'), r2 = new RegExp('^\\?+'+vars+'=[^&]*');
    var st = location.search;
    if (flag) st = urlVarRep('page', 1, false);
    if(val=='全部') {
        if(!st)
            return st;
        if (r1.test(st))
            return st.replace(r1, '');
        return st.replace(r2, '?');
    }
    var reg = new RegExp(vars+'=[^&]*'), s = vars+"="+val;
    if(reg.test(st))
        return st.replace(reg, s);
    return st? st+"&"+s:"?"+s;
}
function getUrlVars(url) {
    var hash;
    var myJson = {};
    var hashes = url.slice(url.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        myJson[hash[0]] = hash[1];
    }
    return myJson;
}

$(function () {
    var vars = getUrlVars(location.search);
    for(var k in filterDiv){
        var $dd =  $('.filter-box dl .'+k);
        for(var f of filterDiv[k]) {
            $a = $("<a>" + f + "</a>");
            if(vars[k]&&vars[k]==encodeURI(f) || !vars[k]&&f=='全部')
                $a.addClass('on');
            $dd.append($a);
        }
    };

/*    var $main = $('.main');
    var rs = res.content;
    $row = $('<div class="row"></div>');
    $col = $('<div class="col-sm-6 no-padding"></div>');
    for(var i=0; i<rs.length; ++i){
        $e = $('         <div class="bangumi-card">\n' +
            '                <a href="/bangumi/'+rs[i].id+'" class="auto-adjust auto-ratio" target="_blank" title="'+rs[i].title+'">\n' +
            '                    <img class="auto-width" src="'+rs[i].pic+'" title="'+rs[i].title+'">\n' +
            '                    <h5>'+rs[i].title+'</h5>\n' +
            '                </a>\n' +
            '            </div>');

        $col.append($e);
        if((i+1)%3==0) {
            $row.append($col);
            $col = $('<div class="col-sm-6 no-padding"></div>');
        }
        if((i+1)%6==0){
            $main.append($row);
            $row = $('<div class="row"></div>');
        }
    }
    $row.append($col);
    $main.append($row);*/
/*    $main.append('<ul class="pager">\n' +
        '        <li><a href="javascript:void(0);" class="front"><span aria-hidden="true">&larr;</span> 上一页</a></li>&nbsp;&nbsp;\n' +
        '        <li><a href="javascript:void(0);" class="next">下一页 <span aria-hidden="true">&rarr;</span></a></li>\n' +
        '        <li style="float: right">当前第'+res.pageNum+'页，共'+res.totalPages+'页/'+res.totalSize+'个, 跳至<input onkeyup="this.value=this.value.replace(/\\D/g,\'\')" onafterpaste="this.value=this.value.replace(/\\D/g,\'\')" type="text">页</li>\n' +
        '    </ul>');*/

    var $filterBox = $('.filter-box');
    var height = $filterBox.innerHeight();
    var $switch = $(".switcher");
    $switch.click(function () {
        if($switch.text()=='收起'){
            $switch.text('展开');
            $filterBox.animate({
                height: 0
            })
        }else {
            $switch.text('收起');
            $filterBox.animate({
                height: height
            })
        }
    });
    $('.filter-box a').click(function () {
        location.search = urlVarRep($(this).parent().attr('class'), $(this).text(), true);
        // $(this).attr('href', href);
    });
    $('.next').click(function () {
        if(res.pageNum+1>res.totalPages){
            alert('もう最後のページでございますよね！');
            return;
        }
        $(this).attr('href', urlVarRep('page', res.pageNum+1, false));

    });
    $('.prev').click(function () {
        if(res.pageNum-1<1){
            alert('もう最初のページでございますよね！');
            return;
        }
        $(this).attr('href', urlVarRep('page', res.pageNum-1, false));
    });


    $('.pager>li>input').keydown(function (event) {
        if(event.keyCode==13){
            location.search =  urlVarRep('page', $(this).val(), false);
        }
    });
});