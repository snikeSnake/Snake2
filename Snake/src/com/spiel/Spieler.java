package com.spiel;
//speicher alle Einstellungen
public class Spieler {

    //setzt die Standarteinstellungen
    public static boolean deutsch= false;
    public static boolean wasd = true;
    public static String nickname = "Player";
    public static String farbe = "grün";

   //verändert die Einstellung
    public static void setNickname(String name){
        nickname = name;
    }
    public static void setSteuerung(boolean b){
        wasd=b;
    }
    public static void setSprache(boolean b){deutsch=b;}
    public static void setFarbe(String f){
        farbe=f;
    }

    //ruft die Werte der Einstellung auf
    public static String getFarbe(){return farbe;}
    public static String getNickname(){
        return nickname;
    }
    public static boolean getSprache(){
        return deutsch;
    }
    public static boolean getSteuerung(){
        return wasd;
    }
}
