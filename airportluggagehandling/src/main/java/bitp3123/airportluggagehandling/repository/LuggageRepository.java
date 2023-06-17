package bitp3123.airportluggagehandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bitp3123.airportluggagehandling.model.Luggage;

public interface LuggageRepository extends JpaRepository<Luggage, Long> {

}
