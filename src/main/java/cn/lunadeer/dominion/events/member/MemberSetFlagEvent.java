package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.events.dominion.modify.DominionModifyEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MemberSetFlagEvent extends DominionModifyEvent {

    private final PriFlag flag;
    private final boolean oldValue;
    private boolean newValue;
    private final MemberDTO member;

    public MemberSetFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull MemberDTO member, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = member.getFlagValue(flag);
        this.newValue = newValue;
        this.member = member;
    }

    public PriFlag getFlag() {
        return flag;
    }

    public boolean getOldValue() {
        return oldValue;
    }

    public boolean getNewValue() {
        return newValue;
    }

    public void setNewValue(boolean newValue) {
        this.newValue = newValue;
    }

    public MemberDTO getMember() {
        return member;
    }
}
