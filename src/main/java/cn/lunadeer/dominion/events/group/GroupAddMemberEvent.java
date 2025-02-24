package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a member is added to a group within a dominion.
 */
public class GroupAddMemberEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final GroupDTO group;
    private MemberDTO member;

    /**
     * Constructs a new GroupAddMemberEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the group belongs
     * @param group    the group to which the member is being added
     * @param member   the member being added to the group
     */
    public GroupAddMemberEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group, @NotNull MemberDTO member) {
        super(operator);
        this.dominion = dominion;
        this.group = group;
        this.member = member;
    }

    /**
     * Gets the group to which the member is being added.
     *
     * @return the group
     */
    public @NotNull GroupDTO getGroup() {
        return group;
    }

    /**
     * Gets the member being added to the group.
     *
     * @return the member
     */
    public @NotNull MemberDTO getMember() {
        return member;
    }

    /**
     * Sets the member being added to the group.
     *
     * @param member the member to set
     */
    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets the dominion to which the group belongs.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }
}