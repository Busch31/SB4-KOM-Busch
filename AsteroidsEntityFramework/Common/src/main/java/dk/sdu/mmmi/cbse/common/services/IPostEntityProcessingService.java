package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * The IPostEntityProcessingService interface is used to define a service for post processing entities in the game world.
 */
public interface IPostEntityProcessingService  {

        /**
         * Is used to post processes the entities in the game world using the supplied game data and world.
         *
         * @param gameData is used for the current game state data.
         * @param world contains all the entities that needs to be post processed.
         *
         * @pre gameData and world cannot not be null is has to be defined.
         * @post All entities in the game world are post processed based on the current game state.
         */

        void process(GameData gameData, World world);
}
