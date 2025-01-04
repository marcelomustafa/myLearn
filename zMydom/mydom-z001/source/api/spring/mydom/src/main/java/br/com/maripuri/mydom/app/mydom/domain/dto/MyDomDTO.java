package br.com.maripuri.mydom.app.mydom.domain.dto;


import jakarta.validation.constraints.NotNull;

public record MyDomDTO(
		
		@NotNull String name,
		String description		
		
){
	
	public MyDomDTO(String name) {
		this(name, null);
	}
	
}

