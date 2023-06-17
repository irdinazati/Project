package bitp3123.airportluggagehandling.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {

	//Primary Key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "AirportId")
		private int airportId;
		
		@Column(name = "AirportName")
		private String airportName;

		public int getAirportId() {
			return airportId;
		}

		public void setAirportId(int airportId) {
			this.airportId = airportId;
		}

		public String getAirportName() {
			return airportName;
		}

		public void setAirportName(String airportName) {
			this.airportName = airportName;
		}
}
		