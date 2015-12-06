// Start of user code imports
package at.fhv.pme.tyme.controller;


import javax.ws.rs.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// End of user code

/**
 * PageController
 */
@Path("/")
public class PageController {

	
	

  		/**
  		 * get
  		*/
  		@Path("{path:.*}")
  		@GET
  		public String get(@PathParam("path") String path) {
  			// Start of user code get
        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader fileReader = new BufferedReader(new InputStreamReader(PageController.class.getResourceAsStream("/" + path)));
            String line = fileReader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = fileReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
        // End of user code
  		}
}
