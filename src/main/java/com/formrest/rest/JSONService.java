package com.formrest.rest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.formrest.Track;

@Path("/json/metallica")
public class JSONService {

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON(@Context HttpHeaders header, @Context HttpServletResponse response, @PathParam("id") String id) {
		header.getCookies();
		header.getAcceptableLanguages();
		header.getLanguage();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		for(String header1 : header.getRequestHeaders().keySet()){
			System.out.println(header1);
		}
		
		

		Cookie cookie  =new Cookie("1452", "5410");
		response.addCookie(cookie);
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica " + id);

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {

		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
	
}