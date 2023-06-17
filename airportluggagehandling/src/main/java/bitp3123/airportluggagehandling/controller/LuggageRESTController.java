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

import bitp3123.airportluggagehandling.model.Luggage;
import bitp3123.airportluggagehandling.repository.LuggageRepository;


/*
 * This REST Controller request REST web service in PROVIDER site
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */

@RestController
@RequestMapping("/api/luggages")

public class LuggageRESTController {
	
	@Autowired
	private LuggageRepository luggageRepository;
	
	// delete order type record based on Id
	@DeleteMapping("{lggageId}")
	public ResponseEntity<HttpStatus> deleteLuggage(@PathVariable long luggageId)
	{
		luggageRepository.deleteById(luggageId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// retrieve all order types detail
	@GetMapping
	public List<Luggage> getLuggage()
	{
		return luggageRepository.findAll();
		
	}
	
	// retrieve product detail based on product ID
	@GetMapping("{luggageId}")
	public Luggage getLuggage(@PathVariable long luggageId)
	{
		Luggage luggage = luggageRepository.findById(luggageId).get();
		return luggage;
	}

	// insert records for order type
	@PostMapping
	public Luggage insertLuggage(@RequestBody Luggage luggage)
	{
		return luggageRepository.save(luggage);
	}

	// update records for order type
	@PutMapping
	public Luggage updateLuggage(@RequestBody Luggage luggage)
	{
		return luggageRepository.save(luggage);
	}
	
}