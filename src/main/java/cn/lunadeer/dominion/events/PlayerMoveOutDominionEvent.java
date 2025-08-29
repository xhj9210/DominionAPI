package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a player moves out of a dominion.
 */
public class PlayerMoveOutDominionEvent extends CallableEvent {

    private final Player player;
    private final DominionDTO dominion;

    /**
     * Constructs a new PlayerMoveOutDominionEvent.
     *
     * @param player   the player who moved out
     * @param dominion the dominion the player moved out of
     */
    public PlayerMoveOutDominionEvent(Player player, DominionDTO dominion) {
        this.player = player;
        this.dominion = dominion;
    }

    /**
     * Gets the player who moved out.
     *
     * @return the player
     */
    public @NotNull Player getPlayer() {
        return player;
    }

    /**
     * Gets the dominion the player moved out of.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }
}