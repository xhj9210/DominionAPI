package cn.lunadeer.dominion.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CallableEvent extends Event {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    /**
     * 调用事件，等价于 paper 的 callEvent 方法，此处定义是为了兼容 Spigot。
     *
     * @return 事件是否成功执行，如果事件被取消则返回 false
     */
    public boolean call() {
        org.bukkit.Bukkit.getPluginManager().callEvent(this);
        if (this instanceof Cancellable) {
            return !((Cancellable) this).isCancelled();
        } else {
            return true;
        }
    }

}
