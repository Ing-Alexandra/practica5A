package uabc.ic.MasterMind;

import java.awt.Color;


public class BallDemo   
{
    private final Canvas myCanvas;

    public BallDemo()
    {
        myCanvas = new Canvas("MisterMind", 600, 500);
    }

    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        myCanvas.setForegroundColor(Color.RED);
        
        myCanvas.drawLine(50, ground, 550, ground);

        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
}
