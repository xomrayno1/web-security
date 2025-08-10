package com.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "control")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Control extends BaseEntity{
 
	private static final long serialVersionUID = -8208311203618870693L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "control_id")
	private Long controlId;
	
	@Column(name = "control_code")
	private String controlCode;
	
	@Column(name = "control_name")
	private String controlName;
	
	@Column(name = "control_element")
	private String controlElement;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id")
	private Form form;
	
	
}
