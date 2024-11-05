package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * 领地大小变更事件，当一个领地的大小被变更时触发。
 */
@ApiStatus.Experimental
public class DominionSizeChangeEvent extends DominionModifyEvent {

    /**
     * 领地大小变更类型
     */
    public enum SizeChangeType {
        CONTRACT,   // 收缩
        EXPAND    // 扩张
    }

    private boolean skipEconomy;
    private BlockFace direction;
    private int size;
    private final SizeChangeType type;

    /**
     * 领地大小变更事件
     *
     * @param operator  操作者
     * @param dominion  领地
     * @param type      变更类型
     * @param direction 方向
     * @param size      大小
     */
    public DominionSizeChangeEvent(@NotNull AbstractOperator operator,
                                   @NotNull DominionDTO dominion,
                                   @NotNull SizeChangeType type,
                                   @NotNull BlockFace direction, int size) {
        super(operator, dominion);
        this.skipEconomy = false;
        this.direction = direction;
        this.size = size;
        this.type = type;
    }

    /**
     * 获取操作的方向。
     *
     * @return 方向
     */
    public BlockFace getDirection() {
        return direction;
    }

    /**
     * 设置操作的方向。
     *
     * @param direction 方向
     * @apiNote 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     */
    public void setDirection(BlockFace direction) {
        this.direction = direction;
    }

    /**
     * 获取变更大小。
     *
     * @return 变更大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置变更大小。
     *
     * @param size 变更大小
     * @apiNote 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 设置是否跳过经济系统的处理，如果设置为 true，则不会检查、扣除经济。
     *
     * @param skipEconomy 是否跳过经济系统的处理
     * @apiNote 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * 是否跳过经济系统的处理
     *
     * @return 是否跳过经济系统的处理
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * 获取变更类型
     *
     * @return 变更类型
     */
    public SizeChangeType getType() {
        return type;
    }
}
