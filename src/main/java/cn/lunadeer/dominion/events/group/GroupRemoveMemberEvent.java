package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a member is removed from a group of a dominion.
 */
public class GroupRemoveMemberEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final GroupDTO group;
    private MemberDTO member;

    /**
     * Constructs a new GroupRemoveMemberEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion associated with the event
     * @param group    the group from which the member is removed
     * @param member   the member being removed
     */
    public GroupRemoveMemberEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group, @NotNull MemberDTO member) {
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
}