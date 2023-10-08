package com.api.parkingcontrol;

import com.api.parkingcontrol.enums.RoleName;
import com.api.parkingcontrol.model.RoleModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
//@RestController
public class ParkingControlApplication {

	public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
		SpringApplication.run(ParkingControlApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));

		RoleModel roleModel = new RoleModel();
		roleModel.setRoleId(UUID.randomUUID());
		roleModel.setRoleName(RoleName.ROLE_ADMIN);
		Object obj = roleModel;

		//Class classe = Class.forName("RoleModel");
		//Method metodo = classe.getMethod("getRoleId");
		//String result = (String) metodo.invoke(obj);

		String field = obj.getClass().getDeclaredMethod("GETROLEID").getName();
		//Method metodo = obj.getClass().getMethod("getRoleId");
		//String result = (String) metodo.invoke(obj) ;

		System.out.println(field + " = " );

	}

	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}


}
