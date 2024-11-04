package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import org.jetbrains.annotations.NotNull;

/**
 * 领地转让事件
 */
public class DominionTransferEvent extends DominionEvent {

    private PlayerDTO newOwner;
    private boolean force;
    private final PlayerDTO oldOwner;

    /**
     * 领地转让事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param newOwner 新的领地所有者 UUID
     */
    public DominionTransferEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull PlayerDTO oldOwner, @NotNull PlayerDTO newOwner) {
        super(operator, dominion);
        this.newOwner = newOwner;
        this.oldOwner = oldOwner;
        this.force = true;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }

    /**
     * 获取新的领地所有者 UUID
     *
     * @return UUID
     */
    public PlayerDTO getNewOwner() {
        return newOwner;
    }

    /**
     * 获取旧的领地所有者 UUID
     *
     * @return UUID
     */
    public PlayerDTO getOldOwner() {
        return oldOwner;
    }

    /**
     * 设置新的领地所有者 UUID
     * 只应当在 EventPriority 为 {@link org.bukkit.event.EventPriority#LOWEST} 的 handler 中修改，否则无法生效。
     *
     * @param newOwner UUID
     */
    public void setNewOwner(PlayerDTO newOwner) {
        this.newOwner = newOwner;
    }
}
