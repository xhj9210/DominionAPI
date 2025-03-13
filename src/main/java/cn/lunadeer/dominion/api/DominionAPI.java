package cn.lunadeer.dominion.api;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * Interface representing the Dominion API.
 * <p>
 * This interface provides methods to interact with the Dominion plugin.
 * <p>
 * Use the {@link #getInstance()} method to retrieve the singleton instance of the DominionAPI.
 */
@ApiStatus.Experimental
public abstract class DominionAPI {

    private final static int[] requiredDominionVersion = new int[]{4, 0, 0};

    /**
     * Retrieves the singleton instance of the DominionAPI.
     * This method checks if the Dominion plugin is enabled and if the version is compatible.
     * If these checks pass, it retrieves the instance of the DominionAPI from the DominionInterface class.
     *
     * @return the singleton instance of the DominionAPI
     * @throws ClassNotFoundException if the DominionInterface class cannot be found
     * @throws NoSuchFieldException   if the instance field cannot be found in the DominionInterface class
     * @throws IllegalAccessException if the instance field is not accessible
     * @throws IllegalStateException  if the Dominion plugin is not installed or the version is not compatible
     */
    public static DominionAPI getInstance() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        if (!isDominionEnabled()) {
            throw new IllegalStateException("Dominion is not installed.");
        }
        if (!isVersionCompatible(requiredDominionVersion)) {
            throw new IllegalStateException("DominionAPI is not compatible with the current version of Dominion."
                    + " Required Dominion version: " + requiredDominionVersion[0] + "." + requiredDominionVersion[1] + "." + requiredDominionVersion[2]);
        }
        var instanceField = Class.forName("cn.lunadeer.dominion.DominionInterface").getDeclaredField("instance");
        instanceField.setAccessible(true);
        return (DominionAPI) instanceField.get(null);
    }

    /**
     * Checks if the Dominion plugin is enabled.
     *
     * @return true if the Dominion plugin is enabled, false otherwise
     */
    public static boolean isDominionEnabled() {
        return Bukkit.getPluginManager().isPluginEnabled("Dominion");
    }

    /**
     * Retrieves the version of the Dominion plugin.
     * If the plugin is not found, returns an array representing version 0.0.0.
     *
     * @return an array of integers representing the version of the Dominion plugin
     */
    private static int[] getDominionVersion() {
        var plugin = Bukkit.getPluginManager().getPlugin("Dominion");
        if (plugin == null) {
            return new int[]{0, 0, 0};
        }
        var version = plugin.getDescription().getVersion().replaceAll("[^0-9.]", "");
        var versionSplit = version.split("\\.");
        var versionInt = new int[versionSplit.length];
        for (int i = 0; i < versionSplit.length; i++) {
            versionInt[i] = Integer.parseInt(versionSplit[i]);
        }
        return versionInt;
    }

    /**
     * Checks if the current version of the Dominion plugin is compatible with the required version.
     *
     * @param requiredVersion an array of integers representing the required version
     * @return true if the current version is compatible, false otherwise
     */
    private static boolean isVersionCompatible(int[] requiredVersion) {
        var version = getDominionVersion();
        for (int i = 0; i < requiredVersion.length; i++) {
            if (version[i] < requiredVersion[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Retrieves a PlayerDTO by the player's name.
     *
     * @param name the name of the player
     * @return the PlayerDTO associated with the given name, or null if not found
     */
    public abstract @Nullable PlayerDTO getPlayer(String name);

    /**
     * Retrieves a PlayerDTO by the player's UUID.
     *
     * @param player the UUID of the player
     * @return the PlayerDTO associated with the given UUID, or null if not found
     */
    public abstract @Nullable PlayerDTO getPlayer(@NotNull UUID player);

    /**
     * Retrieves the name of a player by their UUID.
     *
     * @param uuid the UUID of the player
     * @return the name of the player associated with the given UUID
     */
    public abstract @NotNull String getPlayerName(@NotNull UUID uuid);

    /**
     * Retrieves all DominionDTO objects.
     * <p>
     * This method retrieves all dominions from the cache of this server. If multi-servers mode is enabled,
     * it also retrieves dominions from the caches of other servers.
     *
     * @return a list of all DominionDTO objects
     */
    public abstract List<DominionDTO> getAllDominions();

    /**
     * Retrieves the child dominions of a given parent dominion.
     * <p>
     * This method retrieves the child dominions of the specified parent dominion from the cache of this server.
     * If multi-servers mode is enabled, it also retrieves child dominions from the caches of other servers.
     *
     * @param parent the parent DominionDTO whose children are to be retrieved
     * @return a list of child DominionDTO objects
     */
    public abstract List<DominionDTO> getChildrenDominionOf(DominionDTO parent);

    /**
     * Retrieves a DominionDTO by its ID.
     * <p>
     * This method will first attempt to retrieve the DominionDTO from the cache of this server. If the DominionDTO
     * is not found, it will then attempt to retrieve the DominionDTO from the caches of other servers.
     *
     * @param id the ID of the dominion to retrieve
     * @return the DominionDTO associated with the given ID
     */
    public abstract @Nullable DominionDTO getDominion(Integer id);

    /**
     * Retrieves a DominionDTO by its name.
     * <p>
     * This method will first attempt to retrieve the DominionDTO from the cache of this server. If the DominionDTO
     * is not found, it will then attempt to retrieve the DominionDTO from the caches of other servers.
     *
     * @param name the name of the dominion to retrieve
     * @return the DominionDTO associated with the given name
     */
    public abstract @NotNull DominionDTO getDominion(String name);

    /**
     * Retrieves a DominionDTO by its location.
     * <p>
     * This method retrieves the DominionDTO associated with the given location from the cache of this server.
     *
     * @param location the location to retrieve the dominion for
     * @return the DominionDTO associated with the given location, or null if not found
     */
    public abstract @Nullable DominionDTO getDominion(Location location);

    /**
     * Retrieves the dominions owned by a player.
     * <p>
     * This method retrieves the dominions owned by the player from the cache of this server. If multi-servers mode is enabled,
     * it also retrieves the dominions owned by the player from the caches of other servers.
     *
     * @param player the UUID of the player
     * @return a list of DominionDTO objects representing the dominions owned by the player
     */
    public abstract List<DominionDTO> getPlayerOwnDominionDTOs(UUID player);

    /**
     * Retrieves the dominions where a player is an admin.
     * <p>
     * This method retrieves the dominions where the player is an admin from the cache of this server. If multi-servers mode is enabled,
     * it also retrieves the dominions where the player is an admin from the caches of other servers.
     *
     * @param player the UUID of the player
     * @return a list of DominionDTO objects representing the dominions where the player is an admin
     */
    public abstract List<DominionDTO> getPlayerAdminDominionDTOs(UUID player);

    /**
     * Retrieves a MemberDTO by the player's UUID.
     * <p>
     * This method retrieves the MemberDTO associated with the given player from the specified dominion.
     *
     * @param dominion the DominionDTO to retrieve the member from
     * @param player   the Player object representing the player
     * @return the MemberDTO associated with the given player, or null if not found
     */
    public abstract @Nullable MemberDTO getMember(@Nullable DominionDTO dominion, @NotNull Player player);

    /**
     * Retrieves a MemberDTO by the player's UUID.
     * <p>
     * This method retrieves the MemberDTO associated with the given player from the specified dominion. If the member is not found
     * in the cache of this server, it will attempt to retrieve the member from the caches of other servers if multi-servers mode is enabled.
     *
     * @param dominion the DominionDTO to retrieve the member from
     * @param player   the UUID of the player
     * @return the MemberDTO associated with the given player, or null if not found
     */
    public abstract @Nullable MemberDTO getMember(@Nullable DominionDTO dominion, @NotNull UUID player);

    /**
     * Retrieves a GroupDTO by the member's group ID.
     * <p>
     * This method retrieves the GroupDTO associated with the group ID of the given member.
     *
     * @param member the MemberDTO whose group ID is to be used for retrieval
     * @return the GroupDTO associated with the given member's group ID, or null if not found
     */
    public abstract @Nullable GroupDTO getGroup(MemberDTO member);

    /**
     * Retrieves a GroupDTO by its ID.
     * <p>
     * This method retrieves the GroupDTO associated with the given ID from the cache of this server. If the GroupDTO
     * is not found, it will then attempt to retrieve the GroupDTO from the caches of other servers if multi-servers mode is enabled.
     *
     * @param id the ID of the group to retrieve
     * @return the GroupDTO associated with the given ID, or null if not found
     */
    public abstract @Nullable GroupDTO getGroup(Integer id);

    /**
     * Retrieves the current dominion of a player.
     * <p>
     * This method retrieves the current dominion of the player based on their location. It checks if the player is still
     * in the same dominion and if the dominion has no children. If the player has moved to a different dominion, it triggers
     * the appropriate events and updates the player's current dominion ID.
     *
     * @param player the Player object representing the player
     * @return the DominionDTO associated with the player's current location, or null if not found
     */
    public abstract @Nullable DominionDTO getPlayerCurrentDominion(@NotNull Player player);

    /**
     * Resets the current dominion ID for a player.
     * <p>
     * This method removes the current dominion ID associated with the player from the cache.
     *
     * @param player the Player object representing the player
     */
    public abstract void resetPlayerCurrentDominionId(@NotNull Player player);

    /**
     * Retrieves the total count of dominions.
     * <p>
     * This method calculates the total number of dominions by summing the count of dominions on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of dominions
     */
    public abstract Integer dominionCount();

    /**
     * Retrieves the total count of groups.
     * <p>
     * This method calculates the total number of groups by summing the count of groups on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of groups
     */
    public abstract Integer groupCount();

    /**
     * Retrieves the total count of members.
     * <p>
     * This method calculates the total number of members by summing the count of members on this server and, if
     * multi-servers mode is enabled, the counts from other servers.
     *
     * @return the total count of members
     */
    public abstract Integer memberCount();

    /**
     * Checks if the specified player has the specified privilege flag in the given dominion.
     *
     * @param dom    the dominion to check
     * @param flag   the privilege flag to check
     * @param player the player to check
     * @return true if the player has the specified privilege flag, false otherwise
     */
    public abstract boolean checkPrivilegeFlag(DominionDTO dom, PriFlag flag, Player player);

    /**
     * Checks if the specified environment flag is set in the given dominion.
     *
     * @param dom  the dominion to check, or null to check the global environment
     * @param flag the environment flag to check
     * @return true if the environment flag is set, false otherwise
     */
    public abstract boolean checkEnvironmentFlag(@Nullable DominionDTO dom, @NotNull EnvFlag flag);
}
