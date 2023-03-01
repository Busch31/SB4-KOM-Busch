package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import static com.badlogic.gdx.math.MathUtils.random;

public class AsteroidPlugin implements IGamePluginService {
    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    private Entity createAsteroid(GameData gameData) {
        float deacceleration = 0;
        float acceleration = 20;
        float maxSpeed = 20;
        float rotationSpeed = 2;
        float x = gameData.getDisplayWidth() / 2;
        float y = gameData.getDisplayHeight() / 2;
        float radians = (float) (Math.random()*Math.PI);

        Entity asteroid = new Asteroid();
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        x = random.nextFloat()* gameData.getDisplayHeight();
        y = random.nextFloat()* gameData.getDisplayWidth();
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(1,100));

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}


