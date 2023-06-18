package bitp3123.airportluggagehandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitp3123.airportluggagehandling.model.Flight;
import bitp3123.airportluggagehandling.model.Luggage;
import bitp3123.airportluggagehandling.repository.FlightRepository;


/*
 * This REST Controller request REST web service in PROVIDER site
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */

@RestController
@RequestMapping("/api/flights")

public class FlightRESTController {
	
	@Autowired
	private FlightRepository flightRepository;
	
	// delete flight based on Id
	@DeleteMapping("{flightId}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable long flightId)
	{
		flightRepository.deleteById(flightId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// retrieve all order types detail
	@GetMapping
	public List<Flight> getFlight()
	{
		return flightRepository.findAll();
		
	}
	
	// retrieve product detail based on product ID
	@GetMapping("{flightId}")
	public Flight getFlight(@PathVariable long flightId)
	{
		Flight flight = flightRepository.findById(flightId).get();
		return flight;
	}

	// insert records for order type
	@PostMapping
	public Flight insertFlight(@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}

	// update records for order type
	@PutMapping
	public Flight updateFlight(@RequestBody Flight flight)
	{
		return flightRepository.save(flight);
	}
	
}

