package com.example.security.security.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**This is Entry point handles the invalid credentials. If AUTHENTICATION fails the control comes here**/
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException {
		// Authentication failed, send error response.
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName() + "");
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status : "+response.getStatus()+ "  " + authException.getMessage());
		response.sendRedirect("/login");
	}

	@Override
	public void afterPropertiesSet() {
		setRealmName("spring-security-test-app");
	}
}
