package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a Dominion is modified in the Dominion system.
 */
@ApiStatus.Experimental
public class DominionModifyEvent extends ResultEvent {

    private DominionDTO dominion;

    /**
     * Constructs a new DominionModifyEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion being modified
     */
    public DominionModifyEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.dominion = dominion;
    }

    /**
     * Returns the dominion being modified.
     * <p>
     * To get changed dominion your event listener need to be {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler}.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     * Or otherwise get the dominion before the changes are applied.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the dominion being modified.
     *
     * @param dominion the new dominion
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

}