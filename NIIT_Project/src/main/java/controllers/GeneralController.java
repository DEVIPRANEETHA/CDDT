package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="UserHome")
	public String userHome() {
		return "WelcomePage";
	}
	
	@RequestMapping(value="AdminHome")
	public String adminHome() {
		return "AdminPage";
	}
	
	@RequestMapping(value="UserAboutUs")
	public String userAboutUs() {
		return "UserAboutusPage";
	}
	
	@RequestMapping(value="AdminAboutUs")
	public String adminAboutUs() {
		return "AdminAboutusPage";
	}
	
	@RequestMapping(value="UserContactUs")
	public String userContactUs() {
		return "UserContactusPage";
	}
	
	@RequestMapping(value="AdminContactUs")
	public String adminContactUs() {
		return "AdminContactusPage";
	}
}
