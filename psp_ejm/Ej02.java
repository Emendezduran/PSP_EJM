/*
Programa que crea 4 fíos, os executa e espera a que estes terminen. Os fíos escriben 5 veces o
número de iteración do bucle e o seu nome. En cada iteración, despois de escribir o seu nome,
bloquéanse durante un segundo e volven a estar dispoñibles para a súa execución.
 */
package psp_ejm;

import java.util.Random;

/**
 *
 * @author DANIELCASTELAO\emendezduran
 */
public class Ej02 extends Thread {

    private String nombre;

    public Ej02(String nombre) {
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

        Ej02 hilo1 = new Ej02("Uno");
        Ej02 hilo2 = new Ej02("Dos");
        Ej02 hilo3 = new Ej02("Tres");
        Ej02 hilo4 = new Ej02("Cuatro");
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
