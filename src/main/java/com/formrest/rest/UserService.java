package com.formrest.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

	@POST
	@Path("/add")
	public Response addUser(@FormParam("age") int age,
			@FormParam("fname") String fname, @FormParam("lname") String lname, @FormParam("address") String address, @FormParam("empid") String empid) {
		try {
			List<String> l = new ArrayList<String>();
			String s = new String(fname);
//			l.add(s);
			
			Stack<String> s1 = new Stack<String>();
			// s1.add(s);
			s1.push(s);
			
			System.out.println(s1);
			
			System.out.println(fname + " " + age);
			return Response
					.status(200)
					.entity("User is : " + fname + ", age : " + age +" "+ empid
							+" "+ lname +" "+address).build();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception " + e);
		}
		return null;
	}
}