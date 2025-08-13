package com.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	@PreAuthorize("@AuthorizeService.hasAnyForm(@FormAuthorize.ORDER)")
	@PostMapping
	public ResponseEntity<APIResponse> saleOrderPagingSearchSortFilter() {
		return ResponseUtils.responseSuccess("saleOrderPagingSearchSortFilter done");
	}
	
	/**
	 * Hủy đơn hàng
	 * @author tamnc	
	 */
	@PreAuthorize("@AuthorizeService.hasAnyControlInForm(@FormAuthorize.ORDER, T(com.security.model.enums.FormAuthorize.OrderControl).ORDER_CANCEL.name())")
	@PostMapping(PathUtils.SALE_ORDER_CANCEL)
	public ResponseEntity<APIResponse> saleOrderCancel() {
		return ResponseUtils.responseSuccess(PathUtils.SALE_ORDER_CANCEL);
	}
	
	/**
	 * xác nhận đơn hàng
	 * @author tamnc
	 */
	@PreAuthorize("@AuthorizeService.hasAnyControlInForm(@FormAuthorize.ORDER, T(com.security.model.enums.FormAuthorize.OrderControl).ORDER_CONFIRM.name())")
	@PostMapping(PathUtils.SALE_ORDER_CONFIRM)
	public ResponseEntity<APIResponse> saleOrderConfirm() {
		return ResponseUtils.responseSuccess(null);
	}

}
