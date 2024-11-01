package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Experimental
public class DominionDeleteEvent extends ResultEvent {

    private boolean skipEconomy;
    private DominionDTO dominion;
    private final boolean force;

    public DominionDeleteEvent(AbstractOperator operator, @NotNull DominionDTO dominion, boolean force) {
        super(operator);
        this.skipEconomy = false;
        this.dominion = dominion;
        this.force = force;
    }

    public boolean isForce() {
        return force;
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
