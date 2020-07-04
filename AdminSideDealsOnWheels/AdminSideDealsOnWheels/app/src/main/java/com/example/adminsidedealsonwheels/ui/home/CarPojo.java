package com.example.adminsidedealsonwheels.ui.home;


public class CarPojo {
    String carName, id, companyName, pricePerKm, mileage, fuelType,
            carModel, carType, carImgMetaData, insuraceImgMetaDta,
            rcBookMetaData, pucMetaData, seater, cityforCar, availbility,
            status, personId, ownerName, ownerContactNumber;

    CarPojo() {
    }

    public CarPojo(String carName, String id, String companyName, String pricePerKm, String mileage,
                        String fuelType, String carModel, String carType,String carImgMetaData, String insuraceImgMetaDta,
                        String rcBookMetaData,String pucMetaData, String seater, String cityforCar, String availbility,
                        String status, String personId, String ownerName, String ownerContactNumber)
    {
        this.carName = carName;
        this.id = id;
        this.companyName = companyName;
        this.pricePerKm = pricePerKm;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.carModel = carModel;
        this.carType = carType;
        this.carImgMetaData = carImgMetaData;
        this.insuraceImgMetaDta = insuraceImgMetaDta;
        this.rcBookMetaData = rcBookMetaData;
        this.pucMetaData = pucMetaData;
        this.seater = seater;
        this.cityforCar = cityforCar;
        this.availbility = availbility;
        this.status = status;
        this.personId = personId;
        this.ownerName = ownerName;
        this.ownerContactNumber = ownerContactNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPricePerKm() {
        return pricePerKm;
    }

    public void setPricePerKm(String pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarImgMetaData() {
        return carImgMetaData;
    }

    public void setCarImgMetaData(String carImgMetaData) {
        this.carImgMetaData = carImgMetaData;
    }

    public String getInsuraceImgMetaDta() {
        return insuraceImgMetaDta;
    }

    public void setInsuraceImgMetaDta(String insuraceImgMetaDta) {
        this.insuraceImgMetaDta = insuraceImgMetaDta;
    }

    public String getRcBookMetaData() {
        return rcBookMetaData;
    }

    public void setRcBookMetaData(String rcBookMetaData) {
        this.rcBookMetaData = rcBookMetaData;
    }

    public String getPucMetaData() {
        return pucMetaData;
    }

    public void setPucMetaData(String pucMetaData) {
        this.pucMetaData = pucMetaData;
    }

    public String getSeater() {
        return seater;
    }

    public void setSeater(String seater) {
        this.seater = seater;
    }

    public String getCityforCar() {
        return cityforCar;
    }

    public void setCityforCar(String cityforCar) {
        this.cityforCar = cityforCar;
    }

    public String getAvailbility() {
        return availbility;
    }

    public void setAvailbility(String availbility) {
        this.availbility = availbility;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(String ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }
}