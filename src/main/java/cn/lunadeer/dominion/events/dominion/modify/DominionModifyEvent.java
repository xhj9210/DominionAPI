package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 修改领地相关操作的事件。
 */
public class DominionModifyEvent extends ResultEvent {

    private final DominionDTO before;
    private DominionDTO after = null;

    public DominionModifyEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.before = dominion;
    }

    /**
     * 获取修改前的领地。
     *
     * @return 领地
     */
    public @NotNull DominionDTO getDominionBefore() {
        return before;
    }

    /**
     * 获取修改后的领地。
     *
     * @return 修改后的领地
     * @apiNote 如果修改失败或者在 {@link org.bukkit.event.EventPriority}
     * 为 {@link org.bukkit.event.EventPriority#LOW} 或 {@link org.bukkit.event.EventPriority#LOWEST}
     * 或 {@link org.bukkit.event.EventPriority#NORMAL} 的 {@link org.bukkit.event.EventHandler} 中获取则为 null，
     */
    public @Nullable DominionDTO getDominionAfter() {
        return after;
    }

    public void setDominionAfter(@Nullable DominionDTO after) {
        this.after = after;
    }

}
