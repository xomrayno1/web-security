package com.security.utils;

public class PathUtils {
	private PathUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static final String VERSION_V1 = "v1";

	public static final String API = "api";

	public static final String SLASH = "/";

	public static final String HEALTHY_API = "/healthy";

	public static final String USER_SERVICE = "user-service";

	public static final String API_V1_PREFIX = SLASH + API + SLASH + VERSION_V1;

	 

	public static final String SALE_SERVICE = SLASH + "sale";
	
	// category api
	public static final String CATEGORY_API = "category";
	
	public static final String CATEGORY_EC_API = "category_ec";

	public static final String CATEGORY_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + CATEGORY_API;

	public static final String CATEGORY_EC_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + CATEGORY_EC_API;

	public static final String CATEGORY_PAGING_SEARCH_SORT_FILTER = SLASH + "category_paging_search_sort_filter";
	
	public static final String CATEGORY_FIND_TREE_BY_PARENT_ID = SLASH + "category_find_tree_by_parent_id";
	
	public static final String CATEGORY_FIND_BY_LEVEL = SLASH + "category_find_by_level/{level}";

	public static final String CATEGORY_FIND_BY_ID = SLASH + "category_by_id/{id}";

	public static final String CATEGORY_CREATE = SLASH + "category_create";

	public static final String CATEGORY_UPDATE = SLASH + "category_update";

	public static final String CATEGORY_DELETES = SLASH + "category_deletes";

	public static final String CATEGORY_GET_ALL = SLASH + "category_get_all";
	
	
	public static final String RATING_API = "rating";
	
	public static final String RATING_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + RATING_API;

	// product api
	public static final String PRODUCT_API = "product";

	public static final String PRODUCT_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + PRODUCT_API;
	
	public static final String PRODUCT_PAGING_SEARCH_SORT_FILTER = SLASH + "product_paging_search_sort_filter";

 

	public static final String PRODUCT_GET_BY_ID = SLASH + "product_by_id/{id}";

	public static final String PRODUCT_CREATE = SLASH + "product_create";

	public static final String PRODUCT_UPDATE = SLASH + "product_update";

	public static final String PRODUCT_DELETES = SLASH + "product_deletes";

	public static final String PRODUCT_FIND_ALL = SLASH + "product_find_all";
	
	// product ec api
	public static final String PRODUCT_EC_API = "product_ec";

	public static final String PRODUCT_EC_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + PRODUCT_EC_API;
	
	public static final String PRODUCT_SCROLLING_PAGING_SEARCH_SORT_FILTER = "product_scrolling_paging_search_sort_filter";
	
	
	//product variant
	public static final String PRODUCT_VARIANT_API =  "product_variant";
	
	public static final String PRODUCT_VARIANT_EC_API =  "product_variant_ec";

	public static final String PRODUCT_VARIANT_EC_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + PRODUCT_VARIANT_EC_API;
	 
	public static final String PRODUCT_VARIANT_CREATE = SLASH + "product_variant_create";
	
	public static final String PRODUCT_VARIANT_UPDATE = SLASH + "product_variant_update";

	public static final String PRODUCT_VARIANT_DELETE = SLASH + "product_variant_delete/{id}";
	
	public static final String PRODUCT_VARIANT_PAGING_SEARCH_SORT_FILTER = SLASH + "product_variant_paging_search_sort_filter";
	
	public static final String PRODUCT_VARIANT_FIND_BY_ID = SLASH + "product_variant_by_id/{id}";
	
	public static final String PRODUCT_VARIANT_RELATED = SLASH + "product_variant_related/{id}";
	
	public static final String PRODUCT_VARIANT_NEW_SCROLLING = SLASH + "product_variant_new_scrolling";
	

	// sale api
	public static final String SALE_ORDER_API = "sale_order";
	
	public static final String SALE_ORDER_EC_API = "sale_order_ec";

	public static final String SALE_ORDER_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + SALE_ORDER_API;
	
	public static final String SALE_ORDER_EC_API_V1 = SLASH + API + SLASH + VERSION_V1 + SALE_SERVICE + SLASH + SALE_ORDER_EC_API;

