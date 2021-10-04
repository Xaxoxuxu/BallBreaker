package com.xaxoxuxu.game.ballbreaker.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public abstract class BaseRect
{
    protected Rectangle rect;

    protected BaseRect(int x, int y, int width, int height)
    {
        rect = new Rectangle(x, y, width, height);
    }

    protected Rectangle getBounds()
    {
        return rect;
    }

    public void draw(ShapeRenderer shape)
    {
        shape.rect(rect.x, rect.y, rect.width, rect.height);
    }
}
