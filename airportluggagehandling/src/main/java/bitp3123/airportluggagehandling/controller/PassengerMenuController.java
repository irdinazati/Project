package bitp3123.airportluggagehandling.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import bitp3123.airportluggagehandling.model.Passenger;

@Controller
public class PassengerMenuController {
	
	private String defaultURI;
	
	@GetMapping("/passenger/list")
	public String getPassengers (Model model)
	{
		// The URI for GET passenger
		String uri = "http://localhost:8080/airportluggageapp/api/passengers";
		
		// Get a list airport from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Passenger[]> response = restTemplate.getForEntity(uri, Passenger[].class);
		
		// Parse JSON data to array of object
		Passenger passengers[] = response.getBody();
		
		
		// Parse an array to a list object
		List<Passenger> passengerList = Arrays.asList(passengers);
		
		// Attach list to model as attribute 
		model.addAttribute("passengers", passengerList);
		
		return "passengers";
		
	}
	
	@RequestMapping("/passenger/save")
	public String updatePassenger (@ModelAttribute Passenger passenger)
	{
		// Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		// Create request body
		HttpEntity<Passenger> request = new HttpEntity<Passenger>(passenger);
		
		String passengerResponse = "";
		
		if (passenger.getPassengerId() > 0)
		{
			// This block update an new order type and send request as PUT
			restTemplate.put(defaultURI, request, Passenger.class);
		}
		else 
		{
			// This block ass a new passenger and send request as POST
			passengerResponse = restTemplate.postForObject(defaultURI, request, String.class);
			
		}
		
		System.out.println(passengerResponse);
		
		// Redirect request to display a list of passenger
		return "redirect:/passenger/list";
	}
	
	@GetMapping("/passenger/{passengerId}")
	public String getPassenger (@PathVariable int passengerId, Model model) {
		
		String title = "New Passenger";
		Passenger passenger = new Passenger();
		
		// This block get an passenger to be updated
		if (passengerId > 0) {

			// Generate new URI and append passengerID to it
			String uri = defaultURI + "/" + passengerId;
			
			// Get an order type from the web service
			RestTemplate restTemplate = new RestTemplate();
			passenger = restTemplate.getForObject(uri, Passenger.class);
			
			//Give a new title to the page
			title = "Edit Passenger";
		}
		
		// Attach value to pass to front end
		model.addAttribute("Passenger", passenger);
		model.addAttribute("pageTitle", title);
		
		return "passengerinfo";
			
	}
	
	/**
	 * This method deletes an passenger
	 * 
	 * @param passengerID
	 * @return
	 */
	@RequestMapping("/passenger/delete/{passengerId}")
	public String deletePassenger(@PathVariable String passengerId)
	{
		// Generate new URI, similar to the mapping in PassengerRESTController
		String uri = defaultURI + "/{passengerId}";
		
		// Send a DELETE request and attach the value of orderTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("passengerId",(passengerId)));
		
		return "redirect:/passenger/list";
	}
	

}