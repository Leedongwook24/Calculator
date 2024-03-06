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
    <% 
        String result = (String) request.getAttribute("result");      
//        if((String)request.getAttribute("result")!=null)
//        {result=(String)request.getAttribute("result");}
//        else{result="null";}
    %>
		<tr><td colspan="4" class="result"><%=result%> </td></tr> 
		<form action="cal2" method="post">
			<input type="hidden" name="result" value="<%=result%> " /> 
        <tr>
            <td> <button class="btn" type="submit" name="input" value="+"> +</button> </td>
            <td> <button class="btn" type= "submit" name="input" value="-">-</button> </td>
            <td> <button class="btn" type="submit" name="input" value="*"> *</button> </td>
            <td> <button class="btn" type="submit" name="input" value="/"> /</button> </td>
        </tr>   
        <tr>
            <td> <button class="btn" type="submit" name="input" value="7"> 7</button> </td>
            <td> <button class="btn" type="submit" name="input" value="8"> 8</button> </td>
            <td> <button class="btn" type="submit" name="input" value="9"> 9</button> </td>
            <td> <button class="btn" type="submit" name="input" value="%"> %</button> </td>        
        </tr>   
        <tr>
            <td> <button class="btn" type="submit" name="input" value="4"> 4</button> </td>
            <td> <button class="btn" type="submit" name="input" value="5"> 5</button> </td>
            <td> <button class="btn" type="submit" name="input" value="6"> 6</button> </td>
            <td> <button class="btn" type="submit" name="input" value="^"> ^</button> </td>
        </tr>   
        <tr>
            <td> <button class="btn" type="submit" name="input" value="1"> 1</button> </td>
            <td> <button class="btn" type="submit" name="input" value="2"> 2</button> </td>
            <td> <button class="btn" type="submit" name="input" value="3"> 3</button> </td>
            <td> <button class="btn" type="submit" name="input" value="R"> 1/X</button> </td>
        </tr>   
        <tr>
            <td> <button class="btn" type="submit" name="input" value="C"> C</button> </td>
            <td> <button class="btn" type="submit" name="input" value="0"> 0</button> </td>
            <td> <button class="btn" type="submit" name="input" value="."> .</button> </td>
            <td> <button class="btn" type="submit" name="input" value="e"> =</button> </td>            
         </form>
        </tr>       

    </table>
    
</div>
</body>
</html>