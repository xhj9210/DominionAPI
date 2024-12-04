package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.minecraftpluginutils.i18n.i18n;
import org.bukkit.event.Cancellable;

public class ResultEvent extends CallableEvent implements Cancellable {

    private boolean cancelled;

    private final AbstractOperator operator;

    public ResultEvent(AbstractOperator operator) {
        this.operator = operator;
        this.cancelled = false;
    }

    public AbstractOperator getOperator() {
        return operator;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    public void setCancelledAdnComplete(boolean b) {
        this.cancelled = b;
        this.operator.completeResult(true);
    }

    public void setCancelled(boolean b, AbstractOperator.ResultType type, i18n reason, Object... args) {
        this.cancelled = b;
        this.operator.addResult(type, reason, args);
        this.operator.completeResult(true);
    }

}
