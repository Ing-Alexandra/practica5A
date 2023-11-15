package uabc.ic.MasterMind;

import java.util.ArrayList;
import java.util.Random;

public class ClaveOculta {
    private ArrayList<Integer> claveOculta;
    
    public ClaveOculta(){
        claveOculta = new ArrayList<Integer>();
    }
    
    public void setClaveOculta(){
        Random rm = new Random();
        int num;
        for(int i=1;i<=6;i++){
            num = rm.nextInt(6) + 1;
            claveOculta.add(num);
        }
    }
    
    public void mostrarClaveEscondida(){
        System.out.print("La clave es: ");
        for (int i = 0; i < claveOculta.size(); i++) {
            System.out.print(claveOculta.get(i));
        }
        System.out.println();
    }
    
    public void borrarClaveOculta(){
        claveOculta.clear();
    }
    
    public ArrayList<Integer> obtClave() {
        return claveOculta;
    }
}
