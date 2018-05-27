package model.bookingState;


import model.bookingstate.*;
import model.exceptions.NoAceptedException;
import org.junit.Before;
import org.junit.Test;


public class BookingStateTest {

    private BookingState anyState;

    @Before
    public void setUp() throws Exception {

        this.anyState = new AwaitingApproval();
    }

    @Test(expected = NoAceptedException.class)	
    public void testGetConfirmRetreatBuyer() throws NoAceptedException {
        anyState.getConfirmRetreatBuyer();
    }
    

    @Test(expected = NoAceptedException.class)	
    public void testGetConfirmRetreatSeller() throws NoAceptedException {
        anyState.getConfirmRetreatSeller();
    }
    
    @Test(expected = NoAceptedException.class)	
    public void testGetConfirmReturnBuyer() throws NoAceptedException {
        anyState.getConfirmReturnBuyer();
    }

    @Test(expected = NoAceptedException.class)	
    public void testGetConfirmReturnSeller() throws NoAceptedException {
        anyState.getConfirmReturnSeller();
    }

    @Test(expected = NoAceptedException.class)	
    public void testSetConfirmRetreatBuyer() throws NoAceptedException {
        anyState.setConfirmRetreatBuyer(true);
    }
    
    @Test(expected = NoAceptedException.class)	
    public void testSetConfirmRetreatSeller() throws NoAceptedException {
        anyState.setConfirmRetreatSeller(true);
    }

    @Test(expected = NoAceptedException.class)	
    public void testSetConfirmReturnBuyer() throws NoAceptedException {
        anyState.setConfirmReturnBuyer(true);
    }

    @Test(expected = NoAceptedException.class)	
    public void testSetConfirmReturnSeller() throws NoAceptedException {
        anyState.setConfirmReturnSeller(true);
    }
}
