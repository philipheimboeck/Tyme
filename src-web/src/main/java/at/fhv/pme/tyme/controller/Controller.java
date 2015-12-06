// Start of user code imports
package at.fhv.pme.tyme.controller;


import at.fhv.pme.tyme.entities.Timetrack;
import at.fhv.pme.tyme.entities.User;
import at.fhv.pme.tyme.persistence.DbFacade;
import org.json.JSONArray;
import org.json.JSONObject;

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
    @Produces("application/json")
    public String deleteTimeTrack(@PathParam("track") int trackId) throws Exception {
        // Start of user code deleteTimeTrack
        try {
            Timetrack timetrack = DbFacade.getInstance().getTimetrack(trackId);
            if (timetrack == null) {
                return new JSONObject().put("success", false).toString();
            }
            DbFacade.getInstance().deleteTimeTrack(timetrack);
            return new JSONObject().put("success", true).toString();

        } catch (Exception e) {
            return new JSONObject().put("success", false).put("error", e.getMessage()).toString();
        }
        // End of user code
    }

    /**
     * insertTimeTrack
     */
    @Path("addTrack")
    @POST
    @Produces("application/json")
    public String insertTimeTrack(@FormParam("name") String name, @FormParam("user") String userName, @FormParam("start") long startStamp, @FormParam("end") long endStamp, @FormParam("description") String description) throws Exception {
        // Start of user code insertTimeTrack
        try {
            User userEntity = DbFacade.getInstance().getUserByName(userName);
            if (userEntity == null) {
                userEntity = new User();
                userEntity.setName(userName);
                DbFacade.getInstance().insertUser(userEntity);
            }
            if (userEntity.getId() <= 0) {
                return new JSONObject().put("success", false).toString();
            }

            Timetrack timetrack = new Timetrack();
            timetrack.setName(name);
            timetrack.setStartStamp(startStamp);
            timetrack.setEndStamp(endStamp);
            timetrack.setDescription(description);
            timetrack.setUser(userEntity);

            DbFacade.getInstance().insertTimetrack(timetrack);
        } catch (Exception e) {
            return new JSONObject().put("success", false).put("error", e.getMessage()).toString();
        }

        return new JSONObject().put("success", true).toString();
        // End of user code
    }

    /**
     * searchTimeTrack
     */
    @Path("searchTrack")
    @GET
    @Produces("application/json")
    public String searchTimeTrack(@QueryParam("search") String searchString) throws Exception {
        // Start of user code searchTimeTrack
        try {
            return new JSONArray(DbFacade.getInstance().getTimeTracks(searchString)).toString();
        } catch (Exception e) {
            return new JSONObject().put("success", false).put("error", e.getMessage()).toString();
        }
        // End of user code
    }

    /**
     * getAllTracks
     */
    @Path("getTracks")
    @GET
    @Produces("application/json")
    public String getAllTracks() throws Exception {
        // Start of user code getAllTracks
        try {
            return new JSONArray(DbFacade.getInstance().getAllTimeTracks()).toString();
        } catch (Exception e) {
            return new JSONObject().put("success", false).put("error", e.getMessage()).toString();
        }
        // End of user code
    }
}
