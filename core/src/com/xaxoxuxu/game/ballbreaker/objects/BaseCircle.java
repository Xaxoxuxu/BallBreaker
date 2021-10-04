package com.xaxoxuxu.game.ballbreaker.objects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public abstract class BaseCircle
{
    protected final Circle circle;

    protected BaseCircle(int x, int y, int radius)
    {
        circle = new Circle(x, y, radius);
    }

    protected Circle getBounds()
    {
        return circle;
    }

    public void draw(ShapeRenderer shape)
    {
        shape.circle(circle.x, circle.y, circle.radius);
    }

    protected boolean isColliding(Rectangle rectangle)
    {
        return Intersector.overlaps(circle, rectangle);
    }
}
