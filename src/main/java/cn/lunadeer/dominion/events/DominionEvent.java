package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 领地相关操作的事件。
 * <p>
 * 领地操作事件被 callEvent() 后一般分为检查(PreCheck)和后处理(PostProcess)两个阶段。
 * 检查(PreCheck)会对领地信息进行数据完整性、安全性、逻辑正确性等方面的校验，
 * 后处理(PostProcess)则是真正对领地信息进行修改、保存、生效的阶段。
 * 在 {@link org.bukkit.event.Event} 的执行逻辑中，事件 handler 会按照 LOWEST -> LOW -> NORMAL -> HIGH -> HIGHEST -> MONITOR 的顺序执行。
 * 这两个阶段分别对应了 {@link org.bukkit.event.EventPriority} 的 LOW 和 HIGH 两个等级。
 * <p>
 * 因此，如果你要修改某个领地事件的信息，应当在 LOWEST 的 handler 中修改。否则修改不会被 Dominion 的检查(PreCheck)过滤，并可能因此导致致命的问题。
 * 也不要尝试绕过这个机制，因为 Dominion 的检查(PreCheck)主要聚焦于逻辑的正确性与安全性，任何不经过此检查的操作都可能导致致命的问题。
 * <p>
 * 再如果你希望知道创建事件是否真的执行成功了，那么你应当在 HIGHEST 或 MONITOR 的 handler 中获取领地信息。执行失败的事件 getCanceled() 会返回 true。
 */
public class DominionEvent extends ResultEvent {

    private DominionDTO dominion;

    public DominionEvent(@NotNull AbstractOperator operator, @Nullable DominionDTO dominion) {
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
