package com.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "permission_form")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PermissionForm  extends BaseEntity{
 
	private static final long serialVersionUID = -3285168499450531982L;

	@ManyToOne
	@JoinColumn(name = "form_id")
	private Form form;
	
	@ManyToOne
	@JoinColumn(name = "permission_id")
	private Permission permission;

}
