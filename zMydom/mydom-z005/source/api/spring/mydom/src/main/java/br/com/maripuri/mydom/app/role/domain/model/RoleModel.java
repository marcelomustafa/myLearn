package br.com.maripuri.mydom.app.role.domain.model;

import br.com.maripuri.mydom.enums.RoleNameType;
import br.com.maripuri.mydom.shared.domain.BaseModel;
import jakarta.persistence.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.io.Serializable;

@Entity
@Table(name = "tbl_role")
@AuditTable(value = "aud_role")
@Audited(withModifiedFlag = true)
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoleModel extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Enumerated(EnumType.STRING)
	@Column(name = "name", nullable = false, unique = true)
	private RoleNameType name;

	
	public RoleNameType getName() {
		return name;
	}

	public void setName(RoleNameType name) {
		this.name = name;
	}

}
