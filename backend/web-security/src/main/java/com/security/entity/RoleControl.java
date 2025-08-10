package com.security.entity;

import java.time.LocalDateTime;

import com.security.model.enums.RoleControlType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
@Entity(name = "role_control")
public class RoleControl extends BaseEntity{ 
	
	private static final long serialVersionUID = -5263829930231649684L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_control_id")
	private Long roleControlId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "control_id")
	private Control control;
	
	@Column(name = "from_date")
	private LocalDateTime fromDate;
	
	@Column(name = "to_date")
	private LocalDateTime toDate;
	
	@Column(name = "role_control_type")
	@Enumerated(value = jakarta.persistence.EnumType.STRING)
	private RoleControlType roleControlType;

}
