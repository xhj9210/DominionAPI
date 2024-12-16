package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import org.jetbrains.annotations.NotNull;

/**
 * 领地转让事件
 */
public class DominionTransferEvent extends DominionModifyEvent {

    private PlayerDTO newOwner;
    private final PlayerDTO oldOwner;
    private boolean force;

    /**
     * 领地转让事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param newOwner 新的领地所有者 UUID
     */
    public DominionTransferEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull PlayerDTO newOwner) {
        super(operator, dominion);
        this.newOwner = newOwner;
        this.oldOwner = dominion.getOwnerDTO();
        this.force = true;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    /**
     * 获取新的领地所有者。
     *
     * @return UUID
     */
    public @NotNull PlayerDTO getNewOwner() {
        return newOwner;
    }

    /**
     * 获取旧的领地所有者。
     *
     * @return UUID
     */
    public @NotNull PlayerDTO getOldOwner() {
        return oldOwner;
    }

    /**
     * 设置新的领地所有者。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param newOwner UUID
     */
    public void setNewOwner(PlayerDTO newOwner) {
        this.newOwner = newOwner;
    }
}
