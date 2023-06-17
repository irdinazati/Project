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

import bitp3123.airportluggagehandling.model.Passenger;
import bitp3123.airportluggagehandling.repository.PassengerRepository;


@RestController
@RequestMapping("/api/passengers")
public class PassengerRESTController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@DeleteMapping("{passengerId}")
	public ResponseEntity<HttpStatus> deletePassenger(@PathVariable long PassengerId)
	{
		passengerRepository.deleteById(PassengerId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Passenger> getPassenger()
	{
		return passengerRepository.findAll();
	}
	
	@GetMapping ("{passengerId}")
	public Passenger getPassenger(@PathVariable long passengerId )
	{
		Passenger passenger = passengerRepository.findById(passengerId).get();
		
		return passenger;
	}
	
	@PostMapping
	public Passenger insertPassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}
	
	@PutMapping
	public Passenger updatePassenger (@RequestBody Passenger passenger)
	{
		return passengerRepository.save(passenger);
	}

}