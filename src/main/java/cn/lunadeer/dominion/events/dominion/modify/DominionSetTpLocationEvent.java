package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 领地传送点变更事件
 */
public class DominionSetTpLocationEvent extends DominionModifyEvent {

    private final Location oldTpLocation;
    private Location newTpLocation;

    /**
     * 领地传送点变更事件
     *
     * @param operator      操作者
     * @param dominion      领地
     * @param newTpLocation 新的传送点位置
     */
    public DominionSetTpLocationEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull Location newTpLocation) {
        super(operator, dominion);
        this.oldTpLocation = dominion.getTpLocation();
        this.newTpLocation = newTpLocation;
    }

    /**
     * 获取旧的传送点位置。
     *
     * @return 旧的传送点位置
     */
    public @Nullable Location getOldTpLocation() {
        return oldTpLocation;
    }

    /**
     * 获取新的传送点位置。
     *
     * @return 新的传送点位置
     */
    public @NotNull Location getNewTpLocation() {
        return newTpLocation;
    }

    /**
     * 设置新的传送点位置。
     *
     * @param newTpLocation 新的传送点位置
     */
    public void setNewTpLocation(@NotNull Location newTpLocation) {
        this.newTpLocation = newTpLocation;
    }
}
