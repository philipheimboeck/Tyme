package at.fhv.pme.tyme.persistence;

import at.fhv.pme.tyme.entities.Timetrack;	


/**
 * DbFacade
 */
public class DbFacade {

	static DbFacade _instance = null;

	static DbFacade getInstance() {
		if(_instance == null) {
			_instance = new DbFacade();
		}
		return _instance;
	}

	private DbFacade() {
		// Start of user code DbFacade
		// TODO Implement
		// End of user code
	}

	public String host;
	
	public String user;
	
	public String pass;
	
	public String dbname;
	public String getHost() {
		return this.host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getDbname() {
		return this.dbname;
	}
	
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	

  		/**
  		 * deleteTimeTrack
  		*/
  		public void deleteTimeTrack(Timetrack timeTrack) {
  			// Start of user code deleteTimeTrack
  			// TODO Implement
  			// End of user code
  		}

  		/**
  		 * insertTimetrack
  		*/
  		public void insertTimetrack(Timetrack timeTrack) {
  			// Start of user code insertTimetrack
  			// TODO Implement
  			// End of user code
  		}

  		/**
  		 * getTimeTracks
  		*/
  		public Timetrack getTimeTracks() {
  			// Start of user code getTimeTracks
  			// TODO Implement
  			// End of user code
  		}

  		/**
  		 * getTimeTracks
  		*/
  		public java.util.Set<Timetrack> getTimeTracks(String username) {
  			// Start of user code getTimeTracks
  			// TODO Implement
  			// End of user code
  		}
}
