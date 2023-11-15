package uabc.ic.MasterMind;

import java.awt.Color;
import java.util.ArrayList;

public class MasterMind {
    private int ejeX;
    private int ejeY;
    private int ground;
    private Jugador player1;
    private ArrayList<Integer> intento;
    private CPU consola;
    private Canvas canvas;
    private boolean versionPrueba;
    private boolean combinacionGanadoraMostrada = false;
    

    public MasterMind() {
        this(false);
    }

    public MasterMind(boolean versionPrueba) {
        this.versionPrueba = versionPrueba;
        intento = new ArrayList<Integer>();
        player1 = new Jugador();
        consola = new CPU();
        canvas = new Canvas("MasterMind", 300, 600);
        ejeX = 0;
        ejeY = 528;
        ground = 520;

        if (versionPrueba) {
            mostrarClaveSecreta();
        }
    }

    public void jugar() {
        tablero();
        int intentosRestantes = 15;

        for (int i = 1; i <= 15; i++) {
            intentoClave();
            darFeedBack();
            ArrayList<Integer> aciertos = consola.obtAciertos();

            if (aciertos.get(0) == 6) {
                if (!combinacionGanadoraMostrada) {
                    mostrarCombinacionGanadora();
                    combinacionGanadoraMostrada = true;
                }
                System.out.println("¡Felicidades, has ganado!");
                break;
            } else {
                intentosRestantes--;
                System.out.println("Te quedan " + intentosRestantes + " intentos.");
                if (intentosRestantes == 0) {
                    System.out.println("GAME OVER, sigue intentando.");
                    break;
                }
            }
        }
    }

 public void tablero() {
        canvas.setVisible(true);
        canvas.setForegroundColor(new Color(179, 229, 252)); 
        canvas.drawLine(1, ground, 300, ground);
        canvas.drawLine(210, -1000, 210, 800);

        int ballOffsetX = -42; 

        BouncingBall bola1 = new BouncingBall(95 + ballOffsetX, 552, 20, new Color(248, 187, 208), ground, canvas); // Rosa
        BouncingBall bola2 = new BouncingBall(120 + ballOffsetX, 552, 20, new Color(255, 204, 188), ground, canvas); // Naranja
        BouncingBall bola3 = new BouncingBall(145 + ballOffsetX, 552, 20, new Color(207, 216, 220), ground, canvas); // Gris
        BouncingBall bola4 = new BouncingBall(170 + ballOffsetX, 552, 20, new Color(209, 196, 233), ground, canvas); // Magenta
        BouncingBall bola5 = new BouncingBall(95 + ballOffsetX, 530, 20, new Color(239, 154, 154), ground, canvas); // Roja
        BouncingBall bola6 = new BouncingBall(120 + ballOffsetX, 530, 20, new Color(178, 223, 219), ground, canvas); // Verde
        BouncingBall bola7 = new BouncingBall(145 + ballOffsetX, 530, 20, new Color(179, 229, 252), ground, canvas); // Azul
        BouncingBall bola8 = new BouncingBall(170 + ballOffsetX, 530, 20, new Color(255, 249, 196), ground, canvas); // Amarilla

        bola1.draw();
        bola2.draw();
        bola3.draw();
        bola4.draw();
        bola5.draw();
        bola6.draw();
        bola7.draw();
        bola8.draw();

        int labelOffsetX = -35; 
        int labelOffsetY = 15;

        canvas.setForegroundColor(Color.BLACK);
        canvas.drawString("5", 95 + labelOffsetX, 550 + labelOffsetY);
        canvas.drawString("6", 120 + labelOffsetX, 550 + labelOffsetY);
        canvas.drawString("7", 145 + labelOffsetX, 550 + labelOffsetY);
        canvas.drawString("8", 170 + labelOffsetX, 550 + labelOffsetY);
        canvas.drawString("1", 95 + labelOffsetX, 530 + labelOffsetY);
        canvas.drawString("2", 120 + labelOffsetX, 530 + labelOffsetY);
        canvas.drawString("3", 145 + labelOffsetX, 530 + labelOffsetY);
        canvas.drawString("4", 170 + labelOffsetX, 530 + labelOffsetY);
    }


