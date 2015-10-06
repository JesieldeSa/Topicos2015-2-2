package br.grupointegrado.ads.flappyBird;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Jesi on 05/10/2015.
 */
public class Passaro {
    private OrthographicCamera camera;  // camera do jogo
    private final Texture[] texturas;
    private World mundo;    // representa o mundo do Box2D
    private Body corpo;  // corpo do chao



    public Passaro(World mundo, OrthographicCamera camera, Texture[] texturas){
      this.mundo = mundo;
        this.camera = camera;
        this.texturas = texturas;

        initCorpo();
    }

    private void initCorpo() {
        float x = (camera.viewportWidth / 2) / Util.PIXEL_METRO;
        float y = (camera.viewportHeight / 2) / Util.PIXEL_METRO;

        corpo = Util.criarCorpo(mundo, BodyDef.BodyType.DynamicBody, x, y);

        CircleShape shape = new CircleShape();
        shape.setRadius(18 / Util.PIXEL_METRO);

        Fixture forma = Util.criarForma(corpo, shape, "PASSARO");
        shape.dispose();
    }
}
