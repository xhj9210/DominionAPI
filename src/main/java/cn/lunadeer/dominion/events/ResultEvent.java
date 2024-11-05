package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.minecraftpluginutils.i18n.i18n;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ResultEvent extends Event implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean cancelled;

    private final AbstractOperator operator;

    public ResultEvent(AbstractOperator operator) {
        this.operator = operator;
        this.cancelled = false;
    }

    public AbstractOperator getOperator() {
        return operator;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public void setCancelled(boolean b, AbstractOperator.ResultType type, i18n reason, Object... args) {
        this.cancelled = b;
        this.operator.addResult(type, reason, args);
        this.operator.completeResult(true);
    }

}
