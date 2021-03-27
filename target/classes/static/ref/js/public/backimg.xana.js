console.log('%c       ', 'font-size: 150px; background: url(https://wx1.sinaimg.cn/large/006nOlwNgy1fktngl8rdnj3090090myp.jpg) no-repeat;');
var items=document.querySelectorAll(".menuItem");for(var i=0,l=items.length;i<l;i++){items[i].style.left=(50-35*Math.cos(-0.5*Math.PI-2*(1/l)*i*Math.PI)).toFixed(4)+"%";items[i].style.top=(50+35*Math.sin(-0.5*Math.PI-2*(1/l)*i*Math.PI)).toFixed(4)+"%"};
$(function(){var k=0;var l=0;jQuery(".magnify").mousemove(function(e){if(!k&&!l){var a=new Image();a.src=jQuery(".small").attr("src");k=a.width;l=a.height}else{var b=jQuery(this).offset();var c=e.pageX-b.left;var d=e.pageY-b.top;if(c<jQuery(this).width()&&d<jQuery(this).height()&&c>0&&d>0){jQuery(".large").fadeIn(100)}else{jQuery(".large").fadeOut(100)}if(jQuery(".large").is(":visible")){var f=Math.round(c/jQuery(".small").width()*k-jQuery(".large").width()/2)*-1;var g=Math.round(d/jQuery(".small").height()*l-jQuery(".large").height()/2)*-1;var h=f+"px "+g+"px";var i=c-jQuery(".large").width()/2;var j=d-jQuery(".large").height()/2;jQuery(".large").css({left:i,top:j,backgroundPosition:h})}}})});
(function($){var GalMenu={defaults:{click_to_close:true,stay_open:false},init:function(options){var o=options,$this=$(this);$this.each(function(i){var $this=$(this),settings=$.extend({},GalMenu.defaults,o),$menu=$("."+settings.menu);$this.on("mousedown",function(e){if(e.which!==3&&$(e.target).parents(".GalMenu").length<1&&settings.click_to_close){$this.find(".GalMenu").stop(true,false).animate({opacity:0},{duration:100,queue:false,complete:function(){$(this).css("display","none").find(".active").removeClass("active").next().stop(true,false).slideUp("normal")}});$(".circle").removeClass("open");$("#overlay").hide()}});$this.on("contextmenu",function(e){e.preventDefault();e.stopPropagation();GalMenu.getCoords(e);$(".GalMenu_close_me").stop(true,false).animate({opacity:0},{duration:100,queue:false,complete:function(){$(this).css("display","none");}});var audio=$("#audio")[0];var add=150;var top=Coords.clientY-add,left=($("body")[0]===e.target)?Coords.clickX+add:Coords.clientX-add;$menu.css({top:top+"px",left:left+"px",display:"block"}).stop(true,false).animate({opacity:1},{duration:100,queue:false});if($("#gal").hasClass("open")){$(".circle").removeClass("open");$("#overlay").hide();audio.pause();audio.currentTime=0}else{$(".circle").addClass("open");$("#overlay").show();audio.play()}})})},getCoords:function(e){var evt=e?e:window.event;var clickX=0,clickY=0;if((evt.clientX||evt.clientY)&&document.body&&document.body.scrollLeft!=null){clickX=evt.clientX+document.body.scrollLeft;clickY=evt.clientY+document.body.scrollTop}if((evt.clientX||evt.clientY)&&document.compatMode=="CSS1Compat"&&document.documentElement&&document.documentElement.scrollLeft!=null){clickX=evt.clientX+document.documentElement.scrollLeft;clickY=evt.clientY+document.documentElement.scrollTop}if(evt.pageX||evt.pageY){clickX=evt.pageX;clickY=evt.pageY}return Coords={clickX:clickX,clickY:clickY,clientX:evt.clientX,clientY:evt.clientY,screenX:evt.screenX,screenY:evt.screenY}}};$.fn.GalMenu=function(method,options){if(GalMenu[method]){return GalMenu[method].apply(this,Array.prototype.slice.call(arguments,1))
}else{if(typeof method==="object"||!method){return GalMenu.init.apply(this,arguments)}else{$.error("Method "+method+" does not exist")}}}})(jQuery);String.prototype.removeWS=function(){return this.toString().replace(/\s/g,"")};String.prototype.pF=function(){return parseFloat(this)};Number.prototype.pF=function(){return parseFloat(this)};

$(function () {
    $('body').GalMenu({'menu': 'GalDropDown'});
    $('.hero__scroll').on('click', function (e) {
        $('html, body').animate({scrollTop: $(window).height()}, 1200)
    })

    var img_id = Math.floor(Math.random() * (16842 - 6)) + 1;
    var himg_id = Math.floor(Math.random() * 2002) + 1;
    $.get(
        "/img/select",
        {id: img_id, hid: himg_id},
        function (res) {
            var secs = $('ul[class="cb-slideshow"]');
            var i = 0;
            for (; i < res.length - 1; ++i)
                secs.append("<li><span style=\"background-image:url('" + res[i].src + "')\"></span></li>");
            // $(".h_img").css("backgroundImage", "url('" + res[i].src + "')");
        },
        'json'
    );

/*滚动条*/
    function whichTransitionEvent() {
        var el = document.createElement('event'),
            transitionEvents = {
                'WebkitTransition' : 'webkitTransitionEnd',// Saf 6, Android Browser
                'MozTransition'    : 'transitionend',      // only for FF < 15
                'transition'       : 'transitionend'       // IE10, Opera, Chrome, FF 15+, Saf 7+
            };
        for(var t in transitionEvents){
            if( el.style[t] !== undefined ){
                return transitionEvents[t];
            }
        }
    }
    var transitionEvent = whichTransitionEvent();
    $('[data-toggle="offcanvas"], .overlay').click(function () {
        $('.overlay').toggleClass('active');
        $('body').toggleClass('active');
        $('.row-offcanvas').toggleClass('active');
        $('.sidebar-offcanvas').toggleClass('active');
        $('.navbar-toggle').toggleClass('collapsed');
        $('.navbar-collapse').addClass('transition');
        $('.transition').one(transitionEvent,
            function(e) {
                $('.navbar-collapse').removeClass('transition');
            });
    });
    $('.navbar .nav a').click(function () {
        $('.overlay').removeClass('active');
        $('body').removeClass('active');
        $('#navbar').removeClass('in');
        $('.row-offcanvas').removeClass('active');
        $('.sidebar-offcanvas').removeClass('active');
        $('.navbar-toggle').addClass('collapsed');
        $('.transition').one(transitionEvent,
            function(e) {
                $('.navbar-collapse').removeClass('transition');
            });
    });
});