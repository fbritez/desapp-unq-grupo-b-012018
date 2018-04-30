package webService;

import model.vehicle.Vehicle;
import persistence.VehicleRepository;
import service.VehicleService;

import javax.ws.rs.*;
import java.util.List;

@Path("/vehicles")
public class VehicleRest{

    private VehicleService vehicleService;
    private JsonReturn<Vehicle> jsonReturn;

    public VehicleRest(){
        this.vehicleService = new VehicleService();
        this.vehicleService.setRepository(new VehicleRepository());
        this.jsonReturn = new JsonReturn<>();
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public List<Vehicle> retriveAll() {
        return this.vehicleService.retriveAll();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Vehicle seachById(@PathParam("id") final Integer id) {
        try{
            return new Vehicle();
        }catch (NotFoundException nf){
            return jsonReturn.notFoundError("The vehicle was not found");
        }
    }

    public void setVehicleService(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public void setJsonReturn(final JsonReturn jsonReturn) {
        this.jsonReturn = jsonReturn;
    }
}