package model.builders;

import model.user.User;
import model.vehicle.Vehicle;
import model.vehicletype.Category;

import java.util.List;

public class VehicleBuilder {

    private Vehicle buildVehicle;

    public VehicleBuilder createVehicle() {
        this.buildVehicle = new Vehicle();
        return this;
    }

    public Vehicle build() {
        return this.buildVehicle;
    }

    public VehicleBuilder withDescription(String anyDescription) {
        this.buildVehicle.setDescription(anyDescription);
        return this;
    }

    public VehicleBuilder withPassengerCapacity(Integer anyPassengerCapacity) {
        this.buildVehicle.setPassengerCapacity(anyPassengerCapacity);
        return this;
    }

    public VehicleBuilder withPictures(List<String> anyPictures) {
        buildVehicle.setPictures(anyPictures);
        return this;
    }

    public VehicleBuilder withCategory(Category anyCategory) {
        buildVehicle.setCategory(anyCategory);
        return this;
    }
    public VehicleBuilder withOwner(User anUser) {
        buildVehicle.setOwner(anUser);
        return this;
    }
}
