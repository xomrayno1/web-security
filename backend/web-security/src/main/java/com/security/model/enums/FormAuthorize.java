package com.security.model.enums;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
public enum FormAuthorize {
	ORDER(OrderControl.class),
    STAFF_MANAGEMENT(StaffControl.class);

    private final Class<? extends Enum<?>> controlEnum;

    FormAuthorize(Class<? extends Enum<?>> controlEnum) {
        this.controlEnum = controlEnum;
    }

    public enum OrderControl {
        ORDER_CANCEL, ORDER_CONFIRM
    }

    public enum StaffControl {
        STAFF_ADD, STAFF_REMOVE
    }
	
	@Component("FormAuthorize")
	@Getter
	static class SpringComponent {
		private final FormAuthorize ORDER = FormAuthorize.ORDER;
		private final FormAuthorize STAFF_MANAGEMENT = FormAuthorize.STAFF_MANAGEMENT;
	}

}
