package com.pablomunuera.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class LoseScreen implements Screen {

    final Drop game;
    private int puntuation;
    Texture gameOver;

    OrthographicCamera camera;

    public LoseScreen(final Drop game,int puntuation) {
        this.game = game;
        this.puntuation = puntuation;
        gameOver = new Texture(Gdx.files.internal("gameover.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(gameOver,0,0);
        game.font.draw(game.batch, "You lost!\nYou got: "+puntuation+" raindrops", 100, 150);
        game.font.draw(game.batch, "Tap anywhere to play again!", 100, 100);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
