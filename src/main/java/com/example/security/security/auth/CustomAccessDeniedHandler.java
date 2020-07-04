package com.example.security.security.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * This handles AUTHORIZATION errors such as trying to access method without the
 * appropriate priviledges The access denied handler handles situations where
 * you have secured you app at method level such as using
 * the @PreAuthorized, @PostAuthorized, & @Secured
 **/
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		PrintWriter writer = response.getWriter();
		writer.println("HTTP Status : " + response.getStatus() + "  " + accessDeniedException.getMessage());
		writer.println("You don't have required role to access this resource");

	}

}
