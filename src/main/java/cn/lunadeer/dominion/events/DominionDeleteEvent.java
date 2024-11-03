package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 领地删除事件，当一个领地被删除时触发。设置 setSkipEconomy(true) 可以跳过经济系统的处理。
 * 删除领地必须设置 force 为 true，否则只会提示警告信息。
 */
@ApiStatus.Experimental
public class DominionDeleteEvent extends DominionEvent {

    private boolean skipEconomy;
    private final boolean force;

    /**
     * 领地删除事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param force    只有设置为 true 才会真正删除领地，否则只会提示警告信息
     */
    public DominionDeleteEvent(AbstractOperator operator, @NotNull DominionDTO dominion, boolean force) {
        super(operator, dominion);
        this.skipEconomy = false;
        this.force = force;
    }

    public boolean isForce() {
        return force;
    }

    /**
     * 设置是否跳过经济系统的处理，如果设置为 true，则不会检查、扣除经济。
     * 只在 EventPriority 为
     * {@link org.bukkit.event.EventPriority#LOWEST} 或
     * {@link org.bukkit.event.EventPriority#LOW} 或
     * {@link org.bukkit.event.EventPriority#NORMAL}
     * 的 EventHandler 中设置时才生效。
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
}
