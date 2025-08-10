package com.security.service.impl;

 
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.security.model.Authority;
import com.security.model.AuthorityLoginSpec;
import com.security.repository.StaffRoleRepository;
import com.security.service.MenuService;
import com.security.service.mapper.RawConvert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MenuServiceImpl extends BaseServiceImpl implements MenuService {
	
	private final StaffRoleRepository staffRoleRepository;
 
	/**
	 * Load menu cho admin <br>
	 * 
	 * @author tamnc
	 * **/
	@Override
	public List<Authority> getAuthoritiesByStaffId(Long staffId){
		List<AuthorityLoginSpec> authoritiesRepo = staffRoleRepository.findAuthorityLoginSpecsByStaffId(staffId);
		
		if(authoritiesRepo.isEmpty()) {
			log.warn("[getAuthoritiesByStaffId] Staff with ID {} has no authorities assigned.", staffId);
			return Collections.emptyList();
		}
		
		//load control map from authoritiesRepo
		Map<Long, Set<Authority.RoleControl>> controlMap = this.extractControlMap(authoritiesRepo);
		
		// Group authorities by roleId
		Map<Long, List<AuthorityLoginSpec>> authorityMap = authoritiesRepo.stream()
								.collect(Collectors.groupingBy(AuthorityLoginSpec::getRoleId));
		
		return authorityMap.entrySet().stream().map(element -> {
			//convert to Authority.FormInfo
			List<Authority.FormInfo> formByRoles = element.getValue().stream()
					.map(RawConvert::toAuthorityFormInfo)
					.toList();
			
			// Lay danh sach form root node
			List<Authority.FormInfo> rootNodeByRoles = formByRoles.stream().filter(item -> item.getParentId() == null).toList();
			
			Set<Authority.FormInfo> formCharts = new HashSet<>();
			for(Authority.FormInfo rootForm: rootNodeByRoles) {
				//get child forms
				rootForm.setChild(this.getFormChilds(formByRoles, rootForm.getFormId(), controlMap));
				formCharts.add(rootForm);
			}
			
			//set mapping role
			AuthorityLoginSpec firstAuthority = element.getValue().stream().findFirst().orElse(null);
			Authority authority = new Authority();
			authority.setRoleId(firstAuthority.getRoleId());
			authority.setRoleCode(firstAuthority.getRoleCode());
			authority.setRoleName(firstAuthority.getRoleName());
			authority.setIsDefault(firstAuthority.getIsDefault());
			authority.setForms(formCharts);
			return authority;
		}).toList();
	}
	
	/**
	 * Lay danh sach child form
	 * @author tamnc
	 * @param parentId: Id cua form cha
	 * @param forms: danh sach forms
	 * @param controlMap: danh sach control
	 * **/
	private Set<Authority.FormInfo> getFormChilds(List<Authority.FormInfo> forms, Long parentId, Map<Long, Set<Authority.RoleControl>> controlMap) {
		Set<Authority.FormInfo> formInfos = new HashSet<>();
		for(Authority.FormInfo form: forms) {
			if (Objects.equals(form.getParentId(), parentId)) {
				//get child forms
				Set<Authority.FormInfo> childForms = this.getFormChilds(forms, form.getFormId(), controlMap);
				form.setChild(childForms);
				form.setControls(controlMap.getOrDefault(form.getFormId(), Collections.emptySet()));
				formInfos.add(form);
			}
		}
		return formInfos;
	}
	

}
