<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="/Calculator/style/style.css">
<title>Calculator</title>
</head>
<body>
<div class="cal_box"> 
    <table class="cal">
		<% if(request.getAttribute("result")!=null) {%>	
		<tr><td colspan="4" class="result" id="result"> <%= request.getAttribute("result") %> </td></tr> 
		<% } else{%>
			<tr><td colspan="4" class="result" id="input"> 0 </td></tr> 
		<% } %>
        <tr>
            <td class="btn" onclick="Click('+')"> + </td>
            <td class="btn" onclick="Click('-')"> - </td>
            <td class="btn" onclick="Click('*')"> *</td>
            <td class="btn" onclick="Click('/')"> /</td>
        </tr>   
        <tr>
            <td class="btn" onclick="Click('7')"> 7 </td>
            <td class="btn" onclick="Click('8')"> 8 </td>
            <td class="btn" onclick="Click('9')"> 9 </td>
            <td class="btn" onclick="Click('%')"> % </td>
        </tr>   
        <tr>
            <td class="btn" onclick="Click('4')"> 4  </td>
            <td class="btn" onclick="Click('5')"> 5 </td>
            <td class="btn" onclick="Click('6')"> 6 </td>
            <td class="btn" onclick="Click('^')"> ^ </td>
        </tr>   
        <tr>
            <td class="btn" onclick="Click('1')"> 1 </td>
            <td class="btn" onclick="Click('2')"> 2 </td>
            <td class="btn" onclick="Click('3')"> 3 </td>
            <td class="btn" onclick="Click('R')"> 1/X </td>
        </tr>   
        <tr>
            <td class="btn" onclick="Click('C')"> C </td>
            <td class="btn" onclick="Click('0')"> 0 </td>
            <td class="btn" onclick="Click('.')"> . </td>
            <td class="btn" onclick="postData()"> = </td>
            
        </tr>       
    </table>
</div>
<script>
    var input = "0";
	var result= "";
    // 클릭 이벤트 핸들러 함수
    function Click(value) {
        if (value === 'C') {
            input = "0";
        } else if (value === 'R') {
            input = (1 / parseFloat(input)).toString();
        } else {
            if (input === "0") {
                input = value;
            } else {
                input += value;
            }
        }
        document.getElementById("input").innerHTML = input;
    }

    function postData() {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/cal", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                var result = xhr.responseText; // 서버에서 받은 결과
                document.getElementById("result").innerText = result; // 결과를 화면에 표시
            }
        };
        xhr.send("input=" + encodeURIComponent(input));
    }
</script>
</body>
</html>