/**
 * Created by duanhailin on 2018/06/21.
 */
;(function ($) {
  function createCode(dom, config) {
    var _this = this;
    _this.config = config
    _this.codeList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    _this.color = ['#e3730f', '#2ae3e0', '#c317e3', '#0e935f','#e30d65', '#3c8b36', '#74675a', '#654321','#123345', '#135784', '#169b9a', '#02468a'];
    _this.bgColorList = ['#b1b1b1', '#e3d7cc', '#d0d9f9', '#f8f2d6'];
    _this.bgColor = '';
    _this.code = '';
    if (_this.config) {
      _this.codeLen = _this.config.len || 4;
    } else {
      _this.codeLen = 4;
    }
    var html = '';
    var deg = 0;
    for (i = 0; i < _this.codeLen; i++) {
      var index = Math.floor(Math.random() * _this.codeList.length);
      var idx = Math.floor(Math.random() * _this.color.length);
      var bgIdx = Math.floor(Math.random() * _this.bgColorList.length);
      if (index % 2 == 0) {
        deg = index + Math.floor(Math.random() * idx)
      } else {
        deg = -(index + Math.floor(Math.random() * idx))
      }
      html += '<span style="padding:0 2px; font-size: 20px; color:' + _this.color[idx] + ';display:inline-block;transform:rotate(' + deg + 'deg);">' + _this.codeList[index] + '</span>';
      _this.code += _this.codeList[index];
      _this.bgColor = _this.bgColorList[bgIdx]

    }
    html += '<input placeholder="" value="'+_this.code+'" type="hidden">';
    $(dom).css({
      width: _this.codeLen * 20 + 'px',
      padding: '2px',
      textAlign: 'center',
      display: 'inline-block',
      backgroundColor: _this.bgColor,
      cursor: "pointer",
      opacity: 0.77
    });
    $(dom).empty().append(html);
  }

  $.fn.createCode = function (cfg) {
    var _this = this;
    createCode(_this, cfg);
    $(_this).click(function () {
      createCode(_this, cfg);
    });
  }
})(jQuery);

var userReg = /^[^@#\s]{2,16}$/;
var passReg = /^[^\s]{6,32}$/;
var smartReg = /^1\d{10}$/;

var flag= [false, false, false, false, false];

$(function () {



  $('.code').createCode({
    len:6
  });

  var signUp = $("#signUp");
  var login = $("#login");
  var user = $("#user input");
  var pass = $("#pass input");
  var secPass = $("#secPass input");
  var smart = $("#smart input");
  var verfiy = $("#verify input");

  user.blur(function () {

    if(user.val()=="") {
      $("#user span").text("输入昵称");
      return;
    }

    flag[0] = userReg.test(user.val());
    if(!flag[0]) {
      $("#user span").text("昵称长度在2-16字符之间，且不包含空格或特殊符号");
      return;
    }

    if(user.attr("id")!=null) return;
    $.get('/user/findUser', {username: user.val()}, function (res) {
      flag[0] = res=='0'? true: false;
      if(!flag[0])
        $("#user span").text("昵称已存在");
    },
        'json');
  });

  user.focus(function () {
    $("#user span").text("");
  });

  pass.blur(function () {
    if(pass.val()=="") {
      $("#pass span").text("输入密码");
      return;
    }

    flag[1] = passReg.test(pass.val())
    if(!flag[1])
      $("#pass span").text("密码长度应为6至32个字符之间，且不包含空格");
  });

  pass.focus(function () {
    $("#pass span").text("");
  });

  secPass.blur(function () {
    flag[2] = pass.val()==secPass.val();
    if(!flag[2])
      $("#secPass span").text("密码不一致");
  });
  secPass.focus(function () {

    $("#secPass span").text("")
  });

  smart.blur(function () {
    if(smart.val()=="") {
      $("#smart span").text("输入手机号")
      return;
    }

    flag[3] = smartReg.test(smart.val());
    if(!flag[3]){
      $("#smart span").text("手机号码不正确");
    }
  });
  smart.focus(function () {
    $("#smart span").text("");
  });

  verfiy.blur(function () {
    if(verfiy.val()=="")
      return;
    flag[4] = $(".code input").val().toLowerCase()==verfiy.val().toLowerCase();
    if(!flag[4])
      $("#verify span").text("验证码不正确");
  });

  verfiy.focus(function () {
    $("#verify span").text("");
  });

  signUp.click(function () {

    if(!flag[4]) {
      $("#verify span").text("验证码不正确");
      $('.code').createCode({len:6});
      return;
    };

    for (let e of flag) {
      if(!e) {
        $('.code').createCode({len:6});
        $("#verify span").text("验证码不正确");
        return;
      }
    }
    $.post("/user/signUp", {username:user.val(), password: pass.val(), smart:smart.val()}, function (res) {

      if(res>0){
        function toIndex(){
          window.location.href= "/";
        }
        setTimeout(toIndex, 1500);

        var myModal = $('#myModal');
        $("#myModal #username").text(user.val());
        myModal.modal('show');
        myModal.on('hidden.bs.modal', toIndex);
      }
    } ,'json');
  });

  login.click(function () {
    $("#user span").text("")
    if(!flag[4]) {
      $("#verify span").text("验证码不正确");
      $('.code').createCode({
        len:6
      });
      return;
    };

    $.post("/user/login", {username: user.val(), password: pass.val()},function (res) {
      if(res==1){
        function toIndex(){
          window.location.href= "/";
        }
        setTimeout(toIndex, 1500);

        var myModal = $('#myModal');
        $("#myModal #username").text(user.val());
        myModal.modal('show');
        myModal.on('hidden.bs.modal', toIndex);

      }else $('#user span').text('昵称或密码错误, 请重新输入');
    });
  })
});