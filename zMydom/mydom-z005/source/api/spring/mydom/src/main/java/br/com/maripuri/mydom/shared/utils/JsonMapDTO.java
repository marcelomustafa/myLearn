package br.com.maripuri.mydom.shared.utils;

public record JsonMapDTO(
		int order, 
		String key, 
		Object value
) {

	public JsonMapDTO(
			String key, 
			Object value
	) {
		this(0, key, value);
	}

}
