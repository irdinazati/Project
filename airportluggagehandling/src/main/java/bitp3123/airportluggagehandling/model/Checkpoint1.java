package bitp3123.airportluggagehandling.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Checkpoint1")
public class Checkpoint1 {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "Checkpoint1Id")
	private int checkpoint1Id;
	
	@Column (name = "CheckpointTime")
	private Time checkpointTime;
	
	@Column (name = "CheckpointDate")
	private Date checkpointDate;
	
	@ManyToOne
	@JoinColumn (name = "LuggageId")
	private Luggage luggage;
	
	@ManyToOne
	@JoinColumn (name = "PassengerId")
	private Passenger passenger;

	public int getCheckpoint1Id() {
		return checkpoint1Id;
	}

	public void setCheckpoint1Id(int checkpoint1Id) {
		this.checkpoint1Id = checkpoint1Id;
	}

	public Time getCheckpointTime() {
		return checkpointTime;
	}

	public void setCheckpointTime(Time checkpointTime) {
		this.checkpointTime = checkpointTime;
	}

	public Date getCheckpointDate() {
		return checkpointDate;
	}

	public void setCheckpointDate(Date checkpointDate) {
		this.checkpointDate = checkpointDate;
	}

	public Luggage getLuggage() {
		return luggage;
	}

	public void setLuggage(Luggage luggage) {
		this.luggage = luggage;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
