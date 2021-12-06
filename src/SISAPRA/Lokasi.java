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

    GD4, GD5, GD7;

    private String lable;

    Lokasi() {
    }

    public static String getVal(Lokasi lable) {
        if(Lokasi.GD4.equals(lable)) {
            return "Gedung 4";
        } else if(Lokasi.GD5.equals(lable)) {
            return "Gedung 4";
        } else if(Lokasi.GD7.equals(lable)) {
            return "Gedung 7";
        } else {
            return "_";
        }
    }

}
