package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Experimental
public class DominionCreateEvent extends ResultEvent {

    private boolean skipEconomy;
    private DominionDTO dominion;

    public DominionCreateEvent(AbstractOperator operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.skipEconomy = false;
        this.dominion = dominion;
    }

    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }
}
