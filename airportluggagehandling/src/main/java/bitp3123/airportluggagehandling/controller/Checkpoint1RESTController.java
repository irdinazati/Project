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

import bitp3123.airportluggagehandling.model.Checkpoint1;
import bitp3123.airportluggagehandling.repository.Checkpoint1Repository;


@RestController
@RequestMapping("/api/checkpoints1")
public class Checkpoint1RESTController {
	
	@Autowired
	private Checkpoint1Repository checkpoint1Repository;
	
	// delete flight based on Id
	@DeleteMapping("{checkpoint1Id}")
	public ResponseEntity<HttpStatus> deleteCheckpoint1(@PathVariable long checkpoint1Id)
	{
		checkpoint1Repository.deleteById(checkpoint1Id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Checkpoint1> getCheckpoint1()
	{
		return checkpoint1Repository.findAll();
	}
	
	@GetMapping ("{checkpoint1Id}")
	public Checkpoint1 getCheckpoint1(@PathVariable long checkpoint1Id )
	{
		Checkpoint1 checkpoint1 = checkpoint1Repository.findById(checkpoint1Id).get();
		
		return checkpoint1;
	}
	
	@PostMapping
	public Checkpoint1 insertCheckpoint1 (@RequestBody Checkpoint1 checkpoint1)
	{
		return checkpoint1Repository.save(checkpoint1);
	}
	
	@PutMapping
	public Checkpoint1 updateCheckpoint1 (@RequestBody Checkpoint1 checkpoint1)
	{
		return checkpoint1Repository.save(checkpoint1);
	}

}
