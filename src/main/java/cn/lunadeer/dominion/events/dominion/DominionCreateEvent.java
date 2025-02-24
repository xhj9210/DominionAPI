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
 * Event triggered when a Dominion is created in the Dominion system.
 * Setting setSkipEconomy(true) can skip the economic system processing.
 * To modify creation information, set your EventPriority to {@link org.bukkit.event.EventPriority#LOWEST}.
 * Changes made after this will not take effect.
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
     * Constructs a new DominionCreateEvent.
     *
     * @param operator the command sender who initiated the event
     * @param name     the name of the dominion
     * @param owner    the owner of the dominion
     * @param world    the world where the dominion is located
     * @param cuboid   the cuboid representing the dominion's boundaries
     * @param parent   the parent dominion, or null if there is no parent
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
     * Sets whether to skip the economic system processing.
     * <p>
     * Changes made in {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler} will not take effect.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     *
     * @param skipEconomy true to skip the economic system processing, false otherwise
     */
    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    /**
     * Gets whether the economic system processing is skipped.
     *
     * @return true if the economic system processing is skipped, false otherwise
     */
    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    /**
     * Gets the name of the dominion.
     *
     * @return the name of the dominion
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * Sets the name of the dominion.
     * <p>
     * Changes made in {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler} will not take effect.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     *
     * @param name the name of the dominion
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * Gets the cuboid representing the dominion's boundaries.
     *
     * @return the cuboid representing the dominion's boundaries
     */
    public @NotNull CuboidDTO getCuboid() {
        return cuboid;
    }

    /**
     * Sets the cuboid representing the dominion's boundaries.
     *
     * @param cuboid the cuboid representing the dominion's boundaries
     */
    public void setCuboid(@NotNull CuboidDTO cuboid) {
        this.cuboid = cuboid;
    }

    /**
     * Gets the world where the dominion is located.
     *
     * @return the world where the dominion is located
     */
    public @NotNull World getWorld() {
        return world;
    }

    /**
     * Sets the world where the dominion is located.
     *
     * @param world the world where the dominion is located
     */
    public void setWorld(@NotNull World world) {
        this.world = world;
    }

    /**
     * Gets the parent dominion, or null if there is no parent.
     *
     * @return the parent dominion, or null if there is no parent
     */
    public @Nullable DominionDTO getParent() {
        return parent;
    }

    /**
     * Sets the parent dominion.
     * <p>
     * Changes made in {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler} will not take effect.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     *
     * @param parent the parent dominion
     */
    public void setParent(@Nullable DominionDTO parent) {
        this.parent = parent;
    }

    /**
     * Gets the owner of the dominion.
     *
     * @return the owner of the dominion
     */
    public @NotNull UUID getOwner() {
        return owner;
    }

    /**
     * Sets the owner of the dominion.
     * <p>
     * Changes made in {@link org.bukkit.event.EventPriority} HIGH or higher {@link org.bukkit.event.EventHandler} will not take effect.
     * (Default is {@link org.bukkit.event.EventPriority#NORMAL})
     *
     * @param owner the owner of the dominion
     */
    public void setOwner(@NotNull UUID owner) {
        this.owner = owner;
    }

    /**
     * Gets the dominion.
     * <p>
     * If retrieved in {@link org.bukkit.event.EventPriority} LOW, LOWEST, or NORMAL {@link org.bukkit.event.EventHandler}, it will be null,
     * as the dominion has not been created yet.
     *
     * @return the dominion, or null if it has not been created yet
     */
    public @Nullable DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the dominion.
     *
     * @param dominion the dominion to set
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }
}