    public void intentoClave() {
        ejeX = 0;
        ejeX += 20;
        ejeY -= 33;
        Color nuevoColor;
        player1.hacerIntento();
        intento = player1.obtIntento();

        BouncingBall bola1 = new BouncingBall(ejeX, ejeY, 20, Color.ORANGE, ground, canvas);
        BouncingBall bola2 = new BouncingBall(ejeX += 33, ejeY, 20, Color.ORANGE, ground, canvas);
        BouncingBall bola3 = new BouncingBall(ejeX += 33, ejeY, 20, Color.ORANGE, ground, canvas);
        BouncingBall bola4 = new BouncingBall(ejeX += 33, ejeY, 20, Color.ORANGE, ground, canvas);
        BouncingBall bola5 = new BouncingBall(ejeX += 33, ejeY, 20, Color.ORANGE, ground, canvas);
        BouncingBall bola6 = new BouncingBall(ejeX += 33, ejeY, 20, Color.ORANGE, ground, canvas);

        nuevoColor = getColorBola(intento.get(0));
        bola1.cambiarColor(nuevoColor);
        nuevoColor = getColorBola(intento.get(1));
        bola2.cambiarColor(nuevoColor);
        nuevoColor = getColorBola(intento.get(2));
        bola3.cambiarColor(nuevoColor);
        nuevoColor = getColorBola(intento.get(3));
        bola4.cambiarColor(nuevoColor);
        nuevoColor = getColorBola(intento.get(4));
        bola5.cambiarColor(nuevoColor);
        nuevoColor = getColorBola(intento.get(5));
        bola6.cambiarColor(nuevoColor);

        bola1.draw();
        bola2.draw();
        bola3.draw();
        bola4.draw();
        bola5.draw();
        bola6.draw();
    }

    public void darFeedBack() {
        ArrayList<Integer> aciertos;
        int ejeXTemp = ejeX + 18;

        consola.compararClave(intento);
        aciertos = consola.obtAciertos();

        int bolasBlancas = 6 - (aciertos.get(0) + aciertos.get(1));

        BouncingBall bolaF = new BouncingBall(ejeXTemp, ejeY, 10, Color.GRAY, ground, canvas);
        ejeX += 18;

        if (aciertos.get(0) > 0) {
            for (int i = 0; i < aciertos.get(0); i++) {
                bolaF.cambiarPosicion(ejeX += 13, ejeY + 5);
                bolaF.cambiarColor(Color.RED);
                bolaF.draw();
            }
        }

        if (aciertos.get(1) > 0) {
            for (int i = 0; i < aciertos.get(1); i++) {
                bolaF.cambiarPosicion(ejeX += 13, ejeY + 5);
                bolaF.cambiarColor(Color.BLACK);
                bolaF.draw();
            }
        }

        for (int i = 0; i < bolasBlancas; i++) {
            bolaF.cambiarPosicion(ejeX += 13, ejeY + 5);
            bolaF.cambiarColor(Color.WHITE);
            bolaF.draw();
        }
    }

    private void mostrarCombinacionGanadora() {
        ArrayList<Integer> claveGanadora = consola.obtClave();
        for (int i = 0; i < claveGanadora.size(); i++) {
            dibujarClaveSecreta(claveGanadora.get(i), i);
        }
    }

    private void dibujarClaveSecreta(int color, int posicion) {
    int ejeXTemp = posicion * 30 + 30;
    int ejeYTemp = ejeY - 33 * 15; // Colocar las bolas arriba del último intento
    BouncingBall bola = new BouncingBall(ejeXTemp, ejeYTemp, 15, getColorBola(color), ground, canvas);
    bola.draw();
    }

    private Color getColorBola(int index) {
        Color nuevoColor;
        int opc = index;
        switch (opc) {
            case 1:
                nuevoColor = new Color(248, 187, 208);
                break;
            case 2:
                nuevoColor = new Color(255, 204, 188);
                break;
            case 3:
                nuevoColor = new Color(207, 216, 220);
                break;
            case 4:
                nuevoColor = new Color(209, 196, 233);
                break;
            case 5:
                nuevoColor = new Color(239, 154, 154);
                break;
            case 6:
                nuevoColor = new Color(178, 223, 219);
                break;
            case 7:
                nuevoColor = new Color(179, 229, 252);
                break;
            case 8:
                nuevoColor = new Color(255, 249, 196);
                break;
            default:
                nuevoColor = Color.BLACK;
                break;
        }
        return nuevoColor;
    }

    private void mostrarClaveSecreta() {
        if (versionPrueba) {
            ArrayList<Integer> claveSecreta = consola.obtClave();
            System.out.print("La clave secreta es: ");
            for (int i = 0; i < claveSecreta.size(); i++) {
                int color = claveSecreta.get(i);
                System.out.print(getColorTexto(color) + " ");
            }
            System.out.println();
        }
    }

    private String getColorTexto(int color) {
        switch (color) {
            case 1:
                return "Rojo";
            case 2:
                return "Verde";
            case 3:
                return "Azul";
            case 4:
                return "Amarillo";
            case 5:
                return "Rosado";
            case 6:
                return "Naranja";
            case 7:
                return "Gris";
            case 8:
                return "Magenta";
            default:
                return "Desconocido";
        }
    }
}



