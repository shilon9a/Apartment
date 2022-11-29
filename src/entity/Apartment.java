package entity;

import java.math.BigDecimal;
import Exception.LengthException;

public class Apartment {
    private Integer id;
    private String apartmentName;
    private String location;
    private Integer roomNum;
    private Integer remainingRoom;
    private BigDecimal avgPrice;

    public Apartment() {
    }

    /**
     *
     * @param id
     * @param apartmentName
     * @param location
     * @param roomNum
     * @param remainingRoom
     * @param avgPrice
     */
    public Apartment(Integer id, String apartmentName, String location, Integer roomNum, Integer remainingRoom, BigDecimal avgPrice) {
        this.id = id;
        this.apartmentName = apartmentName;
        this.location = location;
        this.roomNum = roomNum;
        this.remainingRoom = remainingRoom;
        this.avgPrice = avgPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApartmentName() {
        return apartmentName;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getRemainingRoom() {
        return remainingRoom;
    }

    public void setRemainingRoom(Integer remainingRoom) {
        this.remainingRoom = remainingRoom;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice){
        this.avgPrice = avgPrice;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", apartmentName='" + apartmentName + '\'' +
                ", location='" + location + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", remainingRoom='" + remainingRoom + '\'' +
                ", avgPrice=" + avgPrice +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Apartment apartment=(Apartment)obj;
        if(id.equals(apartment.getId()) &&
        apartmentName.equals(apartment.getApartmentName()) &&
        location.equals(apartment.getLocation()) &&
        roomNum.equals(apartment.getRoomNum()) &&
        remainingRoom.equals(apartment.getRemainingRoom()) &&
        avgPrice.equals(apartment.getAvgPrice())){
            return true;
        }
        return false;
    }
}
