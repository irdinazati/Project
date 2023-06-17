package bitp3123.airportluggagehandling.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passenger")
public class Passenger {

	//Primary Key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "PassengerId")
		private int passengerId;
		
		@Column(name = "Name")
		private String Name;
		
		@Column(name = "Email")
		private String Email;
		
		@Column(name = "PhoneNumber")
		private String PhoneNumber;
		
		@Column(name = "Gender")
		private String Gender;
		
		@ManyToOne
		  @JoinColumn(name = "FlightId")
		  private Flight flight;
		

		public int getPassengerId() {
			return passengerId;
		}

		public void setPassengerId(int passengerId) {
			this.passengerId = passengerId;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			this.Name = name;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			this.Email = email;
		}

		public String getPhoneNumber() {
			return PhoneNumber;
		}

		public void setPhoneNumber(String PhoneNumber) {
			this.PhoneNumber = PhoneNumber;
		}

		public String getGender() {
			return Gender;
		}

		public void setGender(String gender) {
			this.Gender = gender;
		}

		public Flight getFlight() {
			return flight;
		}

		public void setFlight(Flight flight) {
			this.flight = flight;
		}

}
