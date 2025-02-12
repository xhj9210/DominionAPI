package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a player moves into a dominion.
 */
public class PlayerMoveInDominionEvent extends CallableEvent {

    private final Player player;
    private final DominionDTO dominion;

    /**
     * Constructs a new PlayerMoveInDominionEvent.
     *
     * @param player   the player who moved in
     * @param dominion the dominion the player moved into
     */
    public PlayerMoveInDominionEvent(@NotNull Player player, @NotNull DominionDTO dominion) {
        this.player = player;
        this.dominion = dominion;
    }

    /**
     * Gets the player who moved in.
     *
     * @return the player
     */
    public @NotNull Player getPlayer() {
        return player;
    }

    /**
     * Gets the dominion the player moved into.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }
}