package com.security.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.security.model.Authority;
import com.security.model.Authority.FormInfo;
import com.security.model.Authority.RoleControl;
import com.security.model.security.PlainAuthentication;
import com.security.service.AuthorizeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/**
 * Class implement phân quyền trong service
 * */
@Slf4j
@Service("AuthorizeService")
@RequiredArgsConstructor
public class AuthorizeServiceImpl implements AuthorizeService {

	/**
	 * Để trả về true thì cần có ít nhất một formCode trong danh sách formCodes
	 * **/
	@Override
	public boolean hasAnyForm(String ...formCodes) {
		final PlainAuthentication authentication = this.getAuthentication();
		
		List<Authority.FormInfo> formInfos = this.extractFormInfoByAuthority(authentication.getAuthorities());
		
		for(Authority.FormInfo formInfo : formInfos) {
            for(String formCode : formCodes) {
                if(formInfo.getFormCode().equals(formCode)) {
                    log.info("[hasAnyForm] Checking access success formCode: {}, phone: {} ", formCode, authentication.getPhone());
                    return true;
                }
            }
        }
		
		log.info("[hasAnyForm] Checking access failed formCode: {}, phone: {} ", formCodes, authentication.getPhone());
		return false;
	}


	/**
	 * @param formCode Mã form màn hình cần kiểm tra
	 * @param controlCodes Mã các control cần kiểm tra quyền trong màn hình formCode
	 * **/
	@Override
	public boolean hasAnyControlInForm(String formCode, String ...controlCodes){
		final PlainAuthentication authentication = this.getAuthentication();
	
		Map<String,  Set<RoleControl>> formInfoMap = this.extractFormInfoByAuthority(authentication.getAuthorities()).stream()
				.collect(Collectors.toMap(FormInfo::getFormCode, FormInfo::getControls));
		
		for(String controlCode : controlCodes) {
			if(formInfoMap.containsKey(formCode)) {
				Set<RoleControl> controls = formInfoMap.get(formCode);
				if (controls != null && controls.stream().anyMatch(RoleControl.isValidControl(controlCode))	) {
					log.info("[hasAnyControlInForm] Checking access success for form: {}, controlCode: {}, phone: {}",
							formCode, controlCode, authentication.getPhone());
					return true;
				}
			}
        }
		return false;
	}
	
	private static PlainAuthentication getAuthentication() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof PlainAuthentication) {
			return (PlainAuthentication) authentication.getPrincipal();
		}
		return null;
	}
	
	private List<Authority.FormInfo> extractFormInfoByAuthority(Collection<? extends GrantedAuthority> authorities){
		return  ((List<Authority>) authorities).stream().flatMap(author -> author.getForms()
				.stream()).toList();
	}

}
