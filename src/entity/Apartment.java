package entity;

import java.math.BigDecimal;
import Exception.LengthException;
import Exception.NegativeException;
import Exception.NullException;
import Exception.CompareException;

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

    public void setApartmentName(String apartmentName) throws NullException{
        if(apartmentName.trim().length()==0){
            throw new NullException("公寓名称非空");
        }
        this.apartmentName = apartmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) throws NullException{
        if(location.trim().length()==0){
            throw new NullException("地理位置非空");
        }
        this.location = location;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum)throws NegativeException {
        if(roomNum<0){
            throw new NegativeException("房间数应大于等于0");
        }
        this.roomNum = roomNum;
    }

    public Integer getRemainingRoom() {
        return remainingRoom;
    }

    public void setRemainingRoom(Integer remainingRoom)throws NegativeException {
        if(remainingRoom<0){
            throw new NegativeException("剩余房间数应大于等于0");
        }
        if(remainingRoom>roomNum){
            throw new CompareException("剩余房间数应小于总房间数");
        }
        this.remainingRoom = remainingRoom;
    }

    public BigDecimal getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(BigDecimal avgPrice)throws NegativeException,LengthException{
        int res=avgPrice.compareTo(BigDecimal.ZERO);
        if(res==-1){
            throw new NegativeException("价格应大于等于0");
        }
        String[] temp=avgPrice.toString().split("\\.");
        if(temp[0].length()>10){
            throw new LengthException("价格应低于10位数");
        }
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
