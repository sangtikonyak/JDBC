package com.example;

public class SalesPerson {
 private  int salesId;
 private String personName;
 private String city;
 private float rate;

 public SalesPerson() {

 }

    public SalesPerson(int salesId, String personName, String city, float rate) {
        this.salesId = salesId;
        this.personName = personName;
        this.city = city;
        this.rate = rate;
    }

    public int getSalesId() {
        return salesId;
    }

    public void setSalesId(int salesId) {
        this.salesId = salesId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "SalesPerson{" +
                "salesId=" + salesId +
                ", personName='" + personName + '\'' +
                ", city='" + city + '\'' +
                ", rate=" + rate +
                '}';
    }
}
