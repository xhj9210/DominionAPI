package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 领地重命名事件，当一个领地被重命名时触发。
 */
@ApiStatus.Experimental
public class DominionRenameEvent extends DominionModifyEvent {

    private String newName;
    private final String oldName;

    /**
     * 领地重命名事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param newName  新名称
     */
    public DominionRenameEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull String newName) {
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
     *
     * @param newName 新名称
     * @apiNote 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     */
    public void setNewName(@NotNull String newName) {
        this.newName = newName;
    }
}
