package webService.vehiclecorcern;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import model.publication.Publication;
import service.publication.PublicationService;
import webService.utils.JsonReturn;

@Path("/publications")
public class PublicationRest {

    private PublicationService publicationService;
    private JsonReturn<Publication> jsonReturn;


    @GET
    @Path("/")
    @Produces("application/json")
    public ResponseEntity retriveAll() {
        return new ResponseEntity<List<Publication>>(this.publicationService.retriveAll(),HttpStatus.OK);
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ResponseEntity seachById(@PathParam("id") final Long id) {
        return new ResponseEntity<Publication>(publicationService.searchById(id),HttpStatus.OK);
    }
    
    @POST
    @Path("/newPublication")
    @Produces("application/json")
    public ResponseEntity newVehicle(@RequestBody Publication vehicle) {
    	
    	publicationService.save(vehicle);

		return new ResponseEntity<Publication>(vehicle, HttpStatus.OK);
    }
    
    @PUT
    @Path("/publication/{id}")
    @Produces("application/json")
    public ResponseEntity<?> updateVehicleById(@PathParam("id") final Long id, @RequestBody Publication vehicle) {
		try {
			publicationService.updateById(id,vehicle);
			return new ResponseEntity<Publication>(vehicle, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    

	@DELETE
    @Path("/delete/{id}")
    @Produces("application/json")
    public void deleteById(@PathParam("id") final Long id) {
    	publicationService.delete(publicationService.searchById(id));
    }


    public void setPublicationService(final PublicationService aService) {
        this.publicationService = aService;
    }

    public void setJsonReturn(final JsonReturn jsonReturn) {
        this.jsonReturn = jsonReturn;
    }
}

