/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SISAPRA;

/**
 *
 * @author LENOVO
 */
public enum Lokasi {

    GD411, GD412, GD421, GD422, GD511,
    GD512, GD521,  GD522, GD711, GD712, GD721, GD722;

    private String lable;

    Lokasi() {
    }

    public static String getVal(Lokasi lable) {
        if(Lokasi.GD411.equals(lable)) {
            return "Gedung 411";
        } else if(Lokasi.GD412.equals(lable)) {
            return "Gedung 412";
        } else if(Lokasi.GD421.equals(lable)) {
            return "Gedung 421";
        } else if(Lokasi.GD422.equals(lable)) {
            return "Gedung 422";
        } else if(Lokasi.GD511.equals(lable)) {
            return "Gedung 511";
        } else if(Lokasi.GD512.equals(lable)) {
            return "Gedung 512";
        } else if(Lokasi.GD521.equals(lable)) {
            return "Gedung 521";
        } else if(Lokasi.GD522.equals(lable)) {
            return "Gedung 522";
        } else if(Lokasi.GD711.equals(lable)) {
            return "Gedung 711";
        } else if(Lokasi.GD712.equals(lable)) {
            return "Gedung 712";
        } else if(Lokasi.GD721.equals(lable)) {
            return "Gedung 721";
        } else if(Lokasi.GD722.equals(lable)) {
            return "Gedung 722";
        } else {
            return "_";
        }
    }

}
