package model.vehicle;


import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import model.user.User;
import model.utils.Entity;
import model.vehicletype.Car;
import model.vehicletype.Category;
import model.vehicletype.Scooter;


public class Vehicle extends Entity{
	
	private static final long serialVersionUID = -7816019452762349441L;
	
	private Category category;
	private String description;
    private List<String> pictures; 
    private Integer passengerCapacity;
	private User owner;

    public Vehicle(Category aCategory , String aDescription, List<String> somePictures, Integer aNumberOfPassenger, User anOwner) {
		this.category = aCategory;
		this.description = aDescription;
		this.pictures = somePictures;
		this.passengerCapacity = aNumberOfPassenger;
		this.owner = anOwner;
    }
    public Vehicle(Category aCategory , String aDescription, List<String> somePictures, Integer aNumberOfPassenger) {
		this.category = aCategory;
		this.description = aDescription;
		this.pictures = somePictures;
		this.passengerCapacity = aNumberOfPassenger;
    }
    
    public Vehicle() {}
    
    public Boolean itsCategory(Category anyCategory) {
        return this.category.isSame(anyCategory);
    }

	public void addPicture(String imgPath) {
		pictures.add(imgPath);
	}

	/** Setters and Getters **/
    public Category getCategory() {
		return this.category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getPictures() {
		return this.pictures;
	}
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}

	public Integer getPassengerCapacity() {
		return this.passengerCapacity;
	}
	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	@JsonIgnore
    public User getOwner() {
		return owner;
	}
	@JsonProperty
	public void setOwner(User owner) {
		this.owner = owner;
	}

	 
    public static Category fromCode(String description) {
        for (Category category : avaliableCategories()){
            if (category.getName().equals(description)){
                return category;
            }
        }
        throw new UnsupportedOperationException();
    }

	private static List<Category> avaliableCategories() {
		List<Category> avaliableCategories = new ArrayList<Category>();
		avaliableCategories.add(new Car());
		avaliableCategories.add(new Scooter());
		return avaliableCategories;
	}   
    
}
