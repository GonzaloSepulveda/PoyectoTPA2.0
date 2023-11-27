package Jugador;

/**
 * @deprecated Used in past versions of the game, its use is no longer recommended
 */
public class NPC extends Player {
    public int Level;

    /***
     *This Class was sadly not used the intended idea was for the Npc to output to the user a message before and after the race taunting or accepting a win or a loss.
     * @deprecated
     *
     */
    public Car NPCCarCreation(int level) {
        Car cochePlayer = new Car("lol", "rojo",
                130 + (level * 15),
                4 + (level * 5));
        cochePlayer.setAcceleration(accelerate(Level));
        return cochePlayer;
    }

    /***
     *We also do not use this due to not needing it seeing as its intended use was in NPCCarCreation
     * @deprecated
     *
     */
    public double accelerate(int level) {
        random random = new random();
        acceleration = random.Randomizer(level);
        return acceleration;
    }

}