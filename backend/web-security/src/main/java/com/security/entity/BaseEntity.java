package com.security.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.security.config.CustomAuditingEntityListener;
import com.security.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(CustomAuditingEntityListener.class)
public class BaseEntity implements Serializable{
	
	private static final long serialVersionUID = -4670949227803604934L;
 	
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;
	
	@Column(name = "created_date")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@Column(name = "updated_date")
	@LastModifiedDate
	private LocalDateTime updatedDate;
	
	@Column(name = "created_by")
	@CreatedBy
	private String createdBy;
	
	@Column(name = "updated_by")
	@LastModifiedBy
	private String updatedBy;
	
	
	@PrePersist
	private void init() {
		this.setUpdatedBy(null);
		this.setUpdatedDate(null);
	}

}
