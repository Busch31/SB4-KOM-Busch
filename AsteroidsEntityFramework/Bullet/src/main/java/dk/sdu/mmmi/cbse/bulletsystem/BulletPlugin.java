package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.playersystem.Player;


public class BulletPlugin implements IGamePluginService {

    private Entity bullet;


    public BulletPlugin() {

    }

    @Override
    public void start(GameData gameData, World world) {
        bullet = createBullet(gameData, world);
        world.addEntity(bullet);
    }

    private Entity createBullet(GameData gameData, World world) {

        float deacceleration = 10;
        float acceleration = 20000;
        float maxSpeed = 30000;
        float rotationSpeed = 5;


        Entity bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));

        for (Entity player : world.getEntities(Player.class)) {
            PositionPart playerPosistionPart = player.getPart(PositionPart.class);
            bullet.add(new PositionPart(playerPosistionPart.getX(), playerPosistionPart.getY(), playerPosistionPart.getRadians()));
            bullet.add((new LifePart(1,1)));
        }


        return bullet;
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(bullet);
    }
}