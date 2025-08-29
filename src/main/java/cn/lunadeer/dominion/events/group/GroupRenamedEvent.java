package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import cn.lunadeer.dominion.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a group is renamed within a dominion.
 */
public class GroupRenamedEvent extends ResultEvent {

    private final DominionDTO dominion;
    private GroupDTO group;
    private final String oldName;
    private String newName;
    private final CompletableFuture<GroupDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new GroupRenamedEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the group belongs
     * @param group    the group being renamed
     * @param newName  the new name of the group
     */
    public GroupRenamedEvent(@NotNull CommandSender operator,
                             @NotNull DominionDTO dominion,
                             @NotNull GroupDTO group,
                             @NotNull String newName) {
        super(operator);
        this.dominion = dominion;
        this.group = group;
        this.oldName = group.getNameRaw();
        this.newName = newName;
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
     * Gets the group being renamed.
     *
     * @return the group
     */
    public @NotNull GroupDTO getGroup() {
        return group;
    }

    /**
     * Sets the group being renamed.
     *
     * @param group the group to set
     */
    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    /**
     * Sets the new name of the group.
     *
     * @param newName the new name to set
     */
    public void setNewName(@NotNull String newName) {
        this.newName = newName;
    }

    /**
     * Gets the new name of the group with color codes.
     *
     * @return the new name of the group with color codes
     */
    public String getNewNameColored() {
        return newName;
    }

    /**
     * Gets the plain text new name of the group without color codes.
     *
     * @return the plain text new name of the group
     */
    public String getNewNamePlain() {
        return ColorParser.getPlainText(newName);
    }

    /**
     * Gets the old name of the group with color codes.
     *
     * @return the old name of the group with color codes
     */
    public String getOldNameColored() {
        return oldName;
    }

    /**
     * Gets the plain text old name of the group without color codes.
     *
     * @return the plain text old name of the group
     */
    public String getOldNamePlain() {
        return ColorParser.getPlainText(oldName);
    }

    /**
     * Gets the CompletableFuture that will be completed with the renamed GroupDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the group is renamed, you should use the
     * {@link #afterCreated(Consumer)} method instead.
     *
     * @return the CompletableFuture to be completed
     */
    public CompletableFuture<GroupDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the group is renamed.
     * <p>
     * Use this method to perform actions after the group has been renamed (may fail),
     * if you need to do something with the renamed group,
     *
     * @param consumer the consumer to handle the renamed group
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterCreated(Consumer<GroupDTO> consumer) {
        return future.thenAccept(consumer);
    }
}