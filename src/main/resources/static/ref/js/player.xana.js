
$(function () {
    var xp = new XtPlayer("#player",{
        quality: [
            {
                name: "1080P",
                src: "https://xtplayer.acgxt.com/53587.m3u8",
                loader: 'hls'
            },
            {
                name: "720P",
                src: "https://xtplayer.acgxt.com/6.flv",
                loader: 'flv'
            }, {
                name: "360P",
                src: "https://xtplayer.acgxt.com/1.mp4",
                loader: 'mp4'
            }
        ],
        loader:'hls',//使用加载器加载视频[hls,flv]
       /* src:"../ref/video/bangumi/12.mp4",//视频资源地址,支持普通浏览器支持格式与m3u8*/
        src:"blob:http://op.mtyee.com/7b634383-075d-4522-acf4-bbeb25b1b221",
        poster:"../ref/video/video_loading.jpg",//初始化时的预览图
        /*
                        width:800,
                        height: 'auto',*/
        autoplay:false,//是否自动播放[用户记忆储存]
        preload:true,//是否预先加载[用户记忆储存]
        loop:false,//是否洗脑循环[用户记忆储存]
        volume:1,//默认音量0-1
        danmaku:{
            enable:true,//是否启用弹幕[用户记忆储存]
            api:"https://xtplayer.acgxt.com/getDanmu.php",//弹幕获取接口 格式[{text:'xxx',color:'xxxx',time:1}]
            // send:"https://xtplayer.acgxt.com/sendDanmu.php",//弹幕接收接口
            dense:5,//单行弹幕密集间距(默认5)
            screenMax:500,//同屏弹幕最大数量(默认500)
            opacity:1,//弹幕透明度(默认1)
            fontSize:18,//弹幕文字大小(默认18)[不建议修改]
            move:1,//弹幕移动速度(默认1)
        },
        subtitle:{
            enable:true,//是否启用字幕[用户记忆储存]
            api:"https://xtplayer.acgxt.com/subtitle.php"//字幕接口 格式[{text: "字幕内容",start:"开始秒数",end:"结束秒数"}]
        }
    });
})