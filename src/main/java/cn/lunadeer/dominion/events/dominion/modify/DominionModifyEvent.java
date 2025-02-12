package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DominionModifyEvent extends ResultEvent {

    private final DominionDTO dominion;

    public DominionModifyEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.dominion = dominion;
    }

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

}
