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

import bitp3123.airportluggagehandling.model.Airport;
import bitp3123.airportluggagehandling.repository.AirportRepository;


/*
 * This REST Controller request REST web service in PROVIDER site
 * 
 * @Author Nur Irdina Izzati Binti Khairuzaman
 * 
 */

@RestController
@RequestMapping("/api/airports")

public class AirportRESTController {
	
	@Autowired
	private AirportRepository airportRepository;
	
	// delete order type record based on Id
	@DeleteMapping("{airportId}")
	public ResponseEntity<HttpStatus> deleteAirport(@PathVariable long airportId)
	{
		airportRepository.deleteById(airportId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// retrieve all order types detail
	@GetMapping
	public List<Airport> getAirport()
	{
		return airportRepository.findAll();
		
	}
	
	// retrieve product detail based on product ID
	@GetMapping("{airportId}")
	public Airport getAirport(@PathVariable long airportId)
	{
		Airport airport = airportRepository.findById(airportId).get();
		return airport;
	}

	// insert records for order type
	@PostMapping
	public Airport insertAirport(@RequestBody Airport airport)
	{
		return airportRepository.save(airport);
	}

	// update records for order type
	@PutMapping
	public Airport updateAirport(@RequestBody Airport airport)
	{
		return airportRepository.save(airport);
	}
	
}