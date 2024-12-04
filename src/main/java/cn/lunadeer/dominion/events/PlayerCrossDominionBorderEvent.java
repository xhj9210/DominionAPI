package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 玩家穿过领地边界事件，包含了（进入、离开、从一个领地移动到另一个领地）三种情况。
 * 当玩家从没有领地的位置移动到领地内部时 from 为 null，当玩家从领地内部移动到没有领地的位置时 to 为 null。
 * 从理论上来说，通常情况下：from 与 to 均可能为 null 但不会同时为 null，在均不为 null 的情况下 from 与 to 不会相同。
 * 如果仅希望监听玩家进入领地的事件请参考 {@link PlayerMoveInDominionEvent}，
 * 如果仅希望监听玩家离开领地的事件请参考 {@link PlayerMoveOutDominionEvent}。
 */
public class PlayerCrossDominionBorderEvent extends CallableEvent {

    private final Player player;
    private final DominionDTO from;
    private final DominionDTO to;

    public PlayerCrossDominionBorderEvent(@NotNull Player player, @Nullable DominionDTO from, @Nullable DominionDTO to) {
        this.player = player;
        this.from = from;
        this.to = to;
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
     * 获取玩家离开的领地
     *
     * @return 领地，如果玩家进入一个领地则此返回值为null
     */
    public @Nullable DominionDTO getFrom() {
        return from;
    }

    /**
     * 获取玩家进入的领地
     *
     * @return 领地，如果玩家离开一个领地则此返回值为null
     */
    public @Nullable DominionDTO getTo() {
        return to;
    }

}
