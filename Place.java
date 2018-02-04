/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saahavaintoInsert.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public enum Place
    {
        HELSINKI("Helsinki"), TAMPERE("Tampere"), LAHTI("Lahti"), LAPPEENRANTA("Lappeenranta"),
        TURKU("Turku"), VAASA("Vaasa");
    
    
    private String placeAsString;
    
    public String getPlaceAsString(){
        return placeAsString;
    }
    
    private Place(String placeAsString) {
        this.placeAsString = placeAsString;
    }
    
}
