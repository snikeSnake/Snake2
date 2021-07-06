package com.spiel;

public class Spieler {
    public static boolean deutsch= false;
    public static boolean wasd = true;
    public static String nickname = "Player";
    public static String farbe = "grün";

    public static void setNickname(String name){
        nickname = name;
    }
    public static boolean getSprache(){
        return deutsch;
    }
    public static boolean getSteuerung(){
        return wasd;
    }
    public static String getNickname(){
        return nickname;
    }
    public static void setSteuerung(boolean b){
        wasd=b;
    }
    public static void setSprache(boolean b){deutsch=b;}
    public static void setFarbe(String f){
        farbe=f;
    }
    public static String getFarbe(){return farbe;}
}
