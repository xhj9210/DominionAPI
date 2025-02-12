package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import cn.lunadeer.dominion.events.dominion.modify.DominionModifyEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class GroupSetFlagEvent extends DominionModifyEvent {

    private final PriFlag flag;
    private final boolean oldValue;
    private boolean newValue;
    private final GroupDTO group;

    public GroupSetFlagEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group, @NotNull PriFlag flag, boolean newValue) {
        super(operator, dominion);
        this.flag = flag;
        this.oldValue = group.getFlagValue(flag);
        this.newValue = newValue;
        this.group = group;
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

    public GroupDTO getGroup() {
        return group;
    }
}
