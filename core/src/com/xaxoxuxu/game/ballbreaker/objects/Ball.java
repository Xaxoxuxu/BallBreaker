package com.xaxoxuxu.game.ballbreaker.objects;

import com.badlogic.gdx.Gdx;

public class Ball extends BaseCircle
{
    private int xSpeed;
    private int ySpeed;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed)
    {
        super(x, y, size);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update()
    {
        circle.x += xSpeed;
        circle.y += ySpeed;
        if (circle.x < circle.radius || circle.x > Gdx.graphics.getWidth() - circle.radius)
        {
            xSpeed = -xSpeed;
        }
        if (circle.y < circle.radius || circle.y > Gdx.graphics.getHeight() - circle.radius)
        {
            ySpeed = -ySpeed;
        }
    }

    /**
     * Check for a collision with the paddle and reverse the direction if there is one
     * @param paddle reference to paddle object
     */
    public void checkCollision(Paddle paddle)
    {
        if (isColliding(paddle.getBounds()))
        {
            ySpeed = -ySpeed;
        }
    }

    /**
     * Check if there is a collision with a block and mark it as destroyed if so (and bounces off of it)
     * @param block block to be checked
     */
    public void checkCollision(Block block)
    {
        if (isColliding(block.getBounds()))
        {
            ySpeed = -ySpeed;
            block.setDestroyed(true);
        }
    }
}
