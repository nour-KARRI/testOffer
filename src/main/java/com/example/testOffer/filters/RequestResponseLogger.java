package com.example.testOffer.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Slf4j
//@Order(1)
public class RequestResponseLogger implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		/*
		 * Logger log = LoggerFactory.getLogger(User.class);
		 * 
		 * HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		 * 
		 * log.info("Request URI:{}", httpServletRequest.getRequestURI());
		 * log.info("Request Method:{}", httpServletRequest.getMethod());
		 * log.info("request Body: {}", httpServletRequest.getInputStream().toString());
		 * 
		 * chain.doFilter(httpServletRequest, response);
		 * 
		 * HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		 */
	}

}
