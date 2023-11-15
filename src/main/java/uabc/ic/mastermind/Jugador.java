package uabc.ic.MasterMind;

import java.util.ArrayList;


public class Jugador {
    private ClavePlayer clavePrueba;
    private Integer intentos;
    private ArrayList<Integer> claveIntento;
    
    
    public Jugador(){
        clavePrueba = new ClavePlayer();
        intentos = 15;
        claveIntento = new ArrayList();
    }
    
    public void hacerIntento(){
        claveIntento.clear();
        if(intentos>=1){
            clavePrueba.setClave();
            intentos -= 1;
            claveIntento = clavePrueba.obtClave();
        }else{
            System.out.println("Te quedaste sin intentos");
        }
    }
    
    public int intentosRestantes(){
        return intentos;
    }
    
    public ArrayList<Integer> obtIntento() {
        return claveIntento;
    }
    
    public void mostrarClave(){
        System.out.print("La clave es: ");
        for (int i = 0; i < claveIntento.size(); i++) {
            System.out.print(claveIntento.get(i));
        }
        System.out.println();
    }
}
