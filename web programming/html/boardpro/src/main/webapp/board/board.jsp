<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
   rel="stylesheet">
<script src="../js/jquery-3.7.0.min.js"></script>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/board.js"></script>
<script src="../js/jquery.serializejson.min.js"></script>


<style>
body * {
   box-sizing: border-box;
}

p {
   border: 1px solid lightgray;
   margin: 2px;
   padding: 5px;
}

.card-body {
   display: flex;
   flex-direction: column;
}

.pWrap {
   display: flex;
   flex-direction: row;
}

.pWrap .p1 {
   flex: 7;
}

.pWrap .p2 {
   flex: 3;
   text-align: right;
}

input[name=reply] {
   height: 50px;
   vertical-align: top;
}

nav a {
   display: none;
   visibility: hidden;
}

.reply-body {
	margin: 1px;
	padding: 3px;
	border: 1px solid midnightblue;
	background: lightyellow;
}
</style>
</head>
<body>
   <input data-bs-toggle="modal" data-bs-target="#wModal" type="button"
      value="글쓰기" id="write">
   <br>
   <br>

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

   <div id="result"></div>
   <br>
   <br>
   <div id="pageList"></div>

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
myPath = '<%=request.getContextPath()%>';
console.log(myPath);
currentPage = 1;

listPageServer(1);

// 검색 이벤트
$('#search').on('click', function() {
   // stype - write, content, subject
   // sword - 입력한 값 
   listPageServer(1);
})

// 다음(Next) 버튼 이벤트    - 처음부터 있었던 것 아니니까 
$(document).on('click', '#next', function() {
   currentPage = parseInt($('.pageno').last().text()) + 1;
   listPageServer(currentPage);
})
// 이전(Prev) 버튼 이벤트 
$(document).on('click', '#prev', function() {
   currentPage = parseInt($('.pageno').first().text()) - 1;
   listPageServer(currentPage);
})
// 페이지 번호 클릭 이벤트 
$(document).on('click', '.pageno', function() {
   currentPage = parseInt($(this).text().trim());
   listPageServer(currentPage);
})

// 글쓰기 이벤트 
/* 
 $('#write').on('click', function(){
 $('#wModal').modal('show');
 })
 */

// 글 쓰기 모달창에서 입력 후 전송 클릭 이벤트 
$('#msend').on('click', function() {
   // 입력한 모든 값을 가져오기 
   fdata = $('#mform').serializeJSON();
   console.log(fdata);

   // 서버로 전송 
   boardWriteServer();

   // 모달에 입력한 내용 지우기 
   $('#wModal .txt').val("");

   // 모달창 닫기 
   $('#wModal').modal('hide');

})

// 수정, 삭제, 등록 이벤트 
$(document).on('click', '.action', function() {
   vname = $(this).attr('name');
   vidx = $(this).attr('idx');

   console.log(vname, vidx);

   if (vname == "delete") {
      alert(vidx + "글을 삭제합니다.");

      boardDeleteServer();

   } else if (vname == "modify") {
      //alert(vidx + "글을 수정합니다.");
      // modal창 띄우기 
      $('#uModal').modal('show');

      vParent = $(this).parents('.card');

      // 본문의 내용을 가져오기
      wTitle = vParent.find('a').text().trim(); //제목 
      wWriter = vParent.find('.wr').text(); //작성자
      wMail = vParent.find('.ma').text(); //이메일  
      wContent = vParent.find('.p3').html(); //내용 

      // 내용의 <br> 태그를 \n으로 변경
      wCont = wContent.replace(/<br>/g, "\n")

      // modal창에 출력 
      $('#uform #unum').val(vidx); //hidden 글번호 
      $('#uform #uwriter').val(wWriter);
      $('#uform #umail').val(wMail)
      $('#uform #ucontent').val(wCont);
      $('#uform #usubject').val(wTitle);
   } else if (vname == "reply") {
      alert(vidx + "글에 댓글을 답니다.");
      
      vreply = $(this);
      // getter
      vtval = $(this).prev().val();
      
      // setter
      $(this).prev().val("");
      
      // 저장하기 튀해 renum, bonum,count, name
      name1 =String.fromCharCode(parseInt(Math.random() * 26 + 65 ) );
      name2 =String.fromCharCode(parseInt(Math.random()*26 + 97));
      name3 = parseInt(Math.reandom) *100 +1;
      name = name1 + name2 + name3;
      // 저장데이터를 객체로 생성 
      rdata = {}; 
      rdata.bonum = vidx;
      rdata.cont = vtval;
      rdata.name = name;
      // 서버로 전송
      replyInsertSever();
   }
 
})
// 수정 모달창에서 데이터 수정 후 전송 버튼 클릭 이벤트 
$('#usend').on('click', function() {
// 수정해서 입력한 모든 값을 가져온다 
udata = $('#uform').serializeJSON();
console.log(udata);

$('#uform.txt').val("");
$('#uModal').modal('hide');

// 서버로 전송 - ajax 수행
boardUpdateServer();

// 수정한 내용(udata)으로 본문의 내용을 수정한다
   
})
   
   
// 제목을 클릭해서 조회수 증가
$(document).on('click', '.card a', function(){
   vreply = $(this);
   vhidx = $(this).attr('idx');
   // alert($(this).attr('aria-expanded'));
   hitattr = $(this).attr('aria-expanded');
   
   vparents = $(this).parents(".card");
   vhit = vparents.find('.hit').text()
   console.log(vhit);
   
   if(hitattr == "true") {
      // alert("조회수 증가");
      // 서버로 전송
      boardHitUpdate();
   }
   
   replyListServer();
})
</script>
</body>
</html>