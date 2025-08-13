package com.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.security.entity.StaffRole;
import com.security.model.AuthorityLoginSpec;


public interface StaffRoleRepository extends BaseRepository<StaffRole>{
	
	/**
	 * Find active staff roles by staff ID.
	 *
	 * @param staffId the ID of the staff member
	 * @return a list of active StaffRole entities associated with the given staff
	 *         ID
	 */
	@Query(value = "select	"
			+ "r.role_id roleId, r.role_name roleName, r.role_code roleCode, sr.is_default isDefault, "
			+ "f.form_id formId, f.form_code formCode, f.form_name formName, f.form_type formType, f.parent_id parentId, f.path path,	"
			+ "c.control_id controlId, c.control_code controlCode, c.control_name controlName, rc.role_control_type	roleControlType	"
			+ "from staff s	"
			+ "join staff_role sr on sr.staff_id = s.staff_id and sr.status = 'ACTIVE'	"
			+ "join role r on r.role_id = sr.role_id and r.status = 'ACTIVE'	"
			+ "join role_form fr on fr.role_id = r.role_id and fr.status = 'ACTIVE'	"
			+ "join form f on f.form_id = fr.form_id and f.status = 'ACTIVE'	"
			+ "left join control c on c.form_id = f.form_id and c.status = 'ACTIVE'	"
			+ "left join role_control rc on rc.control_id = c.control_id and r.role_id = r.role_id and rc.status = 'ACTIVE'	"
			+ "where s.staff_id = ?	", nativeQuery = true)
	List<AuthorityLoginSpec> findAuthorityLoginSpecsByStaffId(Long staffId);
	
	
	/**
	 * 
	 * **/
	@Query(value = "select	"
			+ "r.role_id roleId, r.role_name roleName, r.role_code roleCode, sr.is_default isDefault, "
			+ "f.form_id formId, f.form_code formCode, f.form_name formName, f.form_type formType, f.parent_id parentId, f.path path,	"
			+ "c.control_id controlId, c.control_code controlCode, c.control_name controlName, rc.role_control_type	roleControlType	"
			+ "from staff s	"
			+ "join staff_role sr on sr.staff_id = s.staff_id and sr.status = 'ACTIVE' and sr.is_default =  1 "
			+ "join role r on r.role_id = sr.role_id and r.status = 'ACTIVE'	"
			+ "join role_form fr on fr.role_id = r.role_id and fr.status = 'ACTIVE'	"
			+ "join form f on f.form_id = fr.form_id and f.status = 'ACTIVE' and f.form_type = :formType	"
			+ "left join control c on c.form_id = f.form_id and c.status = 'ACTIVE'	"
			+ "left join role_control rc on rc.control_id = c.control_id and rc.role_id = r.role_id and rc.status = 'ACTIVE'	"
			+ "where s.staff_id = :staffId ", nativeQuery = true)
	List<AuthorityLoginSpec> findAuthorityLoginSpecsByStaffIdAndRoleIsDefaultAndFormType(
			@Param("staffId") Long staffId, 
			@Param("formType") String formType
	);
	
	
	/**
	 * 
	 * **/
	@Query(value = "select	"
			+ "r.role_id roleId, r.role_name roleName, r.role_code roleCode, sr.is_default isDefault, "
			+ "f.form_id formId, f.form_code formCode, f.form_name formName, f.form_type formType, f.parent_id parentId, f.path path,	"
			+ "c.control_id controlId, c.control_code controlCode, c.control_name controlName, rc.role_control_type	roleControlType	"
			+ "from staff s	"
			+ "join staff_role sr on sr.staff_id = s.staff_id and sr.status = 'ACTIVE' and  sr.role_id = :roleId "
			+ "join role r on r.role_id = sr.role_id and r.status = 'ACTIVE'	"
			+ "join role_form fr on fr.role_id = r.role_id and fr.status = 'ACTIVE'	"
			+ "join form f on f.form_id = fr.form_id and f.status = 'ACTIVE' and f.form_type = :formType	"
			+ "left join control c on c.form_id = f.form_id and c.status = 'ACTIVE'	"
			+ "left join role_control rc on rc.control_id = c.control_id and rc.role_id = r.role_id and rc.status = 'ACTIVE'	"
			+ "where s.staff_id = :staffId ", nativeQuery = true)
	List<AuthorityLoginSpec> findAuthorityLoginSpecsByStaffIdAndRoleIdAndFormType(
			@Param("staffId") Long staffId, 
			@Param("roleId") Long roleId, 
			@Param("formType") String formType
	);

}
