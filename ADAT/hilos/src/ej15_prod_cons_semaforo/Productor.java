/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej15_prod_cons_semaforo;

public class Productor extends Thread {

    private final String id;
    private final Almacen buffer;
    private final Secuenciador secuenciador = new Secuenciador();

    public Productor(String id, Almacen buffer) {
        super(id);
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                /**
                 * Lanzamos la operación signal() del semaforo después de
                 * introducir datos en el buffer . Debemos sincronizar el acceso
                 * al buffer debido a que nada nos garantiza que no haya
                 * conflictos con otros hilos
                 *
                 * El semaforo, tal como está, no evitará que produzcamos más de
                 * la cuenta
                 */
                Thread.sleep(Main.DEMORA_PRODUCTOR);
                int item = secuenciador.siguiente();
                System.out.print(" +++ " + id + "=>");
                buffer.guarda(item);
                System.out.print("\t[" + item + "]");
                System.out.println("\t+Tam:" + buffer.size());

            } catch (InterruptedException ex) {
                System.out.println("\n**** Excepcion PRODUCTOR **** ");
                ex.printStackTrace();
                break;
            }
        }
    }
}
