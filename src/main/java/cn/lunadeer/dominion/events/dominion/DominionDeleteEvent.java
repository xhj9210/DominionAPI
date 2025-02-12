package cn.lunadeer.dominion.events.dominion;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a dominion is deleted.
 * This event is experimental and may change in future versions.
 */
@ApiStatus.Experimental
public class DominionDeleteEvent extends ResultEvent {

    private boolean skipEconomy;
    private boolean force;
    private final DominionDTO dominion;

    /**
     * Constructs a new DominionDeleteEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to be deleted
     */
    public DominionDeleteEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.dominion = dominion;
        this.skipEconomy = false;
        this.force = true;
    }

    /**
     * Checks if the deletion is forced.
     *
     * @return true if the deletion is forced, false otherwise
     */
    public boolean isForce() {
        return force;
    }

    /**
     * Sets whether the deletion is forced.
     *
     * @param force true to force the deletion, false otherwise
     */
    public void setForce(boolean force) {
        this.force = force;
    }

    /**
     * Sets whether to skip the economy check during deletion.
     *
     * @param skipEconomy true to skip the economy check, false otherwise
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * Checks if the economy check is skipped during deletion.
     *
     * @return true if the economy check is skipped, false otherwise
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * Gets the dominion to be deleted.
     *
     * @return the dominion to be deleted
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }
}