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
public enum Prodi
{
    D4TRPL,D3TI,D3TK;
   public String toString(){
        switch(this){
            case D4TRPL:
                return "D4TRPL";
            case D3TI:
                return "D3TI";
            case D3TK:
                return "D3TK";
 
   
}
        return null;
   }
}
