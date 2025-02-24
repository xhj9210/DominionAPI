package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Event triggered when a member is added to a Dominion.
 * <p>
 * This event is triggered when a player adds a member.
 * After a successful addition, the new member can be retrieved using {@link #getMember()}.
 * If the addition fails, {@link #getMember()} returns null.
 */
@ApiStatus.Experimental
public class MemberAddedEvent extends ResultEvent {
    private DominionDTO dominion;
    private PlayerDTO player;
    private MemberDTO member = null;

    /**
     * Constructs a new MemberAddedEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the member is added
     * @param player   the player who is adding the member
     */
    public MemberAddedEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull PlayerDTO player) {
        super(operator);
        this.dominion = dominion;
        this.player = player;
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
     * Sets the player.
     *
     * @param player the player to set
     */
    public void setPlayer(@NotNull PlayerDTO player) {
        this.player = player;
    }

    /**
     * Gets the player.
     *
     * @return the player
     */
    public @NotNull PlayerDTO getPlayer() {
        return player;
    }

    /**
     * Sets the newly added member.
     *
     * @param member the newly added member
     */
    public void setMember(@Nullable MemberDTO member) {
        this.member = member;
    }

    /**
     * Gets the newly added member. If there is none, returns null.
     * Only has a value if the addition was successful.
     *
     * @return the newly added member, or null if none
     */
    public @Nullable MemberDTO getMember() {
        return member;
    }
}