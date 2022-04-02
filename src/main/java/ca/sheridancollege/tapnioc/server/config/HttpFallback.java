package ca.sheridancollege.tapnioc.server.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HttpFallback {

	//this serves as my http fallback for my angular routing (needed for my authentication pages)
	//reference: https://angular.io/guide/deployment#fallback-configuration-examples
	@GetMapping("/home")
	public String home() {
	    return "redirect:/";
	}
}
