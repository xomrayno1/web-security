package com.security.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.security.model.enums.RoleControlType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {
	private Long roleId;
	private String roleName;
	private String roleCode;
	private Boolean isDefault;
	private Set<FormInfo> forms;
	
	
	/**
	 * Cac form thuoc role nay
	 * **/
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class FormInfo {
		
		private Long formId;
		private String formName;
		private String formCode;
		private String formType;
		private Long parentId;
		private String path;
		private Set<FormInfo> child;
		private Set<RoleControl> controls = new HashSet<>();
				
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;
			Authority.FormInfo other = (Authority.FormInfo) obj;
			return this.formId == other.getFormId();
		}
		
	    @Override
	    public int hashCode() {
	        return Objects.hash(this.formId);
	    }
		
	}
	
	/**
	 * Cac role trong form nay
	 * **/
	@Getter
	@Setter
	public static class RoleControl{
		private Long controleId;
		private String controlName;
		private String controlCode;
		private RoleControlType roleControlType;
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null || getClass() != obj.getClass()) return false;
			Authority.RoleControl other = (Authority.RoleControl) obj;
			return this.controleId == other.getControleId();
		}
		
	    @Override
	    public int hashCode() {
	        return Objects.hash(this.controleId);
	    }
	}

}

 


 
