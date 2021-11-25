/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author LENOVO
 */
public enum Lokasi {

    GD4, GD5, GD7;

    public String toString() {
        switch (this) {
            case GD4:
                return "Gedung 4";
            case GD5:
                return "Gedung 5";
            case GD7:
                return "Gedung 7";
        }

        return null;
    }
}
    




    
    
