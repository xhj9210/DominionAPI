package cn.lunadeer.dominion.events.dominion;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.Location;
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
    private Location loc1;
    private Location loc2;
    private DominionDTO parent;
    private UUID owner;
    private DominionDTO dominion = null;

    /**
     * 领地创建事件
     *
     * @param operator 操作者
     * @param name     领地名称
     * @param loc1     领地位置1
     * @param loc2     领地位置2
     * @param parent   父领地 如果没有父领地则传入 null
     */
    public DominionCreateEvent(@NotNull AbstractOperator operator,
                               @NotNull String name, @NotNull UUID owner,
                               @NotNull Location loc1, @NotNull Location loc2,
                               @Nullable DominionDTO parent) {
        super(operator);
        this.skipEconomy = false;
        this.name = name;
        this.loc1 = loc1;
        this.loc2 = loc2;
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
     * 获取领地位置1
     *
     * @return 领地位置1
     */
    public @NotNull Location getLoc1() {
        return loc1;
    }

    /**
     * 设置领地位置1。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param loc1 领地位置1
     */
    public void setLoc1(@NotNull Location loc1) {
        this.loc1 = loc1;
    }

    /**
     * 获取领地位置2
     *
     * @return 领地位置2
     */
    public @NotNull Location getLoc2() {
        return loc2;
    }

    /**
     * 设置领地位置2。
     * <p>
     * 在 {@link org.bukkit.event.EventPriority} 为 {@link org.bukkit.event.EventPriority#HIGH} 以及更高
     * 的 {@link org.bukkit.event.EventHandler} 中修改时无法生效。（默认为 {@link org.bukkit.event.EventPriority#NORMAL}）
     *
     * @param loc2 领地位置2
     */
    public void setLoc2(@NotNull Location loc2) {
        this.loc2 = loc2;
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
