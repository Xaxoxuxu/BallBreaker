package com.xaxoxuxu.game.ballbreaker.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.xaxoxuxu.game.ballbreaker.BallBreaker;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Ball Breaker");
        config.setWindowedMode(1280, 720);
        new Lwjgl3Application(new BallBreaker(), config);
    }
}
