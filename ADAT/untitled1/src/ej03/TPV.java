/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03;

/**
 *
 * @author santiago
 */
public class TPV {

    final int TIEMPO_PAGAR = 4000;

    private Cajera tieneTPV = null;

    public void coje(Cajera cajera) {
        tieneTPV = cajera;
        System.out.println("\n --- Coje el TPV " + tieneTPV.getNombre());
    }

    public void suelta() {
        System.out.println("\n --- Suelta el TPV " + tieneTPV.getNombre());
        tieneTPV = null;
    }

    public void paga() throws InterruptedException {
        System.out.println("\n --- Pagando en TPV ... " + tieneTPV.getNombre());
        Thread.sleep(TIEMPO_PAGAR);
    }

    public void verificaQueTengoTPV(Cajera cajera) {
        if (tieneTPV != cajera) {
            System.out.println("\n ***** OOOOOJJJJJOOOOO *****.\nMe han quitadoe el TPV\n"
                    + tieneTPV.getNombre() + " quito a " + cajera.getNombre());
        }
    }
    
    
    public void usa(Cajera cajera) {
        tieneTPV = cajera;
        System.out.println("\n --- Coje el TPV " + tieneTPV.getNombre());
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
