package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.Nullable;

public class DominionEvent extends ResultEvent {

    private DominionDTO dominion;

    public DominionEvent(AbstractOperator operator, DominionDTO dominion) {
        super(operator);
        this.dominion = dominion;
    }

    /**
     * 获取领地。
     * 如果是一个修改类型的事件，那么在 EventPriority 为
     * {@link org.bukkit.event.EventPriority#LOWEST} 或
     * {@link org.bukkit.event.EventPriority#LOW} 或
     * {@link org.bukkit.event.EventPriority#NORMAL} 的 handler 中获取则为修改前的领地信息，
     * 在 EventPriority 为
     * {@link org.bukkit.event.EventPriority#HIGHEST} 或
     * {@link org.bukkit.event.EventPriority#MONITOR} 的 handler 中获取则为修改后的领地信息。
     *
     * @return 领地
     */
    public @Nullable DominionDTO getDominion() {
        return dominion;
    }

    /**
     * 设置要创建的领地。
     * 此方法一般会被在 EventPriority 为 {@link org.bukkit.event.EventPriority#HIGH} 的 handler 中调用。
     *
     * @param dominion 领地
     * @apiNote 通常来说，不应当在 handler 中修改领地信息，否则可能会导致不可预知的问题。
     */
    public void setDominion(@Nullable DominionDTO dominion) {
        this.dominion = dominion;
    }
}
