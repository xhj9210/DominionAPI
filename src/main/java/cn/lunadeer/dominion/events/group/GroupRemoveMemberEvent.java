package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a member is removed from a group of a dominion.
 */
public class GroupRemoveMemberEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final GroupDTO group;
    private MemberDTO member;
    private final CompletableFuture<MemberDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new GroupRemoveMemberEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion associated with the event
     * @param group    the group from which the member is removed
     * @param member   the member being removed
     */
    public GroupRemoveMemberEvent(@NotNull CommandSender operator,
                                  @NotNull DominionDTO dominion,
                                  @NotNull GroupDTO group,
                                  @NotNull MemberDTO member) {
        super(operator);
        this.group = group;
        this.dominion = dominion;
        this.member = member;
    }

    /**
     * Returns the group from which the member is removed.
     *
     * @return the group
     */
    public @NotNull GroupDTO getGroup() {
        return group;
    }

    /**
     * Returns the member being removed.
     *
     * @return the member
     */
    public @NotNull MemberDTO getMember() {
        return member;
    }

    /**
     * Returns the dominion associated with the event.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the member being removed.
     *
     * @param member the new member
     */
    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets the CompletableFuture that will be completed with the removed MemberDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the member is removed, you should use the
     * {@link #afterAdded(Consumer)} method instead.
     *
     * @return the CompletableFuture to be completed
     */
    public CompletableFuture<MemberDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the member is removed.
     * <p>
     * Use this method to perform actions after the member has been removed (may fail),
     * if you need to do something with the removed member.
     *
     * @param consumer the consumer to handle the created member
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterAdded(Consumer<MemberDTO> consumer) {
        return future.thenAccept(consumer);
    }
}