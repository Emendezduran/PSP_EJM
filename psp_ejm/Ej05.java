/*
Escribe unha clase que cree dous fíos e force que a escritura do segundo sexa sempre anterior á
escritura por pantalla do primeiro.
 Exemplo de ejecución:
 Ola, son o fío número 2
 Ola, son o fío número 1
a) faino con join
b )faino con prioridades NO HACER
 */
package psp_ejm;

/**
 *
 * @author DANIELCASTELAO\emendezduran
 */
public class Ej05 extends Thread {
    
    String nombre;
    Thread hijo;

    public Ej05(String nombre) {
        this.nombre = nombre;
    }

    public Ej05(String nombre, Thread hijo) {
        this.nombre = nombre;
        this.hijo = hijo;
    }

    @Override
    public void run() {
        if (hijo != null) {
            try {
                hijo.join();//esperamos al hijo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ola, son o fío: " + nombre);
    }
    
    public static void main(String[] args) {
        
        Ej05 hilo1 = new Ej05(" Dos");
        Ej05 hilo2 = new Ej05(" Uno", hilo1);
        
        hilo1.start();
        hilo2.start();
    }

}
