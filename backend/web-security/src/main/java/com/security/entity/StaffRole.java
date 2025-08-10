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
@Entity(name = "staff_role")
public class StaffRole extends BaseEntity {
	
	private static final long serialVersionUID = 6264498498574298923L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "staff_role_id")
	private Long staffRoleId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private Staff staff;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@Column(name = "from_date")
	private LocalDateTime fromDate;
	
	@Column(name = "to_date")
	private LocalDateTime toDate;
	
	@Column(name = "is_default")
	private boolean isDefault;
	

}
