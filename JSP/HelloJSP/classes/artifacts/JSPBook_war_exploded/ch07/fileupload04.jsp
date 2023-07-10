<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery-3.6.0.js"></script>
<title>File Upload</title>
<body>
 <form action="fileupload04_process.jsp" method="post"
 			enctype="multipart/form-data">
	<!-- FormField 추가 --><!-- required == not null(Constraints 제약 사항) == 필수 -->	
 	<p>이름: <input type="text" name="name" required></p> <!-- item -->
 	<p>제목: <input type="text" name="subject" required></p> <!-- item -->
 	
 	<p>파일: <input type="file" id="uploadFile" name="filename" required></p> <!-- item -->
 	<!-- 이미지 미리보기 -->
 	<p id="pImg"></p>
 	<p><input type="submit" value="Upload File"></p>
 </form>
<script>
	console.log("서연");
	// 이미지 미리보기 시작 시작. handleImgFileSelect : 콜백함수
	$('#uploadFile').on("change", handleImgFileSelect);
	function handleImgFileSelect(e) {
		// e.target: <input type="file"...
		let files = e.target.files;
		// multiple일 때 처럼 이미지가 여러개가 있을 수 있음
		// 이미지들을 각각 분리해서 배열로 만듦
		let fileArr = Array.prototype.slice.call(files);
		// 파일 타입의 배열 반복. f: 배열 안에 들어있는 각각의 이미지 파일 한 개 
		// for(ProductVO productVO : productVOList)
		fileArr.forEach(function(f) {
			// 이미지 파일이 아닌 경우 이미지 미리보기 실패 처리 (MIME타입으로 체킹)
			if( !f.type.match("image.*")) {	// 이미지가 아님 
				alert("이미지 확장자만 가능합니다.");
				return false;
			}
			// 이미지 객체를 읽을 자바스크립트의 reader 객체 생성 
			let reader = new FileReader();
			// e: reader가 이미지 파일을 읽는 이벤트 
			reader.onload = function (e) {
				//e.target: f (이미지 객체)
				//e.target.result: reader가 이미지를 다 읽은 결과 
				let img_html = "<img src='"+e.target.result+"' style='width:300px;'>'" ;
				//<p>태그 사이에 이미지가 렌더링 되어 화면에 보임 
				//객체.append(): 누적, 객체.html(): 새로고침, .innerHTML: J/S
				$('.pImg').append(img_html);
			}
			// 이미지 파일 객체(f)를 읽음 
			reader.readAsDataURL(f);
		});
	}
	
</script>
</body>
</html>