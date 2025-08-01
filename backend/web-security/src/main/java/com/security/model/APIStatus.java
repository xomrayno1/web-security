package com.security.model;

public enum APIStatus {
	
	ERR_SYSTEM_COMMON(500, "Có lỗi trong quá trình xử lý, vui lòng liên hệ người quản trị."),
	
	OK(200, "OK"),
	
	ERR_BAD_PARAMS(400, "Bad params"),
	
	ERR_BAD_CREDENTIALS(401, "Tài khoản hoặc mật khẩu chưa chính xác"),
 
	ERR_LOGOUT(111, "You're not logged"),
	
	ERR_SYSTEM(101, "Có lỗi trong quá trình xử lý "),
	
	ERR_MISSING_TOKEN(102, "Missing token"),
	
	ERR_TOKEN_IS_EXPIRED(103, "Token is expired"),
	
	ERR_REFRESH_TOKEN_INVALID(103, "Refresh token is expired or invalid"),
	ERR_ACCESS_DENIED(403, "Không đủ quyền truy cập tài nguyên"),
	
	
	INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
	
	SALE_SERVICE_DOWN(500, "Sale service unavailable, please try again later."),
	
	ACCOUNT_SERVICE_DOWN(500, "Account service unavailable, please try again later."),
	
	
	STOCK_SERVICE_DOWN(500, "Stock service unavailable, please try again later."),
	
	//category 250 299
	ERR_CATEGORY_ID_NOT_EXISTS(251, "category id not exists"),
	ERR_CATEGORY_CODE_NOT_EXISTS(252, "cateogry code not exists"),
	ERR_CATEGORY_NOT_EXISTS(253, "category not exists"),
	ERR_CATEGORY_PARENT_NOT_EXISTS(254, "category parent not exists"),
	
	//category 301 349
	ERR_SALE_ORDER_ID_NOT_EXISTS(251, "Sale order id not exists"),
	ERR_SALE_ORDER_NOT_EXISTS(253, "Sale order not exists"),
	
	ERR_SALE_ORDER_STATUS_NOT_VALID(253, "Trạng thái đơn hàng không hợp lệ"),
	
	ERR_SALE_ORDER_STATUS_CHANGING(253, "Trạng thái đơn hàng đã được thay đổi vui lòng refresh lại"),
	
	ERR_STOCK_NOT_ENOUGH(254, "Không đủ kho"),
	
	ERR_PRODUCT_ID_NOT_EXISTS(251, "product id not exists"),
	
	ERR_PRODUCT_NOT_EXISTS(253, "product not exists"),
	
	ERR_PRODUCT_LIST_NOT_EXISTS(253, "product list not exists"),
	
	ERR_PRODUCT_VARIANT_ID_NOT_EXISTS(251, "product variant id not exists"),
	
	ERR_PRODUCT_VARIANT_NOT_EXISTS(253, "product not exists"),
	
	ERR_BAD_UNAUTHORIZED(255, "Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication"),
	
	ERR_USER_NOT_EXISTS(253, "Tài khoản không tồn tại"),
	
	ERR_USERNAME_IS_EXISTS(270, "Tên tài khoản đã tồn tại"),
	
	ERR_EMAIL_IS_EXISTS(271, "Email đã tồn tại"),

	ERR_ACCOUNT_IS_NOT_VERIFIED(272, "Tài khoản chưa được xác thực"),
	
	ERR_EMAIL_IS_EXISTSS_AND_ACCOUNT_IS_NOT_VERIFIED(272, "Email đã được đăng ký và tài khoản này chưa được xác thực"),
	
	ERR_OTP_IS_EXPIRE(273, "OTP đã hết hạn"),
	
	ERR_ACCOUNT_AND_PASSWORD_IS_WRONG(275, "Tài khoản hoặc mật khẩu chưa chính xác"),
	
	ERR_OTP_DOES_NOT_EXISTS(276, "OTP không tồn tại"),
	 
	ERR_FOOD_ID_NOT_EXISTS(251, "category id not exists"),
	ERR_FOOD_CODE_NOT_EXISTS(252, "cateogry code not exists"),
	ERR_FOOD_DOES_NOT_EXISTS(252, "food does not exists"),
	
	//product
	ERR_PRODUCT_INFO_ID_NOT_EXISTS(555, "Product Info id not exists"),
	
	ERR_PRODUCT_INFO_DOES_NOT_EXISTS(555, "Product Info id not exists"),
	 
	ERR_BRAND_INFO_ID_NOT_EXISTS(555, "Brand id not exists"),
	
	ERR_BRAND_INFO_DOES_NOT_EXISTS(555, "Brand id not exists"),
	
	ERR_FLAVOUR_INFO_ID_NOT_EXISTS(555, "Flavour id not exists"),
	
	ERR_FLAVOUR_INFO_DOES_NOT_EXISTS(555, "Flavour id not exists"),
	
	
	ERR_REGISTER_USER_CUSTOMER(555, "register faild"),
	
	ERR_CUSTOMER_NOT_EXISTS(555, "customer not exists"),
	
	
	ERR_CUSTOMER_SHIPPING_ADDRESS_DOES_NOT_EXISTS(555, "Customer shipping address id not exists"),
	
	ERR_CART_ITEM_NOT_EXISTS(555, "cart item not exists"),
	
	ERR_RATING_ID_NOT_EXISTS(400, "Invalid customer"),
	ERR_CUSTOMER_ID_NOT_EXISTS(400, "Invalid product"),
	
	ERR_USERNAME_EXISTS (405, "Username exists")
	;
	
	
	private final int code;
	private final String message;
	
	private APIStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
 
}
