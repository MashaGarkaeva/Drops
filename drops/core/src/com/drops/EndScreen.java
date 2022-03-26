package com.drops;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class EndScreen implements Screen {
    final drops game;
    OrthographicCamera camera;
    Texture background;
    int collectedVegetables;
    EndScreen(final drops gam, int collectedVegetables){
        game = gam;
        this.collectedVegetables = collectedVegetables;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        if (this.collectedVegetables >= 40){
            background = new Texture("goodend.png");
        } else {
            background = new Texture("badend.png");
        }
        game.batch.draw(background, 0, 0);
        game.batch.end();
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenu(game));
            dispose();
        }

    }
    @Override
    public void show() {

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
