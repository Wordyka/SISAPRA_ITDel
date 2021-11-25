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
public enum Jenis_Kelamin
{
    MALE,FAMELE;
   public String toString(){
        switch(this){
            case MALE:
                return "Laki - Laki";
            case FAMELE:
                return "Perempuan";
 
   
}
        return null;
   }
}
