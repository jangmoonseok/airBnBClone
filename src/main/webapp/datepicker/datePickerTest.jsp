<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="../js/jquery-3.6.0.min.js"></script> <!-- 값 제어를 위해 jquery -->
    <link href="./css/datepicker.min.css" rel="stylesheet" type="text/css" media="all">
    <!-- Air datepicker css -->
    <script src="./js/datepicker.js"></script> <!-- Air datepicker js -->
    <script src="./js/i18n/datepicker.ko.js"></script> <!-- 달력 한글 추가를 위해 커스텀 -->
</head>
<body>
 	<input type='text' class='datepicker-here' data-language='ko' id="checkIn"/>
 	<input type='text' class='datepicker-here' data-language='ko' id="checkOut"/>
</body>
<script>
date1 = new Date();
date2 = new Date();

$('#checkIn').datepicker({
    language: 'ko',
    minDate: date1 // Now can select only dates, which goes after today
})

$('#checkOut').datepicker({
	language:'ko',
	minDate:date2
})

</script>
</html>