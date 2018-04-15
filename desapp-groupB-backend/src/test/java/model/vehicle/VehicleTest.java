package model.vehicle;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.score.OwnerScoreType;
import model.score.Score;
import model.vehicleType.Category;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class VehicleTest {
	
	private Vehicle vehicle;
	private List<BufferedImage> collectionOfPictures;
	
    @Before
    public void setUp() {
    	collectionOfPictures = spy(new ArrayList<BufferedImage>());
    	vehicle = new Vehicle(Category.car(), "Auto grande y espacioso. Motor 2.0." , collectionOfPictures, 5);
    }

	@Test
	public void testCreation() {
		assertTrue(vehicle.itsCategory(Category.car()));
		
		assertEquals(vehicle.description(), "Auto grande y espacioso. Motor 2.0.");
		assertEquals(vehicle.pictures(),collectionOfPictures);
		assertEquals(vehicle.passengerCapacity(), new Integer(5));
	}
	
	
	@Test
	public void testAddPicture() {
		BufferedImage img = mock(BufferedImage.class);
		vehicle.addPicture(img);
		verify(collectionOfPictures).add(any(BufferedImage.class));

	}

}