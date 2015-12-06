// Start of user code imports
package at.fhv.pme.tyme.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.*;
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
    @Produces("text/html")
    public String get(@PathParam("path") String path) throws Exception {
        // Start of user code get
        StringBuilder sb = new StringBuilder();
        try {
            if (path.isEmpty()) {
                throw new FileNotFoundException();
            }

            InputStream stream = PageController.class.getResourceAsStream("/" + path);
            if (stream == null) {
                throw new FileNotFoundException();
            }

            BufferedReader fileReader = new BufferedReader(new InputStreamReader(stream));
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
