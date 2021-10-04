package com.xaxoxuxu.game.ballbreaker;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.xaxoxuxu.game.ballbreaker.objects.Ball;
import com.xaxoxuxu.game.ballbreaker.objects.Block;
import com.xaxoxuxu.game.ballbreaker.objects.Paddle;

import java.util.Random;

public class BallBreaker extends ApplicationAdapter
{
    private ShapeRenderer shape;
    private Ball ball;
    private Paddle paddle;
    private Array<Block> blocks;

    @Override
    public void create()
    {
        shape = new ShapeRenderer();

        Random random = new Random();
        ball = new Ball(
                Gdx.graphics.getWidth() / 2,
                Gdx.graphics.getHeight() / 2,
                20,
                random.nextInt(7),
                random.nextInt(3) + 5);

        paddle = new Paddle(Gdx.graphics.getWidth() / 2, 30, 200, 20);

        blocks = new Array<>();
        final int blockWidth = Gdx.graphics.getWidth() / 18;
        final int blockHeight = Gdx.graphics.getHeight() / 50;
        for (int y = Gdx.graphics.getHeight() / 2 + blockHeight * 2; y < Gdx.graphics.getHeight() - blockHeight * 3; y += blockHeight + 10)
        {
            for (int x = blockWidth; x < Gdx.graphics.getWidth() - blockWidth; x += blockWidth + 10)
            {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render()
    {
        ScreenUtils.clear(Color.BLACK);

        ball.update();
        // bounce back on colliding with paddle
        ball.checkCollision(paddle);
        // checks collision with blocks and marks blocks as destroyed if needed (and bounce back)
        blocks.forEach(b -> ball.checkCollision(b));
        for (int i = 0; i < blocks.size; i++)
        {
            if (blocks.get(i).isDestroyed())
            {
                blocks.removeIndex(i);
                i--;
            }
        }
        paddle.update();

        shape.begin(ShapeRenderer.ShapeType.Filled);
        blocks.forEach(b -> b.draw(shape));
        ball.draw(shape);
        paddle.draw(shape);
        shape.end();
    }
}
