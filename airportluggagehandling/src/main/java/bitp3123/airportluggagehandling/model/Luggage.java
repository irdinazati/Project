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
@Table(name = "luggage")
public class Luggage {

	//Primary Key
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "LuggageId")
		private int luggageId;

	  @ManyToOne
	  @JoinColumn(name = "PassengerId")
	  private Passenger passenger;

	public int getLuggageId() {
		return luggageId;
	}

	public void setLuggageId(int luggageId) {
		this.luggageId = luggageId;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
}
