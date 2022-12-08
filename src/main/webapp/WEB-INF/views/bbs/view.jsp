<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ include file="../top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
</head>									<!-- 톰켓에서 프로젝트 구분                       웹에서 적용-->
<script>
   //비동기로
   //서버에게 요청 작성자를 파라미터로 보낼 테니 중복여부 확인해줘
   // 응답을 받아서
   // 등록된 사용자라면 vlaue=1로 바꾸는 코드를 짠다. 

</script>
<body>
   <div id="wrap" align="center">
      <h1>게시글 등록</h1>
      <form name="frm" method="post" action="wrAction" encType="multipart/form-data">
         <table>
            <tr>
               <th>작성자</th>
               <td>${boardVO.name}</td>
            </tr>
            <tr>
               <th>이메일</th>
               <td>${boardVO.email }</td>
            </tr>
             <tr>
               <th>조회수</th>
               <td>${boardVO.cnt }</td>
            </tr>
            <tr>
               <th>제목</th>
               <td>${boardVO.title }</td>
            </tr>
            <tr>
               <th>내용</th>
               <td>${boardVO.content }</td>
            </tr>
            <tr>
               <th>첨부파일</th>
					<td><c:forEach items="${attachList }" var="fname">
							<a href="download?filename=${fname}">${fname }</a>
							<img src="download?filename=${fname}">
							<br>
						</c:forEach></td>
				</tr>
         </table>
         <br>
         <br> <input type="submit" value="등록"> <input type="reset"
            value="다시 작성"> <input type="button" value="목록"">
      </form>
   </div>
   <script type="text/javascript">

   
   </script>
</body>
</html>