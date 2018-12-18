package egcom.hsk.dto;

public class StadiumDTO {
    public final long id;
    public final double latitude;
    public final double longitude;
    public final String city;
    public final String district;
    public final String address;

    public StadiumDTO(long id, double latitude, double longitude, String city, String district, String address) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.district = district;
        this.address = address;
    }
}
