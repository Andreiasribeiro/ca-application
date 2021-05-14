package ie.cct.caapplication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*") // Vulnerability. cbwt.cct.ie -> website | api.cbwt.cct.ie
public class FetchController {
	
	private class Test {
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Test(String message) {
			super();
			this.message = message;
		}
	}
	
	@GetMapping("/message")
	public Test getMessage() {
		return new Test("This is my message");
	}
}
