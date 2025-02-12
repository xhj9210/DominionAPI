package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DominionSetEnvFlagEvent extends DominionModifyEvent {

    private final EnvFlag flag;
    private final boolean oldValue;
    private boolean newValue;

    public DominionSetEnvFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull EnvFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = dominion.getEnvFlagValue(flag);
        this.newValue = newValue;
    }

    public EnvFlag getFlag() {
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
