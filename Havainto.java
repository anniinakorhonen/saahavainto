package saahavaintoInsert.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laura
 */
    public enum Havainto
    {
        AURINKOISTA("Aurinkoista"), SELKEÄÄ_JA_POUTAA("Selkeää ja poutaa"), PUOLIPILVISTA("Puolipilvistä"), PILVISTA("Pilvistä"), VAHAISTA_SADETTA("Vähäistä sadetta"),
        RUNSASTA_SADETTA("Runsasta sadetta"), SADEKUUROJA("Sadekuuroja"), MYRSKY("Myrsky"), SUMUA("Sumua"), VAHAISTA_LUMISADETTA("Vähäistä lumisadetta"), RUNSASTA_LUMISADETTA("Lumisadetta");
    
    
    private String havaintoAsString;
    
    public String getHavaintoAsString(){
        return havaintoAsString;
    }
    
    private Havainto(String havaintoString) {
        this.havaintoAsString = havaintoString;
    }
    
}
