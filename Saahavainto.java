package saahavaintoInsert.domain;




import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laura
 */
public class Saahavainto {
    private final int ID ;
    private final Calendar dateTime;
    private Place place;
    private User user;
    private double temperature;
    private int windSpeed;
    private Havainto havainto;
    
    public Saahavainto(int ID, Calendar dateTime,  Place place, double temperature, int windSpeed, Havainto havainto, User user) {
        this.ID = ID;
        this.dateTime = dateTime;
        this.place = place;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.havainto = havainto;
        this.user = user;
    }


    public int getID() {
        return ID;
    }

    public Calendar getDateTime() {
        return this.dateTime;
    }


    public Place getPlace() {
        return place;
    }

    public User getUser() {
        return user;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public Havainto getHavainto() {
        return havainto;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void settemperature(double temperature) {
        this.temperature = temperature;
    }

 
    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setHavainnot(Havainto havainto) {
        this.havainto = havainto;
    }
    
    public String formatDateTime(Calendar dateTime){  //printtaa pvm+aika halutussa muodossa
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTimeString = dateFormat.format(this.dateTime.getTime());
        return dateTimeString;
    }
    
    
       @Override
    public String toString() {
        return "Säähavainto: " + "ID:" + ID + ", Time:" + formatDateTime(dateTime) + ", Place:" + place.getPlaceAsString() + ", User:" + user + ", Temperature:" + temperature + ", Windpeed:" + windSpeed + ", Havainto:" + havainto.getHavaintoAsString() + "\n";
    }

    
    
  





}
