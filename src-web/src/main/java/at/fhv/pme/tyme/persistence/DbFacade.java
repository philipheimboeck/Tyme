// Start of user code imports
package at.fhv.pme.tyme.persistence;

import at.fhv.pme.tyme.entities.Timetrack;
import at.fhv.pme.tyme.entities.User;

import java.sql.*;
import java.util.HashSet;

// End of user code

/**
 * DbFacade
 */
public class DbFacade {

	static DbFacade _instance = null;

	public static DbFacade getInstance() {
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

	public String dbhost = "localhost";
	
	public String dbuser = "s4";
	
	public String dbpass = "s4";
	
	public String dbname = "tyme";
	
	public String getDbhost() {
		return this.dbhost;
	}
	
	public void setDbhost(String dbhost) {
		this.dbhost = dbhost;
	}
	
	public String getDbuser() {
		return this.dbuser;
	}
	
	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}
	
	public String getDbpass() {
		return this.dbpass;
	}
	
	public void setDbpass(String dbpass) {
		this.dbpass = dbpass;
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
  		public void deleteTimeTrack(Timetrack timeTrack) throws Exception {
  			// Start of user code deleteTimeTrack
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "DELETE FROM timetrack WHERE timetrack.id = ?";

            st = connection.prepareStatement(query);
            st.setInt(1, timeTrack.getId());
            st.executeUpdate();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // End of user code
  		}

  		/**
  		 * insertTimetrack
  		*/
  		public void insertTimetrack(Timetrack timeTrack) throws Exception {
  			// Start of user code insertTimetrack
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "INSERT INTO timetrack (name, start_stamp, end_stamp, description, user_id) VALUES (?, ?, ?, ?, ?)";

            st = connection.prepareStatement(query);
            st.setString(1, timeTrack.getName());
            st.setLong(2, timeTrack.getStartStamp());
            st.setLong(3, timeTrack.getEndStamp());
            st.setString(4, timeTrack.getDescription());
            st.setInt(5, timeTrack.getUser().getId());
            st.executeUpdate();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // End of user code
  		}

  		/**
  		 * getAllTimeTracks
  		*/
  		public java.util.Set<Timetrack> getAllTimeTracks() throws Exception {
  			// Start of user code getAllTimeTracks
        java.util.Set<Timetrack> timetracks = new HashSet<>();
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "SELECT timetrack.id, timetrack.name, timetrack.start_stamp, timetrack.end_stamp, timetrack.description, user.id, user.name FROM timetrack INNER JOIN user ON timetrack.user_id = user.id";

            st = connection.prepareStatement(query);
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                Timetrack timetrack = new Timetrack();
                timetrack.setId(resultSet.getInt(1));
                timetrack.setName(resultSet.getString(2));
                timetrack.setStartStamp(resultSet.getLong(3));
                timetrack.setEndStamp(resultSet.getLong(4));
                timetrack.setDescription(resultSet.getString(5));
                timetrack.setUser(user);

                user.setId(resultSet.getInt(6));
                user.setName(resultSet.getString(7));

                timetracks.add(timetrack);
            }

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return timetracks;
        // End of user code
  		}

  		/**
  		 * getTimeTracks
  		*/
  		public java.util.Set<Timetrack> getTimeTracks(String search) throws Exception {
  			// Start of user code getTimeTracks
        java.util.Set<Timetrack> timetracks = new HashSet<>();
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "SELECT timetrack.id, timetrack.name, timetrack.start_stamp, timetrack.end_stamp, timetrack.description, user.id, user.name FROM timetrack INNER JOIN user ON timetrack.user_id = user.id WHERE timetrack.name LIKE ? OR user.name LIKE ?";

            st = connection.prepareStatement(query);
            st.setString(1, "%" + search + "%");
            st.setString(2, "%" + search + "%");
            ResultSet resultSet = st.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                Timetrack timetrack = new Timetrack();
                timetrack.setId(resultSet.getInt(1));
                timetrack.setName(resultSet.getString(2));
                timetrack.setStartStamp(resultSet.getLong(3));
                timetrack.setEndStamp(resultSet.getLong(4));
                timetrack.setDescription(resultSet.getString(5));

                user.setId(resultSet.getInt(6));
                user.setName(resultSet.getString(7));
                timetrack.setUser(user);

                timetracks.add(timetrack);
            }

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return timetracks;
        // End of user code
  		}

  		/**
  		 * getUser
  		*/
  		public User getUser(int id) throws Exception {
  			// Start of user code getUser
        User user = null;
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "SELECT id, name FROM user WHERE user.id = ?";

            st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
            }

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
        // End of user code
  		}

  		/**
  		 * getTimetrack
  		*/
  		public Timetrack getTimetrack(int id) throws Exception {
  			// Start of user code getTimetrack
        Timetrack timetrack = null;
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "SELECT timetrack.id, timetrack.name, timetrack.start_stamp, timetrack.end_stamp, timetrack.description, user.id, user.name FROM timetrack INNER JOIN user ON timetrack.user_id = user.id WHERE timetrack.id = ?";

            st = connection.prepareStatement(query);
            st.setInt(1, id);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {

                User user = new User();

                timetrack = new Timetrack();
                timetrack.setId(resultSet.getInt(1));
                timetrack.setName(resultSet.getString(2));
                timetrack.setStartStamp(resultSet.getLong(3));
                timetrack.setEndStamp(resultSet.getLong(4));
                timetrack.setDescription(resultSet.getString(5));
                timetrack.setUser(getUser(resultSet.getInt(6)));
                timetrack.setUser(user);

                user.setId(resultSet.getInt(6));
                user.setName(resultSet.getString(7));
            }

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return timetrack;
        // End of user code
  		}

  		/**
  		 * insertUser
  		*/
  		public void insertUser(User user) throws Exception {
  			// Start of user code insertUser
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "INSERT INTO user (name) VALUES (?)";

            st = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getName());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // End of user code
  		}

  		/**
  		 * getUserByName
  		*/
  		public User getUserByName(String name) throws Exception {
  			// Start of user code getUserByName
        User user = null;
        Connection connection = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + dbhost + "/" + dbname, dbuser, dbpass);
            String query = "SELECT id, name FROM user WHERE user.name = ?";

            st = connection.prepareStatement(query);
            st.setString(1, name);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
            }

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
        // End of user code
  		}
}
