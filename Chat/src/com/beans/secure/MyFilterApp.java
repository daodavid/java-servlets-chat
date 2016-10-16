package com.beans.secure;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class MyFilterApp implements ContainerRequestFilter,ContainerResponseFilter{
	 @Context
	 HttpServletRequest request;
	 @Context
	 HttpServletResponse response;



	@Override
	public ContainerResponse filter(ContainerRequest re, ContainerResponse resp) {
		re.getPath();
	 
		if(re.getPath().contains("loggin")||request.getSession().getAttribute("username")!=null){
			
			return resp;
		}else{
			resp.setStatus(404);
		}
	
		return resp;
	}

	@Override
	public ContainerRequest filter(ContainerRequest reqst) {
	
		return reqst;
	}

}
