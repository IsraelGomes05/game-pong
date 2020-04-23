package br.edu.dev.main;

import java.awt.*;

public class Enemy {

    public double x, y;
    public static final int WIDTH = 40;
    public static final int HEIGHT = 5;

    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void tick() {
        x += (Game.ball.x - x - 6) * 0.07;

        if (x + WIDTH > Game.WIDTH) {
            x = Game.WIDTH - WIDTH;
        } else if (x < 0) {
            x = 0;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
    }
}
