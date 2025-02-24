package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.events.dominion.modify.DominionModifyEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Event triggered when a member's flag is set in the Dominion system.
 */
@ApiStatus.Experimental
public class MemberSetFlagEvent extends DominionModifyEvent {

    private final PriFlag flag;
    private final boolean oldValue;
    private boolean newValue;
    private final MemberDTO member;

    /**
     * Constructs a new MemberSetFlagEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion to which the member belongs
     * @param member   the member whose flag is being set
     * @param flag     the flag being set
     * @param newValue the new value of the flag
     */
    public MemberSetFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull MemberDTO member, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = member.getFlagValue(flag);
        this.newValue = newValue;
        this.member = member;
    }

    /**
     * Gets the flag being set.
     *
     * @return the flag being set
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
     * Gets the member whose flag is being set.
     *
     * @return the member whose flag is being set
     */
    public MemberDTO getMember() {
        return member;
    }
}