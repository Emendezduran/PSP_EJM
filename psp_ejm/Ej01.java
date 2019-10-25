/*
Programa en Java que cree dous fíos e os executa. Os fíos escriben dez veces un número de
iteración do bucle e seu nome. En cada iteración, despois de escribir o seu nome, se bloquean
durante un tempo aleatorio de segundos e después volven a estar dispoñibles para a súa
execución.
 */
package psp_ejm;

import java.util.Random;

/**
 *
 * @author DANIELCASTELAO\emendezduran
 */
public class Ej01 extends Thread {
    
    private String nombre;
    
    public Ej01(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void run() {
        System.out.println("Hilo: " + nombre + " Start!");
        for (int i = 0; i < 10; i++) {
            int retraso = new Random().nextInt(2000) + 1001;
            System.out.println("Numero de Iteracion: " + i + " Nombre: " + nombre);
            try {
                Thread.sleep(retraso);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Hilo: " + nombre + " Fin!");
    }
    
    public static void main(String[] args) {
        
        Ej01 hilo1 = new Ej01("Uno");
        Ej01 hilo2 = new Ej01("Dos");
        Ej01 hilo3 = new Ej01("Tres");
        Ej01 hilo4 = new Ej01("Cuatro");
        
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
}
