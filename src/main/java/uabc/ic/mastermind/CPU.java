package uabc.ic.MasterMind;

import java.util.ArrayList;

public class CPU {
    private ClaveOculta claveOculta;
    private ArrayList<Integer> clave;
    private ArrayList<Integer> aciertos;
    
    public CPU(){
    
    claveOculta = new ClaveOculta();
    claveOculta.setClaveOculta();
    clave = new ArrayList<Integer>();
    clave = claveOculta.obtClave();
    aciertos = new ArrayList<Integer>();        
    
    }
    
    public void compararClave(ArrayList<Integer> claveAComparar) {

        aciertos = new ArrayList<Integer>();
        int contPOSYCOL = 0;
        int contCOL = 0;

        ArrayList<Integer> copiaClave = new ArrayList<>(clave);
        ArrayList<Integer> copiaIntento = new ArrayList<>(claveAComparar);

        for (int i = 0; i < copiaClave.size(); i++) {
            if (copiaClave.get(i).equals(copiaIntento.get(i))) {
                contPOSYCOL++;

                copiaClave.set(i, -1);
                copiaIntento.set(i, -1);
            }
        }

        for (int i = 0; i < copiaClave.size(); i++) {
            int colorClave = copiaClave.get(i);
            if (colorClave != -1) {
                for (int j = 0; j < copiaIntento.size(); j++) {
                    int colorIntento = copiaIntento.get(j);
                    if (colorClave == colorIntento) {
                        contCOL++;
                        copiaClave.set(i, -1);
                        copiaIntento.set(j, -1);
                        break;
                    }
                }
            }
        }
        aciertos.add(0, contPOSYCOL);
        aciertos.add(1, contCOL);
    }
    
    public ArrayList<Integer> obtAciertos(){
        return aciertos;
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
        
}
