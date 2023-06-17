package bitp3123.airportluggagehandling.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import bitp3123.airportluggagehandling.model.Airport;



@Controller 
public class AirportMenuController {

	
	@GetMapping("/airport/list")
	public String getAirports (Model model)
	{
		// The URI for GET airport
		String uri = "http://localhost:8080/airportluggageapp/api/airports";
		
		// Get a list airport from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Airport[]> response = restTemplate.getForEntity(uri, Airport[].class);
		
		// Parse JSON data to array of object
		Airport airports[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Airport> airportList = Arrays.asList(airports);
		
		// Attach list to model as attribute 
		model.addAttribute("airports", airportList);
		
		
		// returning HTML file
		return "airport";
		
	}
}