package ie.cct.caapplication.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.caapplication.model.Expense;
import ie.cct.caapplication.util.JWTIssuer;
import io.jsonwebtoken.Claims;

@RestController
@CrossOrigin("*")
public class CAController {

	HashMap<String, String> users;

	private Map<String, ArrayList<Expense>> trips;
	// private List<Expense> trips;
	// private Set<Expense> trips;
	private boolean tripClosed = false;

	// constructor
	public CAController() {
		trips = new HashMap<>();
		users = new HashMap<>();

		users.put("Amilcar", "secret1");
		users.put("David", "secret2");
		users.put("Greg", "secret3");
		
		// trips = new ArrayList<Expense>()
	}

	// endpoint: GET /login
	// use JWT token to keep the user login -86400000 = one day in milliseconds
	@GetMapping("/login") // username and password
	public String login(@RequestParam(name = "username", required = true) String username,
			@RequestParam(name = "password", required = true) String password) {

		for (String key : users.keySet()) {
			if (key.equals(username) && users.get(key).equals(password)) {
				return JWTIssuer.createJWT(username, "ca-application", password, 86400000);
			}
		}

//		for (int i = 0; i < 3; i++) {
		// if (users[i].contentEquals(username) && password.contentEquals(password)) {

		// }

//		}
		// TODO return 401 error (Unauthorized), when the username or password do not
		// match.Expection with

		throw new RuntimeException("User or password is not correct");
	}

	// endpoint: POST /{trip}/expense (Can not send a Post request easily with the
	// browser. It is necessary to use curl or postman to test. Post send something
	// to the server)
	// a header to get the authentication from another method
	@PostMapping("/{trip}/expense") // Authorization: Bearer <token>
	public Map<String, ArrayList<Expense>> addExpense(@PathVariable("trip") String trip,
			@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody(required = true) Expense expense) {
		
		// TODO*****check if the trip is open
		// receive the token, verify and store
		// if not open, send back the http code 422 -unprocessable entity
		// class 07/05 1:00h
		// if (trips.get("TripName").isOpen) {Throw RuntimeException}
		if (tripClosed = false) {
			// TODO create our won RuntimeExpection
			throw new RuntimeException("This trip is closed");
		}
		// return 401 instead of 500.
		Claims claims = JWTIssuer.decodeJWT(token.split(" ")[1]);
		String subClaim = claims.get("sub", String.class);
		if (users.equals(subClaim)) {
			throw new RuntimeException("Unknown user");
		}
		// To identify the user in the expense
		expense.setUser(subClaim);

		// save the expense
		// If there is no expense create a empty list
		if (trips.get(trip) == null) {
			trips.put(trip, new ArrayList<Expense>());
		}
		// or add an expense
		trips.get(trip).add(expense);
		return trips;
	}

	// endpoint: GET /{trip}
	// @Path = partial modifications to a resource
	@GetMapping("/{trip}")
	public List<Expense> trips(@PathVariable("trips") String trip) {

		return trips.get(trip);

		// System.out.println(trips);
	}

	// endpoint: POST /{trip}/close
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PostMapping("/{trip}/close")
	public void closeTrip(String name) {

		if (tripClosed == true) {
			// trips.entrySet(null);
			// trips.notify();
		}

	}

	// endpoint: GET /{trip}/summary
	@GetMapping("/{trip}/summary")
	public String trip() {
		return " ";
	}

}
