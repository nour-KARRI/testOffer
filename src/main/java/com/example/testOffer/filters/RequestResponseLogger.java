package com.example.testOffer.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.testOffer.User;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1)
public class RequestResponseLogger implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Logger log = LoggerFactory.getLogger(User.class);

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		log.info("Request URI:{}", httpServletRequest.getRequestURI());
		log.info("Request Method:{}", httpServletRequest.getMethod());
		log.info("request Body: {}", httpServletRequest.getInputStream().toString());

		chain.doFilter(request, response);

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

	}

}
