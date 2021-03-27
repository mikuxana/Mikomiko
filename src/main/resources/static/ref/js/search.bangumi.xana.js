$(function () {
    console.log(res);
    // var $con = $(".main");
    // for (let r of res.content){
    //     $con.append(item(r));
    // }
    // pager($con, 'rgba(255,255,255,0.7)');
    // pageJs();
});
function a(obj){
    var obj = $(obj);
    if(obj.text()=='展开'){
        obj.text('收起');
        var prev = obj.prev();
        prev.css('display', 'inline');
        prev.prev().css('display', 'none');
    }else {
        obj.text('展开');
        var prev = obj.prev();
        prev.css('display', 'none');
        prev.prev().css('display', 'inline');
    }
};
// function item(bangumi){
//     return "<div class=\"auto-width-height-ratio\">\n" +
//         "        <div class=\"auto-adjust auto-ratio\">\n" +
//         "            <a href='/bangumi/"+bangumi.id+"' target='_blank' title='"+bangumi.title+"'>\n" +
//         "                <div  class=\"pic auto-height\" style=\"background-image: url('"+bangumi.pic+"');\">\n" +
//         "                </div>\n" +
//         "            </a>\n" +
//         "            <div class=\"divinfo\">\n" +
//         "                <a href='/html/cv.html?id="+bangumi.id+"&title="+bangumi.title+"' style=\"text-decoration: none;\">\n" +
//         "                    <div class=\"title\">\n" +
//         bangumi.title +
//         "                    </div>\n" +
//         "                </a>\n" +
//         "                <div class=\"info\">\n" +
//         "                    <span>类型: <span>"+bangumi.type+"</span></span><br>\n" +
//         "                    <span>地区: <span>"+bangumi.area+"</span></span><br>\n" +
//         "                    <span>年份: <span>"+bangumi.yyyy+"</span></span><br>\n" +
//         "                    <span>简介:\n" +
//         "                    <span>\n" + bangumi.des1+
//         "                    </span>\n" +
//         "                     <span style=\"display: none\">\n" + bangumi.des2+
//         "                    </span>\n" +
//         "                    <a href='javascript:void(0);' onclick=\"a(this)\" style=\"text-decoration: none;\">展开</a>\n" +
//         "                </span>\n" +
//         "                </div>\n" +
//         "            </div>\n" +
//         "        </div>\n" +
//         "</div>";
// };
