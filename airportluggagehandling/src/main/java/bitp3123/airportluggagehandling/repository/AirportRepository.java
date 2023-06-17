package bitp3123.airportluggagehandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bitp3123.airportluggagehandling.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
