package br.edu.dev.main;

import java.awt.*;
import java.util.Random;

public class Ball {

    public double x, y;
    private static final int WIDTH = 4;
    private static final int HEIGHT = 4;
    public double dx, dy;
    public double speed = 1.7;

    public Ball(double x, double y) {
        this.x = x;
        this.y = y;

        int angle = new Random().nextInt(120 - 45) + 45 + 1;
        dx = Math.cos(Math.toRadians(angle));
        dy = Math.sin(Math.toRadians(angle));
    }

    public void tick() {
        if (x + (dx * speed) + WIDTH >= Game.WIDTH) {
            dx += -1;

        } else if (x + (dx * speed) < 0) {
            dx *= -1;
        }

        if (y >= Game.HEIGHT) {
            //Ponto do inimigo.
            System.out.println("Ponto do inimigo!");
            new Game();
            return;
        } else if (y < 0) {
            //Ponto do jogador.
            System.out.println("Ponto nosso! YAYY!");
            new Game();
            return;
        }

        Rectangle bounds = new Rectangle((int) (x + (dx * speed)), (int) (y + (dy * speed)), WIDTH, HEIGHT);

        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.WIDTH, Game.player.HEIGHT );
        Rectangle boundsEnemy = new Rectangle((int) Game.enemy.x, (int) Game.enemy.y, Game.enemy.WIDTH, Game.enemy.HEIGHT);

        if (bounds.intersects(boundsPlayer)) {
            int angle = new Random().nextInt(120 - 45) + 45 + 1;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy > 0)
                dy *= -1;
        } else if (bounds.intersects(boundsEnemy)) {
            int angle = new Random().nextInt(120 - 45) + 45 + 1;
            dx = Math.cos(Math.toRadians(angle));
            dy = Math.sin(Math.toRadians(angle));
            if (dy < 0)
                dy *= -1;
        }


        x += dx * speed;
        y += dy * speed;
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
    }
}
