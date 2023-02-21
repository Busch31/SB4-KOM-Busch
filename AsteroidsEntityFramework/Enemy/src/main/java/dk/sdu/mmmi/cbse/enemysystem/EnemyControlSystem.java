package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

/**
 *
 * @author jcs
 */


public class EnemyControlSystem implements IEntityProcessingService {

    private static final double Min_Movement_Probability = 0.4f;
    private static final double Max_Movement_Probability = 0.8f;
    private Random random = new Random();

    @Override
    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            PositionPart positionPart = enemy.getPart(PositionPart.class);
            MovingPart movingPart = enemy.getPart(MovingPart.class);

            // Adjust the probability of generating true or false values for moving in each direction
            double leftProbability = Min_Movement_Probability + random.nextDouble() * (Max_Movement_Probability - Min_Movement_Probability);
            double rightProbability = Min_Movement_Probability + random.nextDouble() * (Max_Movement_Probability - Min_Movement_Probability);
            double upProbability = Min_Movement_Probability + random.nextDouble() * (Max_Movement_Probability / 1.25 - Min_Movement_Probability);

            // Generate true or false values based on the adjusted probabilities
            boolean shouldTurnLeft = random.nextDouble() < leftProbability;
            boolean shouldTurnRight = random.nextDouble() < rightProbability;
            boolean shouldAccelerate = random.nextDouble() < upProbability;

            // Apply the generated movement to the enemy ship
            movingPart.setLeft(shouldTurnLeft);
            movingPart.setRight(shouldTurnRight);
            movingPart.setUp(shouldAccelerate);

            movingPart.process(gameData, enemy);
            positionPart.process(gameData, enemy);

            updateShape(enemy);
        }

    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 4 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 4 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 4 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 4 * 3.1415f / 5) * 8);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

}
