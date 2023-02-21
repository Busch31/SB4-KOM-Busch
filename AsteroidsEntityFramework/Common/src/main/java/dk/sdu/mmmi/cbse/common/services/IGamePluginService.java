package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * The IGamePluginService interface is used to define the service for adding a new plugin(s) to the game engine.
 */
public interface IGamePluginService {

    /**
     * This method start the plugin and will add it to the game engine, by using the supplied game data and world.
     *
     * @param gameData is used for the current game state data.
     * @param world contains all the entities that needs to be processed and also the systems.
     *
     * @pre gameData and world cannot not be null is has to be defined.
     * @post When the plugin has been started and is added to the game engine.
     */
    void start(GameData gameData, World world);
    /**
     * This method will stop the plugin and removing it from the game engine, using the supplied world and game data.
     *
     * @param gameData the data for the current game.
     * @param world contains all entities and systems.
     *
     * @pre gameData and world cannot not be null is has to be defined.
     * @post The plugin(s) is stopped and are removed from the game engine.
     */

    void stop(GameData gameData, World world);
}
