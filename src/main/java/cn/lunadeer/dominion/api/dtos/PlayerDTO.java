package cn.lunadeer.dominion.api.dtos;

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
    PlayerDTO updateLastKnownName(String name);

    /**
     * Gets the ID of the group title the player is using.
     *
     * @return the ID of the group title the player is using
     */
    Integer getUsingGroupTitleID();
}