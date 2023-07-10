<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="java.util.List"%>
<%@page import="dao.ProductRepository"%>
<%@page import="vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 폼 필드 
		요청 URL			: processAddProduct.jsp
		요청 method	: post
		요청 Parameter(HTTP Parameter, QueryString)
			{
				productId		=P1237,
				pname			=airPods pro,
				unitPrice		=200000
				description		=Good Sound,
				manufacturer=Apple,
				category		=Tablet,
				unitIsStock	=1000,
				condition		=Old,
			}
-->
<%//스크립틀릿 
	// 폼페이지에서 입력된 데이터를 서버로 전송 시 한글이 꺠지지 않도록 문자 인코딩 유형을 UTF-8로 하여
	// request 내장 객체의 모든 파라미터의 인코딩을 UTF-8로 처리 
	request.setCharacterEncoding("UTF-8");
		
	// 어디니?
	String path = "/Users/ChoiSeoYeon/DDIT/JSP/JSPBook/WebContent/images";
	// 파일 업로드 처리용 클래스 
	DiskFileUpload upload = new DiskFileUpload();
	//환경설정 
	upload.setSizeMax(100000);			// 최대 1M 
	upload.setSizeThreshold(4096);		// 1 * 1024* 1024 => 1M 
	upload.setRepositoryPath(path);		// 임시 저장 (생략 가능)
	//form데이터들을 items로 파싱(의미분석, 구문분석)
	List items = upload.parseRequest(request); 
	Iterator params = items.iterator();	// 열거형 
	
	while(params.hasNext()) {
		
	}
	// 폼페이지에서 입력된 값들을 얻어오기 위해 request 내장 객체의 getParameter() 메서드를 작성 
	// 파라미터의 모든 값의 데이터 타입은 String 타이
	String productId		 	 = request.getParameter("productId");
	String pname			     = request.getParameter("pname");
	String unitPrice		     = request.getParameter("unitPrice");
	String description		 = request.getParameter("description"); 
	String manufacturer    = request.getParameter("manufacturer");   
	String category		     = request.getParameter("category");
	String unitsInStock	     = request.getParameter("unitsInStock"); 
	String condition          = request.getParameter("condition");
	 
	// 폼페이지에서 상품 가격이 입력되지 않은 경우 0으로, 입력된 경우 int형으로 변경 
	int price;
	if(unitPrice.isEmpty()) {
		price = 0;
	} else {
		price = Integer.parseInt(unitPrice);
	}
	
	// 폼페이지에서 상품 재고 수가 입력되지 않은 경우 0으로, 입력된 경우 int형으로 변경 
	// int 타입의 허용범위 : -21억 ~ 21억 
	int stock;
	if(unitsInStock.isEmpty()) {
		stock = 0;
	} else {
		stock = Integer.parseInt(unitsInStock);
	}
	
	// 넘어온 Parameter값들을 => ProductVO productVO 객체에 setting 해보자 
	ProductVO productVO = new ProductVO();
	productVO.setProductId(productId);
	productVO.setPname(pname);
	productVO.setUnitPrice(price);
	productVO.setDescription(description);
	productVO.setManufacturer(manufacturer);
	productVO.setCategory(category);
	productVO.setUnitsInStock(stock);
	productVO.setCondition(condition);
	productVO.setFilename(productId+".jpg");
	
	out.print("productVO: " + productVO); 
	
	ProductRepository dao = ProductRepository.getInstance();
	// 폼페이지에서 입력된 데이터를 저장하도록 ProductRepository 클래스의 
	// addProduct() 메서드를 호출 
	dao.addProduct(productVO);
	List<ProductVO> listOfProducts = dao.getAllProducts();
	
	for(ProductVO vo : listOfProducts) {
		out.print("<p>" + vo + "</p>");
	}
	// 목록으로 강제 이동. response 내장 객체의 sendRedirect()
	//response.sendRedirect("products.jsp");
%>



