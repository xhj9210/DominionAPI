package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import cn.lunadeer.dominion.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Event triggered when a group is created within a dominion.
 * <p>
 * This event is triggered when a group is added.
 * After a successful addition, the new group can be obtained via {@link #getGroup()}.
 * If the addition fails, {@link #getGroup()} returns null.
 */
public class GroupCreateEvent extends ResultEvent {

    private DominionDTO dominion;
    private String groupName;
    private GroupDTO group = null;

    /**
     * Constructs a new GroupCreateEvent.
     *
     * @param operator  the command sender who initiated the event
     * @param dominion  the dominion to which the group belongs
     * @param groupName the name of the group being created
     */
    public GroupCreateEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull String groupName) {
        super(operator);
        this.dominion = dominion;
        this.groupName = groupName;
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
     * Sets the name of the group with color codes.
     *
     * @param groupName the name of the group with color codes
     */
    public void setGroupNameColored(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Gets the name of the group with color codes.
     *
     * @return the name of the group with color codes
     */
    public String getGroupNameColored() {
        return groupName;
    }

    /**
     * Gets the plain text name of the group without color codes.
     *
     * @return the plain text name of the group
     */
    public String getGroupNamePlain() {
        return ColorParser.getPlainText(groupName);
    }

    /**
     * Sets the group being created.
     *
     * @param group the group to set
     */
    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    /**
     * Gets the newly created group. If the addition fails, returns null.
     *
     * @return the newly created group, or null if the addition fails
     */
    public @Nullable GroupDTO getGroup() {
        return group;
    }
}