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

public enum Prodi {

    D4TRPL,D3TI, D3TK;

    private String lable;

    Prodi() {
    }

    public static String getVal(Prodi lable) {
        if(Prodi.D4TRPL.equals(lable)) {
            return "D4 Teknologi Rekayasa Perangkat Lunak";
        } else if(Prodi.D3TI.equals(lable)) {
            return "D3 Teknologi Informasi";
        } else if(Prodi.D3TK.equals(lable)) {
            return "D3 Teknologi Komputer";
        } else {
            return "_";
        }
    }

}
