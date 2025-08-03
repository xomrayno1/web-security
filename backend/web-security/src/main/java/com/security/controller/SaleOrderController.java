package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.APIResponse;
import com.security.utils.PathUtils;
import com.security.utils.ResponseUtils;

@RestController
@RequestMapping(PathUtils.SALE_ORDER_API_V1)
public class SaleOrderController extends BaseController{
	
	/**
	 * Danh sách đơn hàng
	 * @author tamnc
	 */
	@PostMapping
	public ResponseEntity<APIResponse> saleOrderPagingSearchSortFilter() {
		return ResponseUtils.responseSuccess(null);
	}
	
	/**
	 * Hủy đơn hàng
	 * @author tamnc
	 */
	@PostMapping(PathUtils.SALE_ORDER_CANCEL)
	public ResponseEntity<APIResponse> saleOrderCancel() {
		return ResponseUtils.responseSuccess(null);
	}
	
	/**
	 * xác nhận đơn hàng
	 * @author tamnc
	 */
	//Control A có Role_Control.role_controle_type = ENABLE
	@PostMapping(PathUtils.SALE_ORDER_CONFIRM)
	public ResponseEntity<APIResponse> saleOrderConfirm() {
		return ResponseUtils.responseSuccess(null);
	}

}
