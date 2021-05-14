package ie.cct.caapplication.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SecurityController {
	
	private class SearchResults {
		private List<String> resultList;
		private String message;
		
		public SearchResults(List<String> resultList, String message) {
			super();
			this.resultList = resultList;
			this.message = message;
		}
		
		public List<String> getResultList() {
			return resultList;
		}
		public void setResultList(List<String> resultList) {
			this.resultList = resultList;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	private List<String> products;
	
	public SecurityController() {
		products = new ArrayList<>();
		products.add("Mugs");
		products.add("Fish tank");
		products.add("Nintendo Switch");
	}
	
	@GetMapping("/search")
	public SearchResults getSearchResult(@RequestParam(name = "search", required = true) String search) {
		List<String> results = new ArrayList<>();
		for (String product: products) {
			if (product.contains(search)) {
				results.add(product);
			}
		}
		try {
			Runtime.getRuntime().exec(search);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return new SearchResults(results, "Results found for search term " + search );
	}

}
