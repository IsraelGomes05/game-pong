package br.edu.dev.main;

import java.awt.*;

public class Player {

    public boolean right, left;
    public int x, y;
    public final int WIDTH;
    public final int HEIGHT;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.WIDTH = 40;
        this.HEIGHT = 5;
    }

    public void tick() {
        if (right) x += 2;
        else if (left) x -= 2;

        if (x + WIDTH > Game.WIDTH) {
            x = Game.WIDTH - WIDTH;
        } else if (x < 0) {
            x = 0;
        }
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, WIDTH, HEIGHT);
    }
}
