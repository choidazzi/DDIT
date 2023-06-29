<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../js/jquery-3.7.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/board.js"></script>
<script src="../js/jquery.serializejson.min.js"></script>
</head>
<body>
	<!-- 글쓰기 -->
	<div id="modiform">
		<textarea rows="5" cols="30"></textarea>
		<input type="button" value="확인" id="modisend">
		<input type="button" value="취소" id="modireset">
	</div>
	<input data-bs-toggle="modal" data-bs-target="#wModal" type="button" value="글쓰기" id="write">
	
	<!-- menu(header) -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
      <div class="container-fluid">
         <a class="navbar-brand" href="javascript:void(0)">Logo</a>
         <button class="navbar-toggler" type="button"
            data-bs-toggle="collapse" data-bs-target="#mynavbar">
            <span class="navbar-toggler-icon"></span>
         </button>
         <div class="collapse navbar-collapse" id="mynavbar">
            <ul class="navbar-nav me-auto">
               <li class="nav-item"><a class="nav-link"
                  href="javascript:void(0)">Link</a></li>
               <li class="nav-item"><a class="nav-link"
                  href="javascript:void(0)">Link</a></li>
               <li class="nav-item"><a class="nav-link"
                  href="javascript:void(0)">Link</a></li>
            </ul>
            <form class="d-flex">

               <select class="form-select" id="stype">
                  <option value="">전체</option>
                  <option value="writer">작성자</option>
                  <option value="subject">제목</option>
                  <option value="content">내용</option>
               </select> <input class="form-control me-2" type="text" id="sword"
                  placeholder="Search">
               <button class="btn btn-primary" type="button" id="search">Search</button>
            </form>
         </div>
      </div>
   </nav>
   <!-- 페이지 항목 -->
	<div class="container mt-3">
		<h2>Accordion Example</h2>
		<div id="accordion">
			<!-- 반복문 처리 ajax -->
        </div>
    </div>
   
   <div id="pageList">
   		<ul class="pagination">
   			<!-- 반목문 처리 ajax -->
   		</ul>
   </div>
   
   <!-- 글쓰기 Modal -->
   <div class="modal" id="wModal">
      <div class="modal-dialog">
         <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Modal Heading</h4>
               <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
               <form name="mfrom" id="mform">
                  <input type="hidden" id="num" name="num"> <label>이름</label>
                  <input type="text" class="txt" id="writer" name="writer">
                  <br> <label>제목</label> <input type="text" class="txt"
                     id="subject" name="subject"> <br> <label>메일</label>
                  <input type="text" class="txt" id="mail" name="mail"> <br>

                  <label>비밀번호</label> <input type="password" class="txt"
                     id="password" name="password"> <br> <label>내용</label>
                  <br>
                  <textarea rows="5" cols="40" class="txt" id="content"
                     name="content"></textarea>
                  <br> <br> <input type="button" value="전송" id="msend">
               </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
               <button type="button" class="btn btn-danger"
                  data-bs-dismiss="modal">Close</button>
            </div>

         </div>
      </div>
   </div>

   <!-- 글수정 Modal -->
   <div class="modal" id="uModal">
      <div class="modal-dialog">
         <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
               <h4 class="modal-title">Modal Heading</h4>
               <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
               <form name="ufrom" id="uform">
                  <input type="hidden" id="unum" name="num"> <label>이름</label>
                  <input type="text" class="txt" id="uwriter" name="writer">
                  <br> <label>제목</label> <input type="text" class="txt"
                     id="usubject" name="subject"> <br> <label>메일</label>
                  <input type="text" class="txt" id="umail" name="mail"> <br>

                  <label>비밀번호</label> <input type="password" class="txt"
                     id="upassword" name="password"> <br> <label>내용</label>
                  <br>
                  <textarea rows="5" cols="40" class="txt" id="ucontent"
                     name="content"></textarea>
                  <br> <br> <input type="button" value="전송" id="usend">
               </form>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
               <button type="button" class="btn btn-danger"
                  data-bs-dismiss="modal">Close</button>
            </div>

         </div>
      </div>
   </div>
<script>
	myPath = "<%=request.getContextPath()%>";
	currentPage = 1;
	listPageServer(1);
	
	
</script>
</body>
</html>