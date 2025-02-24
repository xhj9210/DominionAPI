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
     * Retrieves all dominions.
     *
     * @return a list of all dominions
     */
    public abstract @NotNull List<DominionDTO> getAllDominions();

    /**
     * Retrieves the current dominion of the specified player.
     *
     * @param player the player whose current dominion is to be retrieved
     * @return the current dominion of the player, or null if the player has no current dominion
     */
    public abstract @Nullable DominionDTO getPlayerCurrentDominion(@NotNull Player player);

    /**
     * Retrieves the dominion at the specified location.
     *
     * @param loc the location to check for a dominion
     * @return the dominion at the specified location, or null if no dominion exists at that location
     */
    public abstract @Nullable DominionDTO getDominionByLoc(@NotNull Location loc);

    /**
     * Retrieves the group with the specified ID.
     *
     * @param id the ID of the group to retrieve
     * @return the group with the specified ID, or null if no such group exists
     */
    public abstract @Nullable GroupDTO getGroup(@NotNull Integer id);

    public abstract @Nullable List<GroupDTO> getGroups(@NotNull DominionDTO dominion);

    /**
     * Retrieves the member information for the specified player and dominion.
     *
     * @param player   the player whose member information is to be retrieved
     * @param dominion the dominion to check for the player's membership
     * @return the member information for the player in the specified dominion, or null if the player is not a member
     */
    public abstract @Nullable MemberDTO getMember(@NotNull Player player, @NotNull DominionDTO dominion);

    /**
     * Retrieves the member information for the specified player UUID and dominion.
     *
     * @param player_uuid the UUID of the player whose member information is to be retrieved
     * @param dominion    the dominion to check for the player's membership
     * @return the member information for the player in the specified dominion, or null if the player is not a member
     */
    public abstract @Nullable MemberDTO getMember(@NotNull UUID player_uuid, @NotNull DominionDTO dominion);

    public abstract @Nullable List<MemberDTO> getMembers(@NotNull DominionDTO dominion);

    /**
     * Retrieves the dominion with the specified ID.
     *
     * @param id the ID of the dominion to retrieve
     * @return the dominion with the specified ID, or null if no such dominion exists
     */
    public abstract @Nullable DominionDTO getDominion(@NotNull Integer id);

    /**
     * Retrieves the dominion with the specified name.
     *
     * @param name the name of the dominion to retrieve
     * @return the dominion with the specified name, or null if no such dominion exists
     */
    public abstract @Nullable DominionDTO getDominion(@NotNull String name);

    /**
     * Retrieves the group title used by the player with the specified UUID.
     *
     * @param uuid the UUID of the player
     * @return the group title used by the player, or null if the player is not using any group title
     */
    public abstract @Nullable GroupDTO getPlayerUsingGroupTitle(@NotNull UUID uuid);

    /**
     * Retrieves the player data transfer object (DTO) for the player with the specified UUID.
     *
     * @param uuid the UUID of the player
     * @return the player DTO for the player, or null if no such player exists
     */
    public abstract @Nullable PlayerDTO getPlayerDTO(UUID uuid);

    /**
     * Retrieves the player data transfer object (DTO) for the player with the specified name.
     *
     * @param name the name of the player
     * @return the player DTO for the player, or null if no such player exists
     */
    public abstract @Nullable PlayerDTO getPlayerDTO(String name);

    /**
     * Retrieves all dominions owned by the player with the specified UUID.
     * <p>
     * Includes dominions on all servers.
     *
     * @param playerUid the UUID of the player
     * @return a list of all dominions owned by the player
     */
    public abstract List<DominionDTO> getDominionsOf(@NotNull UUID playerUid);

    /**
     * Retrieves all child dominions of the specified parent dominion.
     *
     * @param parent the parent dominion
     * @return a list of all child dominions of the parent dominion
     */
    public abstract List<DominionDTO> getChildrenDominionsOf(@NotNull DominionDTO parent);

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
