package uabc.ic.MasterMind;

import java.awt.*;
import java.awt.geom.*;

public class BouncingBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private Canvas canvas;
    private int ySpeed = 1;                // initial downward speed

    public BouncingBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int groundPos, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
    }

    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    public void cambiarPosicion(int x, int y)
    {
        xPosition = x;
        yPosition = y;
        draw();
    }
    
    public void cambiarColor(Color newColor)
    {
        erase(); 
        color = newColor; 
        draw(); 
    }
    
    public void move()
    {
        ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition +=2;

        if (yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        draw();
    }    

    public int getXPosition()
    {
        return xPosition;
    }

    public int getYPosition()
    {
        return yPosition;
    }
}
