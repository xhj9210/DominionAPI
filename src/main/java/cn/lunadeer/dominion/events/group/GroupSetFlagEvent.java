package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.events.dominion.modify.DominionModifyEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a flag is set for a group within a dominion.
 */
public class GroupSetFlagEvent extends DominionModifyEvent {

    private final PriFlag flag;
    private final boolean oldValue;
    private boolean newValue;
    private final GroupDTO group;

    /**
     * Constructs a new GroupSetFlagEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the group belongs
     * @param group    the group for which the flag is being set
     * @param flag     the flag being set
     * @param newValue the new value of the flag
     */
    public GroupSetFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = group.getFlagValue(flag);
        this.newValue = newValue;
        this.group = group;
    }

    /**
     * Gets the flag being set.
     *
     * @return the flag
     */
    public PriFlag getFlag() {
        return flag;
    }

    /**
     * Gets the old value of the flag.
     *
     * @return the old value of the flag
     */
    public boolean getOldValue() {
        return oldValue;
    }

    /**
     * Gets the new value of the flag.
     *
     * @return the new value of the flag
     */
    public boolean getNewValue() {
        return newValue;
    }

    /**
     * Sets the new value of the flag.
     *
     * @param newValue the new value to set
     */
    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }

    /**
     * Gets the group for which the flag is being set.
     *
     * @return the group
     */
    public GroupDTO getGroup() {
        return group;
    }
}