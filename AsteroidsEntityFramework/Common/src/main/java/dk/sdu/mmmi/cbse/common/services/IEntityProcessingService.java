package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * The IEntityProcessingService interface is used to  define a service for processing the entities in the game world, these could be the player, enemy, asteroids and so on.
 */

public interface IEntityProcessingService {
    /**
     * This method is used to process the entities, that are used in the game world by using the supplied world and the game data.
     *
     * @param gameData is used for the current game state data.
     * @param world contains all the entities that needs to be processed.
     *
     * @pre gameData and world cannot not be null is has to be defined.
     * @post All the entities in the game world are updated, based on the current state of the game.
     */
    void process(GameData gameData, World world);
}
