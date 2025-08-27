package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a Dominion is transferred to a new owner in the Dominion system.
 */
public class DominionTransferEvent extends DominionModifyEvent {

    private PlayerDTO newOwner;
    private final PlayerDTO oldOwner;
    private boolean force;

    /**
     * Constructs a new DominionTransferEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion being transferred
     * @param newOwner the new owner of the dominion
     */
    public DominionTransferEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull PlayerDTO newOwner) {
        super(operator, dominion);
        this.newOwner = newOwner;
        this.oldOwner = dominion.getOwnerDTO();
        this.force = true;
    }

    /**
     * Checks if the transfer is forced.
     *
     * @return true if the transfer is forced, false otherwise
     */
    public boolean isForce() {
        return force;
    }

    /**
     * Sets whether the transfer is forced.
     *
     * @param force true to force the transfer, false otherwise
     */
    public void setForce(boolean force) {
        this.force = force;
    }

    /**
     * Gets the new owner of the dominion.
     *
     * @return the new owner
     */
    public @NotNull PlayerDTO getNewOwner() {
        return newOwner;
    }

    /**
     * Gets the old owner of the dominion.
     *
     * @return the old owner
     */
    public @NotNull PlayerDTO getOldOwner() {
        return oldOwner;
    }

    /**
     * Sets the new owner of the dominion.
     * <p>
     * Changes made in {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler} will not take effect.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     *
     * @param newOwner the new owner to set
     */
    public void setNewOwner(PlayerDTO newOwner) {
        this.newOwner = newOwner;
    }
}