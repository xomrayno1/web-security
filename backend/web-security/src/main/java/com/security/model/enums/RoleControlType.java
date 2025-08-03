package com.security.model.enums;

import java.util.HashSet;
import java.util.Set;
// Phân quyền dựa trên control  != phân quyền trên entity
// entity: order_create: cho phép tạo đơn, order_view: cho phép view đơn
// control: button tạo đơn, button hủy đơn
public enum RoleControlType {
	ENABLE, // UI cho phép click / api cho phép thực hiện
	DISABLE, //UI bị disable / api không cho phép
	INVISIBLE; //UI bị ẩn đi / api không cho phép
	
	private final Set<RoleControlType> children = new HashSet<>();
	
	static {
		//ENABLE.children.add(DISABLE);
	}
	
    public boolean includes(RoleControlType role) {
        return this.equals(role) || children.stream().anyMatch(r -> r.includes(role));
    }
}
