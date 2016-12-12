package scau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import scau.services.IFilmServices;

@Controller
@RequestMapping("/film")
public class FilmController {
  
	@Autowired
	IFilmServices iFilmServices;
	
	@RequestMapping("/getFilmsByCategory")
	public @ResponseBody JsonObject getFilmsByCategory(){
		return iFilmServices.getFilmsByCategory();
	}
}
