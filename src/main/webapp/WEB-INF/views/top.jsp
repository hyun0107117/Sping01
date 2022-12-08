<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/main.css">
</head>
<body>
	<div id="titleDV">Kim Teacher HomePage</div>
	<div id="logininfo">
		Login user : ${login } 님 로그인
		<c:if test="${login!=null }">
			<a href="logout">[로그아웃]</a>
		</c:if>
	</div>

	<header> 스프링게시판1</header>

	<nav>
		<a href="/cafe/">[home]</a> <a href="wrForm">[Write]</a> <a
			href="bbsList">[BBSList]</a>

	</nav>
	<select onchange="categoryChange(this)">
		<option>걸그룹을 선택해주세요</option>
		<option value="a">블랙핑크</option>
		<option value="b">에프엑스</option>
		<option value="c">EXID</option>
	</select>
	<select id="good">
		<option>좋아하는 멤버를 선택해주세요</option>
	</select>
	<script>
		function categoryChange(e) {
			var good_a = [ "지수", "제니", "로제", "리사" ];
			var good_b = [ "빅토리아", "엠버", "루나", "크리스탈" ];
			var good_c = [ "LE", "하니", "정화", "혜린", "솔지" ];
			var target = document.getElementById("good");

			if (e.value == "a")
				var d = good_a;
			else if (e.value == "b")
				var d = good_b;
			else if (e.value == "c")
				var d = good_c;

			target.options.length = 0;

			for (x in d) {
				var opt = document.createElement("option");
				opt.value = d[x];
				opt.innerHTML = d[x];
				target.appendChild(opt);
			}
		}
	</script>

</body>
</html>