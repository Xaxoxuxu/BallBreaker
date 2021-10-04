package com.xaxoxuxu.game.ballbreaker.objects;

import com.badlogic.gdx.Gdx;

public class Paddle extends BaseRect
{
    public Paddle(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    public void update()
    {
        rect.x = Gdx.input.getX() - rect.width / 2;

        if (rect.x < 0)
        {
            rect.x = 0;
        }
        if (rect.x > Gdx.graphics.getWidth() - rect.width)
        {
            rect.x = Gdx.graphics.getWidth() - rect.width;
        }
    }

    @Override
    public String toString()
    {
        return "Paddle{" +
                "y=" + rect.y +
                ", x=" + rect.x +
                '}';
    }
}
