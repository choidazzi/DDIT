function CheckAddProduct() {
    let form = document.newProduct;
    // 1) 상품 아이디 체크
    // 첫 글자는 P. 숫자를 조합하여 5 ~ 12자까지 입력 가능
    // P1234
    let regExpId = /^P[0-9]{4,11}/;
    if(!regExpId.test(form.productId.value)) {
        alert("[상품코드}\nP와 숫자를 조합하여 5~12자 까지 입력하세요.\n첫글자는 P로 시작하세요.");
        form.productId.select();
        form.productId.focus();
        return false;//함수 멈춤
    }
    // 2) 상품명 체크
    // 4 ~ 12자까지 입력 가능
    // ex) AirPods Pro
    if(form.pname.value.length<4 || form.pname.value.length>12) {
        alert("[상품명]\n최소 4자에서 12자까지 입력해주세요.");
        form.pname.select();
        form.pname.focus();
        return false;//함수 멈춤
    }
    // 3) 상품 가격 체크
    // 숫자만 입력 가능. 음수는 X
    if(form.unitPrice.value.length == 0||isNaN(form.unitPrice.value)) {
        alert("[가격]\n숫자만 입력해주세요.");
        form.unitPrice.select();
        form.unitPrice.focus();
        return  false;
    }
    if (form.unitPrice.value < 0) {
        alert("[가격]\n음수는 입력하실 수 없습니다.");
        form.unitPrice.select();
        form.unitPrice.focus();
        return  false;
    }
    //123234.12 소수점 둘째 자리까지만 허용
    // \d : 숫자
    // /^\d+(?:[.]?([0-9]{1,2})?)?$/
    let regExpUnitPrice = /^\d+(?:[.]?[\d]?[\d])?$/;
    if (!regExpUnitPrice.test(form.unitPrice.value)) {
        alert("[가격]\n가격은 소수점 둘째 자리까지만 허용됩니다.");
        form.unitPrice.select();
        form.unitPrice.focus();
        return  false;
    }
    // 4) 재고 수 체크
    if (isNaN(form.unitsInStock.value)) {
        alert("[재고]\n숫자만 입력해주세요.");
        form.unitPrice.select();
        form.unitPrice.focus();
        return  false;
    }
    //alert("모두 통과!!!");
    form.submit();
}