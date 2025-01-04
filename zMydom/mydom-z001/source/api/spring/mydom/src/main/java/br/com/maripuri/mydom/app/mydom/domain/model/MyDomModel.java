package br.com.maripuri.mydom.app.mydom.domain.model;

import br.com.maripuri.mydom.shared.domain.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tbl_mydom")
@AuditTable(value = "aud_mydom")
@Audited(withModifiedFlag = true)
//@EntityListeners(AuditingEntityListener.class)
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MyDomModel extends BaseModel implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String name;

	@Size(max = 255)
	private String description;

	@Transient
	@NotAudited
	@Size(max = 255)
	private String removeColumnTest;


	public MyDomModel() {}

	public MyDomModel(
			@NotBlank String name,
			@Size(max = 255) String description
	) {

		this.name = name;
		this.description = description;

	}

	public MyDomModel(
			@NotBlank String name, 
			@Size(max = 255) String description,
	    @Size(max = 255) String removeColumnTest
	) {

		this.name = name;
		this.description = description;
		this.removeColumnTest = removeColumnTest;
	
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemoveColumnTest() {
		return removeColumnTest;
	}

	public void setRemoveColumnTest(String removeColumnTest) {
		this.removeColumnTest = removeColumnTest;
	}

	
}
