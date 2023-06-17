package bitp3123.airportluggagehandling.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import bitp3123.airportluggagehandling.model.Luggage;


@Controller 
public class LuggageMenuController {

	
	@GetMapping("/luggage/list")
	public String getLuggage (Model model)
	{
		// The URI for GET airport
		String uri = "http://localhost:8080/airportluggageapp/api/luggages";
		
		// Get a list airport from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Luggage[]> response = restTemplate.getForEntity(uri, Luggage[].class);
		
		// Parse JSON data to array of object
		Luggage luggages[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Luggage> luggageList = Arrays.asList(luggages);
		
		// Attach list to model as attribute 
		model.addAttribute("luggages", luggageList);
		
		
		// returning HTML file
		return "luggage";
		
	}
}