package br.com.maripuri.mydom.app.role.domain.dto;


import br.com.maripuri.mydom.enums.RoleNameType;

import java.util.UUID;

public class RoleDTO {

	private UUID id;
	private RoleNameType name;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public RoleNameType getName() {
		return name;
	}
	public void setName(RoleNameType name) {
		this.name = name;
	}
	
	
}
