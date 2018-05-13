package persistence;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.hibernate.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.vehicle.Vehicle;
import model.vehicleType.Category;
import service.VehicleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml", "/META-INF/spring-application-context.xml"})
public class VehicleRepositoryTest {
	
    @Autowired
    private VehicleService vehicleService;
    
	@After
	public void tearDown() {
		vehicleService.retriveAll().stream().forEach(user -> vehicleService.delete(user));
	}
    
    @Test
    public void testSave() {

    	Vehicle vehicle = new Vehicle(Category.car(), "Auto grande y espacioso. Motor 2.0." , new ArrayList<BufferedImage>(), 5);

    	vehicleService.save(vehicle);
        assertEquals(1, vehicleService.retriveAll().size());
    }
    

    @Test
    public void testRestoreFromDataBaseVehicle() {
    	Vehicle vehicle = new Vehicle(Category.car(), "Auto grande y espacioso. Motor 2.0." , new ArrayList<BufferedImage>(), 5);
    	
    	vehicleService.save(vehicle);
    	
    	Vehicle restoredVehicle = vehicleService.searchById(vehicle.getId());
    	
    	assertEquals(restoredVehicle.getPassengerCapacity(), vehicle.getPassengerCapacity());
    	assertEquals(restoredVehicle.getDescription(), vehicle.getDescription());

    }
    
    @Test
    public void testUpdateVehicle() {
    	Vehicle vehicle = new Vehicle(Category.car(), "Auto grande y espacioso. Motor 2.0." , new ArrayList<BufferedImage>(), 5);
    	
    	vehicleService.save(vehicle);
    	
    	Vehicle restoredVehicle = vehicleService.searchById(vehicle.getId());
    	
    	String newDescription = "No es tan grande pero si muy espacioso. Motor 2.0";
    	
    	restoredVehicle.setDescription(newDescription);
    	
    	vehicleService.update(restoredVehicle);
    	
    	restoredVehicle = vehicleService.searchById(vehicle.getId());
    	
    	assertEquals(restoredVehicle.getPassengerCapacity(), vehicle.getPassengerCapacity());
    	assertEquals(restoredVehicle.getDescription(), newDescription);

    }


}