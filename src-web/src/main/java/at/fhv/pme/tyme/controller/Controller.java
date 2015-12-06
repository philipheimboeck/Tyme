// Start of user code imports
package at.fhv.pme.tyme.controller;


import javax.ws.rs.*;
// End of user code

/**
 * Controller
 */
@Path("tyme/")
public class Controller {

	

  		/**
  		 * deleteTimeTrack
  		 * Hallo
  		*/
  		@Path("deleteTrack/{track}")
  		@DELETE
  		public String deleteTimeTrack(@PathParam("track") int trackId) {
  			// Start of user code deleteTimeTrack
  			// TODO Implement
			return "";
  			// End of user code
  		}

  		/**
  		 * insertTimeTrack
  		*/
  		@Path("addTrack")
  		@POST
  		public String insertTimeTrack(@FormParam("user") int user, @FormParam("start") long startStamp, @FormParam("end") long endStamp, @FormParam("description") String description) {
  			// Start of user code insertTimeTrack
  			// TODO Implement
			return "";
  			// End of user code
  		}

  		/**
  		 * searchTimeTrack
  		*/
  		@Path("searchTrack")
  		@GET
  		public String searchTimeTrack(@QueryParam("search") String searchString) {
  			// Start of user code searchTimeTrack
  			// TODO Implement
			return "";
  			// End of user code
  		}

  		/**
  		 * getAllTracks
  		*/
  		@Path("getTracks")
  		@GET
  		public String getAllTracks() {
  			// Start of user code getAllTracks
  			// TODO Implement
			return "";
  			// End of user code
  		}
}
