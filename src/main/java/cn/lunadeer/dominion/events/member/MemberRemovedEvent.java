package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a member is removed from a Dominion.
 * <p>
 * This event is triggered when a player removes a member.
 */
@ApiStatus.Experimental
public class MemberRemovedEvent extends ResultEvent {
    private DominionDTO dominion;
    private MemberDTO member;

    /**
     * Constructs a new MemberRemovedEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion from which the member is removed
     * @param member   the member being removed
     */
    public MemberRemovedEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull MemberDTO member) {
        super(operator);
        this.dominion = dominion;
        this.member = member;
    }

    /**
     * Sets the dominion.
     *
     * @param dominion the dominion to set
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

    /**
     * Gets the dominion.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the member.
     *
     * @param member the member to set
     */
    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets the member.
     *
     * @return the member
     */
    public @NotNull MemberDTO getMember() {
        return member;
    }
}