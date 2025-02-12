package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DominionSetGuestFlagEvent extends DominionModifyEvent {

    private final PriFlag flag;
    private final boolean oldValue;
    private boolean newValue;

    public DominionSetGuestFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = dominion.getGuestFlagValue(flag);
        this.newValue = newValue;
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

}
