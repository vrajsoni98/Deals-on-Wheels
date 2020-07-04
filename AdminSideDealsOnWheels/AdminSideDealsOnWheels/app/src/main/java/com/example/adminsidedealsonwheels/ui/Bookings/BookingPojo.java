package com.example.adminsidedealsonwheels.ui.Bookings;

public class BookingPojo {
    String carName, fuel, metaData, pricePerKm, seater, ownerName,
            ownerCtNum, status_Car, car_Model, distance, toDate,
            fromDate, cityFrom, cityTo, uidOwner, idCar, clientPersonId,reqCode,bookinId,mainTotal;

   public BookingPojo()
   {}

    public BookingPojo(String carName, String fuel, String metaData, String pricePerKm,
                       String seater, String ownerName, String ownerCtNum, String status_Car,
                       String car_Model, String distance, String toDate, String fromDate,
                       String cityFrom, String cityTo, String uidOwner, String idCar,
                       String clientPersonId, String reqCode, String bookinId, String mainTotal)
    {
        this.carName = carName;
        this.fuel = fuel;
        this.metaData = metaData;
        this.pricePerKm = pricePerKm;
        this.seater = seater;
        this.ownerName = ownerName;
        this.ownerCtNum = ownerCtNum;
        this.status_Car = status_Car;
        this.car_Model = car_Model;
        this.distance = distance;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.cityFrom = cityFrom;
        this.cityTo = cityTo;
        this.uidOwner = uidOwner;
        this.idCar = idCar;
        this.clientPersonId = clientPersonId;
        this.reqCode = reqCode;
        this.bookinId = bookinId;
        this.mainTotal = mainTotal;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(String pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public String getSeater() {
        return seater;
    }

    public void setSeater(String seater) {
        this.seater = seater;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerCtNum() {
        return ownerCtNum;
    }

    public void setOwnerCtNum(String ownerCtNum) {
        this.ownerCtNum = ownerCtNum;
    }

    public String getStatus_Car() {
        return status_Car;
    }

    public void setStatus_Car(String status_Car) {
        this.status_Car = status_Car;
    }

    public String getCar_Model() {
        return car_Model;
    }

    public void setCar_Model(String car_Model) {
        this.car_Model = car_Model;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public String getUidOwner() {
        return uidOwner;
    }

    public void setUidOwner(String uidOwner) {
        this.uidOwner = uidOwner;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getClientPersonId() {
        return clientPersonId;
    }

    public void setClientPersonId(String clientPersonId) {
        this.clientPersonId = clientPersonId;
    }

    public String getReqCode() {
        return reqCode;
    }

    public void setReqCode(String reqCode) {
        this.reqCode = reqCode;
    }

    public String getBookinId() {
        return bookinId;
    }

    public void setBookinId(String bookinId) {
        this.bookinId = bookinId;
    }

    public String getMainTotal() {
        return mainTotal;
    }

    public void setMainTotal(String mainTotal) {
        this.mainTotal = mainTotal;
    }


}