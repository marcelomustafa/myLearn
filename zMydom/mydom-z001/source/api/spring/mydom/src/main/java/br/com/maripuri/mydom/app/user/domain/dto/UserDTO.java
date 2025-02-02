package br.com.maripuri.mydom.app.user.domain.dto;

import br.com.maripuri.mydom.app.person.domain.dto.PersonDTO;
import br.com.maripuri.mydom.app.role.domain.dto.RoleDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import java.util.List;
import java.util.UUID;

public class UserDTO {

  private UUID id;
  private PersonDTO person;
  private String userName;  
  
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password; 
  
  private List<RoleDTO> roles;
  
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public PersonDTO getPerson() {
		return person;
	}
	public void setPerson(PersonDTO person) {
		this.person = person;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<RoleDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
}
