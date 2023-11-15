package uabc.ic.MasterMind;

import java.util.ArrayList;
import java.util.Scanner;


public class ClavePlayer {
    private ArrayList<Integer> clave;
    
    public ClavePlayer(){
        clave = new ArrayList<Integer>();
    }
    
    public void setClave(){
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 6; i++) {
            int num;
            boolean validInput = false;

            while (!validInput) {
                System.out.print("Introduce el numero del color (" + i + "): ");
                num = sc.nextInt();

                if (num >= 1 && num <= 8) {
                    clave.add(num);
                    validInput = true;
                } else {
                    System.out.println("Ingresa un número válido entre 1 y 8.");
                }
            }
        }
    }
    
    public ArrayList<Integer> obtClave() {
        return clave;
    }
    
    public void mostrarClave(){
        System.out.print("La clave es: ");
        for (int i = 0; i < clave.size(); i++) {
            System.out.print(clave.get(i));
        }
        System.out.println();
    }
    
    public void borrarClave(){
        clave.clear();
    }
}
