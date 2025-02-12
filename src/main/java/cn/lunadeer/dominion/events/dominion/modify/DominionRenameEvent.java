package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Experimental
public class DominionRenameEvent extends DominionModifyEvent {

    private String newName;
    private final String oldName;

    /**
     * Constructs a new DominionRenameEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to be renamed
     * @param newName  the new name for the dominion
     */
    public DominionRenameEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull String newName) {
        super(operator, dominion);
        this.newName = newName;
        this.oldName = dominion.getName();
    }

    /**
     * Gets the new name of the dominion.
     *
     * @return the new name
     */
    public @NotNull String getNewName() {
        return newName;
    }

    /**
     * Gets the old name of the dominion.
     *
     * @return the old name
     */
    public @NotNull String getOldName() {
        return oldName;
    }

    /**
     * Sets the new name for the dominion.
     *
     * @param newName the new name to set
     */
    public void setNewName(@NotNull String newName) {
        this.newName = newName;
    }
}