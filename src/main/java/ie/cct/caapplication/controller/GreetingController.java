package ie.cct.caapplication.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private Map<String, String> translations;

	public GreetingController() {
		translations = new HashMap<>();
		translations.put("ES", "Buenos dias ");
		translations.put("EN", "Good morning ");
		translations.put("PT", "Bom dia ");
	}

	// Method to return a empty string
	@GetMapping("/greeter")
	public String greeting(@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "surname", required = true) String surname,
			@RequestHeader(name = "x-target-language", defaultValue = "EN") String targetLanguage,
			HttpServletRequest request) {
		String finalTargetLanguage = "";
		if (translations.keySet().contains(targetLanguage)) {
			finalTargetLanguage = targetLanguage;
		} else {

			finalTargetLanguage = "EN";
		}

		return translations.get(targetLanguage) + name + " " + surname;
	}
}
