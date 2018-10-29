<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
form #mail_btn{padding:4px 7px;margin-top:10px}
.key {
    font-weight: normal;
    padding-left: 20px;
    width: 120px;
    color: #111;
}

.red {
    color: #ff0000 !important;
}

tbody td {
    padding: 12px 0;
    border-bottom: #ddd solid 1px;
    color: #999;
}

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
          <input name="u_id" class="input" type="text" maxlength="10" value=""/>
        </div>
        <span class="hmsg" id="hid"></span>
      </td>
    </tr>
    <tr>
      <td class="key">
		이름        
      </td>
      <td>
        <div class="conBox">
          <input name="u_name" class="input" type="text" maxlength="10" value=""/>
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
          <input name="u_mail1" class="input" type="text" maxlength="50" value=""/>
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
        
      </td>
    </tr>
    <tr>
      <td class="key">
		별명        
      </td>
      <td>
        <div class="conBox">
          <input name="u_nick" class="input" type="text" maxlength="20" value=""/>
        </div>
      </td>
    </tr>    
  </tbody>	
</table>
<div class="btn_box">
  <input id="ins_btn" class="sbtn" type="submit" value="사용자 등록">
</div>
</form>
<script type="text/javascript">

$(document).ready(function(){
	
	$('#ins_btn').on('click',function(){
		var u_id = $('input[name=u_id]').val();
		var u_name = $('input[name=u_name]').val();
		var u_mail = $('input[name=u_mail1]').val()+$('input[name=u_mail2]').val();
		var u_nick = $('input[name=u_nick]').val();
		alert(u_id + u_name + u_mail + u_nick);
		
		$('#joinfrm').attr('method','post');
		$('#joinfrm').attr('action','joinPro.do');
	})
});

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

/* var emailchk = function(){
	$.ajax({
		type:"POST",
		dataType:
	})
} */
</script>
</div>

</body>
</html>