	public static final String SALE_ORDER_PAGING_SEARCH_SORT_FILTER = SLASH + "sale_order_paging_search_sort_filter";

	public static final String SALE_ORDER_GET_BY_ID = SLASH + "sale_order_by_id/{id}";

	public static final String SALE_ORDER_CREATE = SLASH + "sale_order_create";
	
	public static final String SALE_ORDER_CANCEL = SLASH + "cancel";
	
	public static final String SALE_ORDER_CONFIRM = SLASH + "confirm";
	
	public static final String SALE_ORDER_PAYMENT = SLASH + "sale_order_payment";
	
	public static final String SALE_ORDER_CART = SLASH + "sale_order_cart";
	
	public static final String SALE_ORDER_BY_CUSTOMER_ID = SLASH + "sale_order_by_customer_id/{customerId}";
	
	// sale management
	public static final String STAFF_API = "staff";

	public static final String STAFF_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + STAFF_API;

	public static final String STAFF_GET_BY_ID = SLASH + "staff_by_id/{id}";

	public static final String STAFF_LIST = SLASH + "staff_list";
	  
 
	// account service
	public static final String ACCOUNT_SERVICE = "account";
	
	public static final String AUTH_API = "auth";
	
	// category api
	public static final String CUSTOMER_API = "customer";

	public static final String CUSTOMER_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + ACCOUNT_SERVICE + SLASH + CUSTOMER_API;

	public static final String CUSTOMER_PAGING_SEARCH_SORT_FILTER = SLASH + "customer_paging_search_sort_filter";

	public static final String CUSTOMER_FIND_BY_ID = SLASH + "customer_by_id/{id}";

	public static final String CUSTOMER_CREATE = SLASH + "customer_create";

	public static final String CUSTOMER_UPDATE = SLASH + "customer_update";

	public static final String CUSTOMER_DELETES = SLASH + "customer_deletes";

	public static final String CUSTOMER_FIND_ALL = SLASH + "customer_find_all";
	
	public static final String AUTH_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + AUTH_API;
	
	public static final String AUTH_LOGIN = SLASH + "login";
	
	public static final String AUTH_LOGOUT = SLASH + "logout";
	
	public static final String AUTH_VALITE_TOKEN = SLASH + "validate_token";
	
	public static final String AUTH_REGISTER = SLASH + "register";
	
	public static final String AUTH_GENERATE_HASH_PASSWORD = SLASH + "generate_hash_password/{rawPassword}";
	
	public static final String AUTH_REFRESH_TOKEN = SLASH + "refresh_token";
	
	
	public static final String FORM_API = "form";

	public static final String FORM_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + FORM_API;

	public static final String FORM_GET_MENU = SLASH + "form_get_menu";
	
	public static final String MENU_API = "menu";

	public static final String MENU_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + FORM_API;

	public static final String MENU_GET_ALL = SLASH + "menu_get_all";
	
	
	
	public static final String ROLE_API = "role";

	public static final String ROLE_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + ROLE_API;

	public static final String ROLE_SWITCH = SLASH + "role_switch/{roleId}";
	
	
	// file api
	public static final String FILE_API = "file";

	public static final String FILE_API_V1 = SLASH + API + SLASH + VERSION_V1 + SLASH + ACCOUNT_SERVICE + SLASH + FILE_API;

	public static final String FILE_UPLOAD = SLASH + "file_upload";
	
	public static final String FILE_DOWNLOAD = SLASH + "file_download/{fileName}";
	
	public static final String FILE_UPLOAD_MINIO = SLASH + "file_upload_minio";
	
	public static final String FILE_GET_MINIO = SLASH + "file_get_minio/{uuid}";
	
 
	// user api
	public static final String USER_API = "users";

	public static final String USER_API_V1 = API_V1_PREFIX + SLASH + ACCOUNT_SERVICE + SLASH + USER_API;
	
	public static final String USER_FIND_CURRENT_USER = SLASH + "current_user";
	
	public static final String USER_FIND_CURRENT_USER_BY_TOKEN = SLASH + "current_user_by_token";
 
	 
	 
}
