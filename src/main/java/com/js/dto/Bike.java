package com.js.dto;

public class Bike {
	private int bike_id;
	private String bike_name;
	private double price;
	private double mileage;
	public int getBike_id() {
		return bike_id;
	}
	public void setBike_id(int bike_id) {
		this.bike_id = bike_id;
	}
	public String getBike_name() {
		return bike_name;
	}
	public void setBike_name(String bike_name) {
		this.bike_name = bike_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double d) {
		this.mileage = d;
	}
	@Override
	public String toString() {
		return "Bike [bike_id=" + bike_id + ", bike_name=" + bike_name + ", price=" + price + ", mileage=" + mileage
				+ ", getBike_id()=" + getBike_id() + ", getBike_name()=" + getBike_name() + ", getPrice()=" + getPrice()
				+ ", getMileage()=" + getMileage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
