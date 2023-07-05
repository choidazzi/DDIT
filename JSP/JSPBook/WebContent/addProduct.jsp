<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<title>상품 등록</title>
<!-- 
	WYSIWIG(What You See Is What You Get)
	: 보이는 것 그대로 얻을 수 있다. (DB) 
-->
<script src="/ckeditor/ckeditor.js"></script>
<script src="/js/jquery-3.6.0.js"></script>
</head>
<body>
	<!-- header.jsp -->
	<jsp:include page="menu.jsp" />
	
	<!-- 상품 등록 시작 -->
	<div class="jumbotron">
		<div class="container">
				<h1 class="display-3">상품 등록</h1>
		</div>
	</div>
	
	<!-- 상품 등록 폼 필드 시작 -->
	<div class="container">
		<!-- 폼 필드 
		요청 URL			: processAddProduct.jsp
		요청 method	: post
		요청 Parameter(HTTP Parameter, QueryString)
			{
				productId=P1234,
				pname=airPods pro,
				unitPrice=200000
				description=Good Sounds,
				manufacturer=Apple,
				category=Tablet,
				unitIsStock=1000,
				condition=Old,
			}
		-->
		<!-- name: 폼을 식별할 수 있는 식별자 -->
		<form name="newProduct" action="processAddProduct.jsp"
				   class="form-horizontal" method="post"
				   enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">상품 코드</label>
				<div class="col-sm-3">
					<input type="text" name="productId" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="pname" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세 정보</label>
				<div class="col-sm-3">
					<textarea rows="3" name="description" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">카테고리</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 재고</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 상태</label>
				<div class="col-sm-5">
					<input type=radio id="condition1" name="condition" value="New"> 
					<label for="condition1" style="margin-right: 8px;">신규 제품</label>
					<input type=radio id="condition2" name="condition" value="Old"> 
					<label for="condition2" style="margin-right: 8px;">중고 제품</label>
					<input type=radio id="condition3"name="condition" value="Refurbished"> 
					<label for="condition3">재생 제품</label> 
				</div>
			</div>
			<!--  상품 이미지 -->
			<div class="form-group row">
				<label class="col-sm-2">상품 이미지</label>
				<div class="col-sm-5">
					<input type="file" id="productImage" name="productImage" class="form-control">
				</div>
			</div>
			<!--  상품 이미지 미리보기-->
			<div class="form-group row">
				<label class="col-sm-2">이미지 미리보기</label>
				<div class="col-sm-5 divImg"></div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="등록" class="btn btn-primary">
				</div>
			</div>
		</form>
	</div>
	<!-- 상품 등록 폼 필드 끝 -->
	
	<!-- footer.jsp -->
	<jsp:include page="footer.jsp" />
	
<script>
CKEDITOR.replace("description");

// 이미지 미리보기 시작 
$('#productImg').on('change',handleImg);

//change event
function handleImg(e) {
	// 첨부 파일들 
	let files = e.target.files;
	// 파일 배열 Object
	let fileArr =Array.prototype.slice.call(files);
	// 파일 반복 
	fileArr.forEach(function(f) {
		if(!f.type.match("image.*")) {
			alert("이미지 확장자만 가능합니다.");
			// 함수 종료 
			return;
		}
		let reader = new FileReader();
		// e : 파일 읽을 때 이벤트 
		reader.onload = function(e) {
			let img_html = "<img src='"+e.target.result+"' style='width: 100px;''>";
			//class = "colsm-5 divImg"
			$(".divImg").html(img_html);
		}
		reader.readAsDataURL(f);
	})
}
</script>
</body>
</html>