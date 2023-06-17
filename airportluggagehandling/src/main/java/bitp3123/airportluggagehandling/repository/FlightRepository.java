package bitp3123.airportluggagehandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bitp3123.airportluggagehandling.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
