package com.app.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.app.pojo.User;

public interface IWebServiceRestful {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String doGet();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/request/{param}")
	public String doRequest(@PathParam("param") String param, @Context HttpServletRequest servletRequest,
			@Context HttpServletResponse servletResponse);

	/*
	 * @Consumes：声明该方法使用 HTML FORM。
	 * 
	 * @FormParam：注入该方法的 HTML 属性确定的表单输入。
	 * 
	 * @Response.created(uri).build()： 构建新的 URI
	 * 用于新创建的联系人（/contacts/{id}）并设置响应代码（201/created）。 您可以使用
	 * http://localhost:8080/Jersey/rest/contacts/<id> 访问新联系人
	 */
	@POST
	@Path("/postData")
	public User postData() throws IOException;

	@PUT
	@Path("/putData/{id}")
	@Consumes(MediaType.APPLICATION_XML)
	public User putData(@PathParam("id") int id, User user);

	@DELETE
	@Path("/removeData/{id}")
	public void deleteData(@PathParam("id") int id);
}
