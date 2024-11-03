package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 领地重命名事件，当一个领地被重命名时触发。
 */
@ApiStatus.Experimental
public class DominionRenameEvent extends DominionEvent {

    private String newName;
    private final String oldName;

    /**
     * 领地重命名事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param newName  新名称
     */
    public DominionRenameEvent(AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull String newName) {
        super(operator, dominion);
        this.newName = newName;
        this.oldName = dominion.getName();
    }

    /**
     * 获取新名称。
     *
     * @return 新名称
     */
    public @NotNull String getNewName() {
        return newName;
    }

    /**
     * 获取旧名称。
     *
     * @return 旧名称
     */
    public @NotNull String getOldName() {
        return oldName;
    }

    /**
     * 设置新名称。
     * 只应当在 EventPriority 为 {@link org.bukkit.event.EventPriority#LOWEST} 的 handler 中修改，否则可能会导致不可预知的问题。
     *
     * @param newName 新名称
     */
    public void setNewName(@NotNull String newName) {
        this.newName = newName;
    }
}
