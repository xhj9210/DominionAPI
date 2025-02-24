package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a group is deleted within a dominion.
 * <p>
 * This event is triggered when a group is removed.
 */
public class GroupDeleteEvent extends ResultEvent {

    private DominionDTO dominion;
    private GroupDTO group;

    /**
     * Constructs a new GroupDeleteEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the group belongs
     * @param group    the group being deleted
     */
    public GroupDeleteEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group) {
        super(operator);
        this.dominion = dominion;
        this.group = group;
    }

    /**
     * Sets the dominion to which the group belongs.
     *
     * @param dominion the dominion to set
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

    /**
     * Gets the dominion to which the group belongs.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the group being deleted.
     *
     * @param group the group to set
     */
    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    /**
     * Gets the group being deleted.
     *
     * @return the group
     */
    public @NotNull GroupDTO getGroup() {
        return group;
    }
}