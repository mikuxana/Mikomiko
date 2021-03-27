$(function(){
    //找到a标签
    var $as = $("#banner").find("a");
    //找到a标签所对应的的span标签
    var $slider_btn = $(".slider-btn").find("span");
    //设置轮播图中当前的图片为第一张图片
    var current_index = 0;
    var width = $as.eq(0).width();
    //图片位置初始化，将除了第一张图片之外的图片全部移到.slider-img类范围之外进行隐藏
    for(var i = 1; i < $as.length; i ++){
        $($as[i]).css({left: width});
    }

    //开启定时器，每隔3秒钟进行滚动
    var auto_rotation = setInterval(Rotation_auto,3000);

    //当鼠标移入时停止自动轮播，响应鼠标单击事件
    $("#banner").mouseover(function(){
        clearInterval(auto_rotation);
        $slider_btn.click(Rotation_click);
    });

    //当鼠标移出时开启自动轮播
    $("#banner").mouseout(function(){
        auto_rotation = setInterval(Rotation_auto,3000);
    });


    //设置右下角小图标的样式
    function index_change(index) {
        $slider_btn.removeClass("current_span");
        $slider_btn.eq(index).addClass("current_span")
    }

    //图片轮播逻辑
    function Rotation(next_index){
        //如果点击的按钮是当前按钮的话，什么也不做
        if (next_index == current_index)
            return;
        //如果点击的是处于当前图片的下一张图片，也就是向右边轮播
        else if (next_index > current_index){
            //将当前图片移出区域
            $as.eq(current_index).animate({left: -width});
            $as.eq(next_index).css({left: width});

        }
        //向左边轮播
        else{
            //将当前图片移出区域
            $as.eq(current_index).animate({left: width});
            $as.eq(next_index).css({left: -width});
        }
        //将下一张图片移入区域
        $as.eq(next_index).animate({left: 0});
    }

    //鼠标单击的轮播时间
    function Rotation_click() {
        var index = $(this).index();
        //改变小图标所在位置
        index_change(index);
        //轮播图效果
        Rotation(index);
        current_index = index;
    }

    //自动轮播事件
    function Rotation_auto(){
        var index = (current_index + 1) % $slider_btn.length;
        index_change(index);
        Rotation(index);
        current_index = index;
    }
})



/*-----------------------------------------*/

