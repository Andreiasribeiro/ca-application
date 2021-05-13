package ie.cct.caapplication.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.caapplication.controller.model.User;

@RestController
@CrossOrigin(origins = "*")
public class FirstController {

	// Method to get user name and password
	@GetMapping("user") // localhost:8080/user
	public User getUser() {
		return new User("Andreia", "123password");
	}

	@GetMapping("authenticate")
	public User authenticateUser(String username, String password) {

		if (username.equalsIgnoreCase("andreia") && password.equalsIgnoreCase("secret")) {
			return new User("andreia", "secret");

		}
		throw new RuntimeException("Username or password is incorrect");

	}

	@GetMapping("loging")
	public String loging(
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "password", required = true) String password, HttpServletRequest request) {
		
		if(request.getHeader("andreia-hearder")!= null && request.getHeader("andreia-hearder").equals("mysecret")) {
			
			return "Hello, my name is " + name + " and my password is " + password + ". Your hearder is "
					+ request.getHeader("andreia-hearder");
			//"andreia-hearder" in the CA will be a array
		}
		else {
		return "Unathorized";
		}

	}
}

//curl "192.168.0.199:8080/authenticate?username=andreia&password=secret" -v
