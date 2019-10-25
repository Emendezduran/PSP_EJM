/*
Realiza un programa en java que execute tres fíos de forma concurrente. Un de eles debe sumar os
números pares del 1 ao 1000, outro os impares, e outro, os que terminen en dous ou en tres
 */
package psp_ejm;

/**
 *
 * @author DANIELCASTELAO\emendezduran
 */
public class Ej04 extends Thread{
    
    /*
    s = 0 -> suma de pares
    s = 1 -> suma de impares
    s = 2 -> suma de los que terminen en 2 o 3
    */
    private int select = 0;
    
    public Ej04(int select){
        this.select = select;
    }

    @Override
    public void run() {
        int suma = 0;
        switch (select) {
            case 0:
                for (int i = 1; i < 1000; i++) {
                    if (i % 2 == 0) {
                        suma += i;
                    }
                }
                break;

            case 1:
                for (int i = 1; i < 1000; i++) {
                    if (i % 2 != 0) {
                        suma += i;
                    }
                }
                break;
               

            case 2:
                for (int i = 1; i < 1000; i++) {
                    String parsed = Integer.toString(i);
                    if (parsed.endsWith("2") || parsed.endsWith("3")) {
                        suma += i;
                    }
                }
                break;
        }
        System.out.println("Opcion: " + select + " Suma: " + suma);
    
    }
    
    public static void main(String[] args) {
        
        Ej04 SumaPares = new Ej04(0);
        Ej04 SumaImpares = new Ej04(1);
        Ej04 Suma23 = new Ej04(2);
        
        SumaPares.start();
        SumaImpares.start();
        Suma23.start();
                
    }
    
}

