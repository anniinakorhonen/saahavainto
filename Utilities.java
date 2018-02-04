/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saahavaintoInsert.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Laura
 */
public final class Utilities {
    
    public static Calendar getRandomDateTime() {  //arvo päivämäärä
        
        Random rand = new Random();
        
        int year = 2014+ rand.nextInt(3);  //arvotaan vuosi 2015-2018
        
        int month = rand.nextInt(12)+1;
        int day = 1;
        
        if(month == 2 && !isLeapYear(year)) { // jos ei karkausvuosi
            day = rand.nextInt(28)+1; 
        } else if(month == 2 && isLeapYear(year)) { //jos karkausvuosi
            day = rand.nextInt(29)+1;
        }else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = rand.nextInt(31)+1;
        }else if(month == 4 || month == 6 || month == 9 || month == 12 ) {
            day = rand.nextInt(30)+1;
        }
        
        int hour = rand.nextInt(24)+1;
        int minute = rand.nextInt(60)+1;
        int second = rand.nextInt(60)+1;
        
        Calendar newDateTime = new GregorianCalendar(year, month, day, hour, minute, second);
        return newDateTime;
         
    }
    
    public static Place getRandomPlace(){
        
        Random rand = new Random();
        List<Place> allPlaces = new ArrayList<Place>(Arrays.asList(Place.values()));
        
        int randomInt = rand.nextInt(allPlaces.size());
        
        Place randomPlace = allPlaces.get(randomInt);
        return randomPlace;
    }
    
    
    private static boolean isLeapYear(int year) {
        
        if (year % 400 == 0) {
        return true;
        }
        else if(year % 4 == 0 && !(year % 100 == 0)) {
        return true;
        } else {
        return false;
        }
    }
    
    public static double getRandomTemperature(Calendar dateTime) {  //arvotaan lämpötila vuodenajan kellonajan mukaan
        
        Random rand = new Random();
        double temperature = 0;
        
        if(dateTime.get(Calendar.MONTH) == 12 || dateTime.get(Calendar.MONTH) < 3){  //talvi
            if(dateTime.get(Calendar.HOUR_OF_DAY) < 10 || dateTime.get(Calendar.HOUR_OF_DAY) > 21) { //yö vai päivä
                temperature = -16 + rand.nextInt(17)+1; 
            } else {
                temperature =  -13 + rand.nextInt(16)+1;  
            }    
        }else if(dateTime.get(Calendar.MONTH) == 3 || dateTime.get(Calendar.MONTH) == 4 || dateTime.get(Calendar.MONTH) == 10 || dateTime.get(Calendar.MONTH) == 11 ){ //loppusyksy/alkukevät
            if(dateTime.get(Calendar.HOUR_OF_DAY) < 10 || dateTime.get(Calendar.HOUR_OF_DAY) > 21) {
                temperature = -6 + rand.nextInt(9)+1; 
            } else {
                temperature = -1 + rand.nextInt(11)+1; 
            }
        }else if(dateTime.get(Calendar.MONTH) == 5 || dateTime.get(Calendar.MONTH) == 9 ){  //loppukevät/alkusyky
            if(dateTime.get(Calendar.HOUR_OF_DAY) < 10 || dateTime.get(Calendar.HOUR_OF_DAY) > 21) {
                temperature = 2 + rand.nextInt(7)+1;
            } else {
                temperature =  7+ rand.nextInt(10)+1; 
            }
               }else if(dateTime.get(Calendar.MONTH) > 5 || dateTime.get(Calendar.MONTH) < 9 ){
            if(dateTime.get(Calendar.HOUR_OF_DAY) < 10 || dateTime.get(Calendar.HOUR_OF_DAY) > 21) {
                temperature = 6 + rand.nextInt(8) + 1; 
            } else {
                temperature = 13 + rand.nextInt(16)+1; 
            }      
        }
    
        return temperature;
    }
    
    public static int getRandomWindspeed() {  //arvotaan tuulen nopeus tilastollisiin tuulipäiviin perustuen
        
        Random rand = new Random();
        
        int randomInt = rand.nextInt(365)+1;
        int tuulenNopeus;
        
        if(randomInt < 15) {
            tuulenNopeus = 21+ rand.nextInt(4) + 1; 
        } else if(randomInt > 15 && randomInt < 50) {
            tuulenNopeus = 14 + rand.nextInt(6) + 1; 
        } else if(randomInt > 50 && randomInt < 150) {
            tuulenNopeus = 10+ rand.nextInt(3) + 1; 
        } else {
            tuulenNopeus = rand.nextInt(9) +1; 
        }
        
        return tuulenNopeus;
    }
    
    public static Havainto getRandomHavainto(Calendar dateTime, double temperature, int windSpeed) { //valitsee keskim. tilastoihin perustuen sään
        
        Havainto havainto = Havainto.PILVISTA;
        Random rand = new Random();
        
        int randomInt = rand.nextInt(365)+1;
        
        if(windSpeed > 20) {   //jos tuuli yli 20=myrsky
            havainto = Havainto.MYRSKY;
            return havainto;
        }else if(temperature > 23) {  //helteellä usein selkeää
            havainto = Havainto.AURINKOISTA;
            return havainto;
        } else if(temperature < -12 && dateTime.get(Calendar.HOUR_OF_DAY) < 10 || dateTime.get(Calendar.HOUR_OF_DAY) > 21) {//kovalla pakkasella usein selkeää
            havainto = Havainto.AURINKOISTA;
        } else if (randomInt < 180) //Suomessa sataa n. 180 päivää vuodessa
            if(randomInt < 70) {
                if(temperature >= 0) {
                    havainto = Havainto.VAHAISTA_SADETTA;  //talvi->lumi, kesä->vesisade, lämpötilasta riippuen
                } else {
                    havainto = Havainto.VAHAISTA_LUMISADETTA;
                }
            }else if (randomInt > 69 && randomInt < 100) {
                if(temperature >= 0) {
                    havainto = Havainto.SADEKUUROJA;
                } else {
                    havainto = Havainto.VAHAISTA_LUMISADETTA;
                }
            } else if(randomInt > 99 && randomInt < 180) {
                if(temperature >= 0) {
                    havainto = Havainto.RUNSASTA_SADETTA;
                } else {
                    havainto = Havainto.RUNSASTA_LUMISADETTA;
                }
            } else if(randomInt > 179 && randomInt < 260) {
                havainto = Havainto.PUOLIPILVISTA;
            } else if(randomInt > 259 && randomInt < 300) {
                if(dateTime.get(Calendar.MONTH) > 3 || dateTime.get(Calendar.MONTH) < 10 ){ //kesä
                    if(dateTime.get(Calendar.HOUR_OF_DAY) < 8 || dateTime.get(Calendar.HOUR_OF_DAY) > 20) {
                        havainto = Havainto.SELKEÄÄ_JA_POUTAA;
                    } else {
                        havainto = Havainto.AURINKOISTA;
                    } 
                }else if(dateTime.get(Calendar.MONTH) > 9 || dateTime.get(Calendar.MONTH) <  4 ){ //talvi
                    if(dateTime.get(Calendar.HOUR_OF_DAY) < 10 || dateTime.get(Calendar.HOUR_OF_DAY) > 17) {
                        havainto = Havainto.SELKEÄÄ_JA_POUTAA;
                    } else {
                        havainto = Havainto.AURINKOISTA;
                    }
                }
            } else if(randomInt > 299 && randomInt < 310 && temperature > 0) {
                havainto = Havainto.SUMUA;
            }
        
        return havainto;
    }
}
