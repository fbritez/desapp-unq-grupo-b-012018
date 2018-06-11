package model.maps;

import model.utils.Entity;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

public class GeographicZoneDescription extends Entity {

	private Double latitud;
	private Double longitud;

	public GeographicZoneDescription(Double aLatitud, Double aLongitud) {
		latitud = aLatitud;
		longitud = aLongitud;
	}

	public GeographicZoneDescription() {
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Boolean equalsTo(GeographicZoneDescription geographicZoneDescription) {
		return (geographicZoneDescription.getLatitud().doubleValue() == this.getLatitud().doubleValue()
				&& geographicZoneDescription.getLongitud().doubleValue() == this.getLongitud().doubleValue());

	}

	private String getAddressByGpsCoordinates(String lng, String lat) {
	    Geocoder geocoder = new Geocoder();
	    LatLng location = new LatLng(lat,  lng);
	    String addressResult = "unknown address";
	    
	 
       GeocoderRequest request = new GeocoderRequest();
	        request.setLocation(location);

	        GeocodeResponse response = geocoder.geocode(request);
	        if (response.getStatus() == GeocoderStatus.OK) {
	           addressResult = response.getResults().get(0).getFormattedAddress();
	        }
	    return addressResult;
	}

}
