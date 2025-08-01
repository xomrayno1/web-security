package com.security.entity;

import com.security.model.enums.FormType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "form")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Form extends BaseEntity {

	private static final long serialVersionUID = -1441838590240649903L;

	@Column(name = "form_code")
	private String formCode;

	@Column(name = "form_name")
	private String formName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_form_id")
	private Form parentForm;

	@Enumerated(EnumType.STRING)
	@Column(name = "form_type")
	private FormType formType;

}
