import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
 
@Path("/")
@Produces("text/plain")
@Consumes("text/plain")
public class deafService {           
  @GET
  public Response welcomeMsg() {
    return Response.ok("How many deaf rats are in your chain? Send a POST with it!").build(); 
  }
  
  @POST
  public Response checkDeafRats(String chain) {	  
  return Response.ok(deafRats(chain)).build();
  }
  
  public String deafRats(String chain) {
	  int rats = 0, i = 0;
	  boolean piper_found = false;
	  
	  while (i < chain.length()) {
		  if (chain.charAt(i) == '~' && i + 1 < chain.length() && chain.charAt(i+1) == 'O'){
			  if (piper_found){
				  rats += 1;
			  }
			  i += 2;
		  } else if (chain.charAt(i) == 'O' && i+1 < chain.length() && chain.charAt(i+1) == '~') {
			  if (!piper_found){
				  rats += 1;
			  }
			  i += 2;
		  } else if(chain.charAt(i) == 'P') {
			  piper_found = true;
			  i += 1;
		  } else {
			  return "Wrong character found!";
		  }
	  }
	  if (!piper_found) {
		  return "Not Pied Piper found, unable to recognize deaf rats.";
	  } else {
		  return "There are " + rats + " deaf rats";  
	  }
  }
}