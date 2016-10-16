package com.beans.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.beans.dao.Dao;
import com.beans.entity.Gender;
import com.beans.entity.Massage;
import com.beans.entity.Town;
import com.beans.entity.User;
import com.beans.services.HelloWorld;

@Component
@Path("/")
public class ChatRest {
	@Autowired
	Dao dao;

	@POST
	@Path("/addUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response addUser(User user, @Context HttpServletRequest request) {
		System.out.println(user.getUsername());
		if (true == dao.addUser(new User(user.getUsername(), user.getPassword(), dao.getTown(user.getTown().getName()),
				dao.getGender(user.getTown().getName())))) {
			request.getSession().setAttribute("username", user.getUsername());
			return Response.ok().build();

		} else {
			return Response.serverError().build();

		}

	}

	@GET
	@Path("/getUser")

	@Produces(MediaType.TEXT_HTML)
	public User getUser() {
		return new User("david", "DA", dao.getTown("Smolian"), dao.getGender("male"));
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_HTML)
	@Path("/addMass/{retriever}")
	public Response addMass(String text, @PathParam("retriever") String retriever,
			@Context HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		User user = dao.getUser(username);
		User re = dao.getUser(retriever);
		dao.addMassage(new Massage(text, user, re, 1, (user.getId() + re.getId()), new java.util.Date()));
		return Response.ok().build();
	}

	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return dao.getUsers();
	}

	@POST
	@Path("/loggin")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String loggin(@FormParam("username") String username, @FormParam("password") String password,
			@Context HttpServletRequest re) {

		try {
			if (dao.getUser(username).getPassword().equals(password)) {

				re.getSession().setAttribute("username", username);
				return ("<a href='http://localhost:8080/Chat/chatArea.html'> chatArea</a>");
			} else {
				return ("<a href='http://localhost:8080/Chat/login.html'> back</a>");
			}

		} catch (Exception ex) {
			return "the username doesn't exist" + "<a href='http://localhost:8080/Chat/login.html'>back</a>+"
					+ "<a href='http://localhost:8080/Chat/'> ";

		}

	}

	@POST
	@Path("/logout")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void logout(@Context HttpServletRequest re) {
		re.getSession().removeAttribute("username");
		re.getSession().invalidate();

	}

	@GET
	@Path("/getMassage/{retriever}")

	@Produces(MediaType.APPLICATION_JSON)
	public List<Massage> getMassage(@Context HttpServletRequest re, @PathParam("retriever") String retriever) {

		return dao.getMassage((String) re.getSession().getAttribute("username"), retriever);

	}

	@DELETE
	@Path("/deleteMass/{id}")

	@Produces(MediaType.TEXT_HTML)
	public Response deleteMassage(@PathParam("id") int id) {

		if (dao.deleteMassage(id)) {
			System.out.println("id delete" + id);
			return Response.ok().build();
		}
		;
		return Response.serverError().build();

	}

}
