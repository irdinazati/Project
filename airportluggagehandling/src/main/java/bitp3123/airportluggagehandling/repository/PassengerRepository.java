package bitp3123.airportluggagehandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bitp3123.airportluggagehandling.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
