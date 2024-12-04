package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * 玩家进入领地事件，当玩家进入一个领地时触发。
 */
public class PlayerMoveInDominionEvent extends CallableEvent {

    private final Player player;
    private final DominionDTO dominion;

    public PlayerMoveInDominionEvent(@NotNull Player player, @NotNull DominionDTO dominion) {
        this.player = player;
        this.dominion = dominion;
    }

    /**
     * 获取玩家
     *
     * @return 玩家
     */
    public @NotNull Player getPlayer() {
        return player;
    }

    /**
     * 获取玩家进入的领地
     *
     * @return 领地
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }
}
