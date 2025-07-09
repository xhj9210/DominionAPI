package cn.lunadeer.dominion.api.dtos;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Interface representing a Player Data Transfer Object (DTO).
 */
public interface PlayerDTO {
    /**
     * Gets the ID of the player.
     *
     * @return the ID of the player
     */
    Integer getId();

    /**
     * Gets the UUID of the player.
     *
     * @return the UUID of the player
     */
    UUID getUuid();

    /**
     * Gets the last known name of the player.
     *
     * @return the last known name of the player
     */
    String getLastKnownName();

    /**
     * Updates the last known name of the player. Returns the updated player object.
     *
     * @param name the new last known name of the player
     * @return the updated player object
     */
    PlayerDTO updateLastKnownName(String name, URL skinUrl) throws SQLException;

    /**
     * Gets the ID of the group title the player is using.
     *
     * @return the ID of the group title the player is using
     */
    Integer getUsingGroupTitleID();

    /**
     * Gets the URL of the player's skin.
     *
     * @return the URL of the player's skin
     */
    @NotNull URL getSkinUrl() throws MalformedURLException;
}