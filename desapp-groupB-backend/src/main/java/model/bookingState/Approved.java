package model.bookingState;

public class Approved extends BookingState {

    private Boolean confirmRetreatSeller;
    private Boolean confirmRetreatBuyer;
    private Boolean confirmReturnBuyer;
    private Boolean confirmReturnSeller;

    public Approved(){
        this.confirmRetreatSeller = false;
        this.confirmRetreatBuyer = false;
        this.confirmReturnBuyer = false;
        this.confirmReturnSeller = false;
    }

    @Override
    public BookingState setAcepted() {
        return this;
    }

    @Override
    public BookingState setRejected() {
        return new Rejected();
    }

    /** Setters and Getters **/

    @Override
    public Boolean getConfirmRetreatBuyer(){
        return this.confirmRetreatBuyer;
    }

    @Override
    public Boolean getConfirmRetreatSeller(){
        return this.confirmRetreatSeller;
    }

    @Override
    public Boolean getConfirmReturnBuyer(){
        return this.confirmReturnBuyer;
    }

    @Override
    public Boolean getConfirmReturnSeller(){
        return this.confirmRetreatSeller;
    }

    @Override
    public void setConfirmRetreatBuyer(Boolean confirmRetreatBuyer){
        this.confirmRetreatBuyer = confirmRetreatBuyer;
    }

    @Override
    public void setConfirmRetreatSeller(Boolean confirmRetreatSeller){
        this.confirmRetreatSeller = confirmRetreatSeller;
    }

    @Override
    public void setConfirmReturnBuyer(Boolean confirmReturnBuyer){
        this.confirmReturnBuyer = confirmReturnBuyer;
    }

    @Override
    public void setConfirmReturnSeller(Boolean confirmReturnSeller){
        this.confirmReturnSeller = confirmReturnSeller;
    }
}