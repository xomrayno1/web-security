package com.security.entity;

import java.time.LocalDateTime;

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


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "role_form")
public class RoleForm  extends BaseEntity{
 
	private static final long serialVersionUID = -3285168499450531982L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_form_id")
	private Long roleFormId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id")
	private Form form;
	
	@Column(name = "from_date")
	private LocalDateTime fromDate;
	
	@Column(name = "to_date")
	private LocalDateTime toDate;
	 

}
