package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import cn.lunadeer.dominion.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a group of a dominion is created.
 */
public class GroupCreateEvent extends ResultEvent {

    private DominionDTO dominion;
    private String groupName;
    private final CompletableFuture<GroupDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new GroupCreateEvent.
     *
     * @param operator  the command sender who initiated the event
     * @param dominion  the dominion to which the group belongs
     * @param groupName the name of the group being created
     */
    public GroupCreateEvent(@NotNull CommandSender operator,
                            @NotNull DominionDTO dominion,
                            @NotNull String groupName) {
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
     * Gets the CompletableFuture that will be completed with the created GroupDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the group is created, you should use the
     * {@link #afterCreated(Consumer)} method instead.
     *
     * @return the CompletableFuture to be completed
     */
    public CompletableFuture<GroupDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the group is created.
     * <p>
     * Use this method to perform actions after the group has been created (may fail),
     * if you need to do something with the created group,
     *
     * @param consumer the consumer to handle the created group
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterCreated(Consumer<GroupDTO> consumer) {
        return future.thenAccept(consumer);
    }

    /**
     * @param group the group to set
     * @deprecated This method is deprecated and will be removed in future versions.
     */
    @Deprecated(since = "4.6.0", forRemoval = true)
    public void setGroup(@NotNull GroupDTO group) {
    }

    /**
     * @deprecated This method is deprecated and will be removed in future versions.
     * To get the created dominion, use the {@link #afterCreated(Consumer)} method instead.
     */
    @Deprecated(since = "4.6.0", forRemoval = true)
    public @Nullable GroupDTO getGroup() {
        return null;
    }
}