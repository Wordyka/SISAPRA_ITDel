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
public enum Jenis_Kelamin {

    L, P;

    private String lable;

    Jenis_Kelamin() {
    }

    public static String getVal(Jenis_Kelamin lable) {
        if(Jenis_Kelamin.L.equals(lable)) {
            return "Laki - Laki";
        } else if(Jenis_Kelamin.P.equals(lable)) {
            return "Perempuan";
        } else {
            return "_";
        }
    }

}
