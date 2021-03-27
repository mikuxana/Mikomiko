$(function () {
    const dp = new DPlayer({
        container: document.getElementById('dplayer'),
        screenshot: true,

        video: {
            url: 'http://op.mtyee.com/f/dplayer.php?url=http%3A%2F%2F1251316161.vod2.myqcloud.com%2F007a649dvodcq1251316161%2Fd1e08f0f5285890805260494591%2FdohbvbwubNsA.mp4',
            pic: '../ref/video/video_loading.jpg',
            thumbnails: '../ref/video/video_loading.jpg',
        },
        subtitle: {
            url: 'webvtt.vtt',
        },
        danmaku: {
            id: 'demo',
            api: 'https://api.prprpr.me/dplayer/',
        },
    });
})
