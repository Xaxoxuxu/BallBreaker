package com.xaxoxuxu.game.ballbreaker.objects;


public class Block extends BaseRect
{
    private boolean isDestroyed;

    public Block(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        isDestroyed = false;
    }

    public boolean isDestroyed()
    {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed)
    {
        isDestroyed = destroyed;
    }
}
