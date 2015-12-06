package at.fhv.pme.tyme.entities;



/**
 * Timetrack
 */
public class Timetrack {


	public Timetrack() {
		// Start of user code Timetrack
		// TODO Implement
		// End of user code
	}

	private int id;
	
	private String name;
	
	private long startStamp;
	
	private long endStamp;
	
	private String description;
	
	public User user;
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getStartStamp() {
		return this.startStamp;
	}
	
	public void setStartStamp(long startStamp) {
		this.startStamp = startStamp;
	}
	
	public long getEndStamp() {
		return this.endStamp;
	}
	
	public void setEndStamp(long endStamp) {
		this.endStamp = endStamp;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	

}
