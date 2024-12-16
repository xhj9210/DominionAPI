package cn.lunadeer.dominion.events.dominion;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 领地删除事件，当一个领地被删除时触发。设置 setSkipEconomy(true) 可以跳过经济系统的处理。
 */
@ApiStatus.Experimental
public class DominionDeleteEvent extends ResultEvent {

    private boolean skipEconomy;
    private boolean force;
    private final DominionDTO dominion;

    /**
     * 领地删除事件
     *
     * @param operator 操作者
     * @param dominion 领地
     */
    public DominionDeleteEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.dominion = dominion;
        this.skipEconomy = false;
        this.force = true;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    /**
     * 设置是否跳过经济系统的处理，如果设置为 true，则不会检查、扣除经济。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param skipEconomy 是否跳过
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * 是否跳过经济系统的处理
     *
     * @return 是否跳过
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * 获取领地
     *
     * @return 领地
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }
}
