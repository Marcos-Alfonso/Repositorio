/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04;

/**
 *
 * @author santiago
 */
public class TPV {

    final int TIEMPO_PAGAR = 4000;

    private Cajera tieneTPV = null;
   
    public void usa(Cajera cajera) {
        tieneTPV = cajera;
        System.out.println("\n --- [[[ COJE ]]] el TPV " + tieneTPV.getNombre());
        System.out.println("\n --- Pagando en TPV ... " + tieneTPV.getNombre());
        try {
            Thread.sleep(TIEMPO_PAGAR);
        }
        catch(InterruptedException ex) {
            return;
        }
        System.out.println("\n --- Suelta el TPV " + tieneTPV.getNombre());
        tieneTPV = null;
    }

}
