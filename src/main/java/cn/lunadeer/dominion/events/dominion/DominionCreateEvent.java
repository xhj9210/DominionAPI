package cn.lunadeer.dominion.events.dominion;

import cn.lunadeer.dominion.api.dtos.CuboidDTO;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * 领地创建事件，当一个领地被创建时触发。设置 setSkipEconomy(true) 可以跳过经济系统的处理。
 * 如果想要修改创建信息，请将你的 EventPriority 设置为 {@link org.bukkit.event.EventPriority#LOWEST}。
 * 在这之后修改领地创建信息将不会生效。
 */
@ApiStatus.Experimental
public class DominionCreateEvent extends ResultEvent {

    private boolean skipEconomy;
    private String name;
    public World world;
    private CuboidDTO cuboid;
    private DominionDTO parent;
    private UUID owner;
    private DominionDTO dominion = null;

    /**
     * 领地创建事件
     *
     * @param operator 操作者
     * @param name     领地名称
     * @param owner    领地所有者
     * @param world    领地所在世界
     * @param cuboid   领地范围
     * @param parent   父领地 如果没有父领地则传入 null
     */
    public DominionCreateEvent(@NotNull CommandSender operator,
                               @NotNull String name, @NotNull UUID owner,
                               @NotNull World world, @NotNull CuboidDTO cuboid,
                               @Nullable DominionDTO parent) {
        super(operator);
        this.skipEconomy = false;
        this.name = name;
        this.world = world;
        this.cuboid = cuboid;
        this.parent = parent;
        this.owner = owner;
    }

    /**
     * 设置是否跳过经济系统的处理，如果设置为 true，则不会检查、扣除经济。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param skipEconomy 是否跳过
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * 获取是否跳过经济系统的处理
     *
     * @return 是否跳过
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * 获取领地名称
     *
     * @return 领地名称
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * 设置领地名称。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param name 领地名称
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * 获取领地范围
     *
     * @return 领地范围
     */
    public @NotNull CuboidDTO getCuboid() {
        return cuboid;
    }

    /**
     * 设置领地范围
     *
     * @param cuboid 领地范围
     */
    public void setCuboid(@NotNull CuboidDTO cuboid) {
        this.cuboid = cuboid;
    }

    /**
     * 获取领地所在世界
     * @return 领地所在世界
     */
    public @NotNull World getWorld() {
        return world;
    }

    /**
     * 设置领地所在世界
     * @param world 领地所在世界
     */
    public void setWorld(@NotNull World world) {
        this.world = world;
    }

    /**
     * 获取父领地，如果没有父领地则返回 null
     *
     * @return 父领地
     */
    public @Nullable DominionDTO getParent() {
        return parent;
    }

    /**
     * 设置父领地。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param parent 父领地
     */
    public void setParent(@Nullable DominionDTO parent) {
        this.parent = parent;
    }

    /**
     * 获取领地所有者
     *
     * @return 领地所有者
     */
    public @NotNull UUID getOwner() {
        return owner;
    }

    /**
     * 设置领地所有者。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param owner 领地所有者
     */
    public void setOwner(@NotNull UUID owner) {
        this.owner = owner;
    }

    /**
     * 获取领地。
     * <p>
     * 如果在 {@link org.bukkit.event.EventPriority}
     * 为 {@link org.bukkit.event.EventPriority#LOW} 或 {@link org.bukkit.event.EventPriority#LOWEST}
     * 或 {@link org.bukkit.event.EventPriority#NORMAL} 的 {@link org.bukkit.event.EventHandler} 中获取则为 null，
     * 因为此时领地还没有创建。
     *
     * @return 领地
     */
    public @Nullable DominionDTO getDominion() {
        return dominion;
    }

    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }
}
