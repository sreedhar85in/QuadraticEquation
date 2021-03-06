package com.datastructures.maths.quadraticequation.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class JWTFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.info("initiating filter");
		
		String path = request.getServletPath();
		
		if (path.contains("swagger")||path.contains("docs")) {
			
			logger.info("Swagger page detected," +" "+ path + ",hence bypassing the filter here");
			filterChain.doFilter(request, response);
			return;
			
		}
		
		else {
			
			logger.info("This is not a swagger page and hence filter will be applied here with application logic such token decode");
			filterChain.doFilter(request, response);
			return;
			
		}
		// TODO Auto-generated method stub
		
	}

}
