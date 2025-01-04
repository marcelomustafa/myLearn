package br.com.mariapuri.mydom.config.security.auth;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = -7858869558953243875L;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPoint.class);

//	@Override
//	public void commence(HttpServletRequest request, HttpServletResponse response,
//			AuthenticationException authException) throws IOException {
//		
//		logger.error("Unauthorized error: {}", authException.getMessage());
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//		
//	}
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
	    throws IOException, ServletException {
		
	  logger.error("Unauthorized error: {}", authException.getMessage());

	  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	  response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

	  final Map<String, Object> body = new HashMap<>();
	  body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
	  body.put("error", "Unauthorized");
	  body.put("message", authException.getMessage());
	  body.put("path", request.getServletPath());

	  final ObjectMapper mapper = new ObjectMapper();
	  mapper.writeValue(response.getOutputStream(), body);
	}
	
}
