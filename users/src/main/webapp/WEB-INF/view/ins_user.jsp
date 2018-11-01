<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/ins_user.js"></script>
<style type="text/css">
form #mail_btn{padding:4px 7px;margin-top:10px}

.red {
    color: #ff0000 !important;
}

#mail_btn {
    border: 1px solid #dddddd;
    padding: 10px;
    font-weight: bold;
    line-height: 12px;
    font-size: inherit;
    text-align: center;
}

#mail_btn a {
    /* display: block; */
    width: 100%;
    height: 14px;
    line-height: 14px;
    min-width: 40px;
}

tbody td .hmsg {
    font-weight: bold;
    color: #f00;
}

</style>
</head>
<body>

<div id="ins_join">
<form id="joinfrm">
<table>
  <caption>사용자 등록</caption>
  <thead>
  </thead>
  <tbody>
    <tr>
      <td class="key">
        <b class="red">*</b>
              아이디 
      </td>
      <td>
        <div class="conBox">
          <input name="u_id" class="input" type="text" maxlength="10" placeholder="아이디를 입력해주세요" value=""/>
          <span class="hmsg" id="hid"></span>
        </div>
        
      </td>
    </tr>
    <tr>
      <td class="key">
		이름        
      </td>
      <td>
        <div class="conBox">
          <input name="u_name" class="input" type="text" maxlength="10" placeholder="이름을 입력해주세요" value=""/>
        </div>
      </td>
    </tr>   
    <tr>
      <td class="key">
        <b class="red">*</b>
          이메일 
      </td>
      <td>
        <div class="conBox">
          <input name="u_mail1" class="input" type="text" maxlength="50" placeholder="이메일을 입력해주세요" value=""/>
          @
          <input name="u_mail2" class="input" type="text" size="10" value=""/>
          <select name="u_mail3" onchange="setMail2(this.value)">
			<option selected="selected" value="self">선택하세요</option>
			<option value="naver.com">naver.com</option>
			<option value="nate.com">nate.com</option>
			<option value="dreamwiz.com">dreamwiz.com</option>
			<option value="yahoo.co.kr">yahoo.co.kr</option>
			<option value="empal.com">empal.com</option>
			<option value="unitel.co.kr">unitel.co.kr</option>
			<option value="gmail.com">gmail.com</option>
			<option value="korea.com">korea.com</option>
			<option value="chol.com">chol.com</option>
			<option value="paran.com">paran.com</option>
			<option value="freechal.com">freechal.com</option>
			<option value="hanmail.net">hanmail.net</option>
			<option value="hotmail.com">hotmail.com</option>
			<option value="self">직접 입력</option>
          </select>
          <span id="mail_btn"><a onclick="emailChk()">중복확인</a></span>
        </div>
        <span class="hmsg" id="hmail"></span>
      </td>
    </tr>
    <tr>
      <td class="key">
		별명        
      </td>
      <td>
        <div class="conBox">
          <input name="u_nick" class="input" type="text" maxlength="20" placeholder="별명을 입력해주세요" value=""/>
        </div>
      </td>
    </tr>    
  </tbody>	
</table>
<div class="btn_box">
  <input id="ins_btn" class="sbtn" type="submit" value="사용자 등록">
  <a href="#" onclick="history.go(-1);return false;" style="text-decoration:underline;">취소</a>
</div>

</form>
<script type="text/javascript">
//이메일 선택
var setMail2 = function(val){
	if(val=='self'){
		$('input[name=u_mail2]').attr('readonly',false);
		$('inpur[name=u_mail2]').val('');
		$('input[name=u_mail2]').focus();
	}else{
		$('input[name=u_mail2]').attr('readonly',true);
		$('input[name=u_mail2]').val(val);
	}
}

//이메일 중복체크
var emailchk = $('#mail_btn').on('click',function(){	
	var u_mail = $('input[name=u_mail1]').val()+"-"+$('input[name=u_mail2]').val();
	if($('input[name=u_mail1]').val() == ""){
		alert("이메일을 입력해주세요.");
		$('input[name=u_mail1]').focus
	}else{
	$.ajax({
 		anync:true, 
		type:'POST',
		data:u_mail,
		dataType:'json',
		url :'mailCheck.do',
		contentType: "application/json; charset=UTF-8",		
		success:function(val){
			if(val >0){
				alert('존재하는 이메일 입니다.');
				$('input[name=u_mail1]').val("");
				$('input[name=u_mail2]').val("");
				$('input[name=u_mail1]').focus();
			}else{
				alert('사용가능한 이메일 입니다.');
			}
		}
	});
	}
});
</script>
</div>

</body>
</html>