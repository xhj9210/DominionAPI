package cn.lunadeer.dominion.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a callable event in the Dominion plugin.
 * This class is designed to be compatible with both Spigot and Paper.
 */
public class CallableEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    /**
     * Gets the static handler list for this event.
     *
     * @return the handler list
     */
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    /**
     * Gets the handlers for this event.
     *
     * @return the handler list
     */
    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    /**
     * Calls the event, equivalent to Paper's callEvent method.
     * This method is defined here for Spigot compatibility.
     *
     * @return true if the event was successfully executed, false if the event was cancelled
     */
    public boolean call() {
        org.bukkit.Bukkit.getPluginManager().callEvent(this);
        if (this instanceof Cancellable) {
            return !((Cancellable) this).isCancelled();
        } else {
            return true;
        }
    }

}