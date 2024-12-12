package cn.lunadeer.dominion.api;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface DominionAPI {

    /**
     * 从缓存获取所有领地信息
     *
     * @return 所有领地信息
     */
    @NotNull List<DominionDTO> getAllDominions();

    /**
     * 从缓存获取玩家当前所在领地
     *
     * @param player 玩家
     * @return 玩家当前所在领地   如果玩家不在任何领地内，则返回null
     */
    @Nullable DominionDTO getPlayerCurrentDominion(@NotNull Player player);

    /**
     * 从缓存获取指定位置的领地信息
     *
     * @param loc 位置
     * @return 领地信息    如果位置不在任何领地内，则返回null
     */
    @Nullable DominionDTO getDominionByLoc(@NotNull Location loc);

    /**
     * 从缓存根据 ID 获取权限组对象
     *
     * @param id 权限组 ID
     * @return 权限组对象    如果权限组不存在，则返回null
     */
    @Nullable GroupDTO getGroup(@NotNull Integer id);

    /**
     * 从缓存获取玩家在指定领地的成员信息
     *
     * @param player   玩家
     * @param dominion 领地
     * @return 玩家在指定领地的成员信息   如果玩家不属于领地成员，则返回null
     */
    @Nullable MemberDTO getMember(@NotNull Player player, @NotNull DominionDTO dominion);

    /**
     * 从缓存获取玩家在指定领地的成员信息
     *
     * @param player_uuid 玩家 UUID
     * @param dominion    领地
     * @return 玩家在指定领地的成员信息  如果玩家不属于领地成员，则返回null
     */
    @Nullable MemberDTO getMember(@NotNull UUID player_uuid, @NotNull DominionDTO dominion);

    /**
     * 从缓存获取指定 ID 的领地信息
     *
     * @param id 领地 ID
     * @return 领地信息   如果领地不存在，则返回null
     */
    @Nullable DominionDTO getDominion(@NotNull Integer id);

    /**
     * 从数据库获取指定名称的领地信息
     *
     * @param name 领地名称
     * @return 领地信息   如果领地不存在，则返回null
     */
    @Nullable DominionDTO getDominion(@NotNull String name);

    /**
     * 从缓存获取玩家当前正在使用的权限组称号
     *
     * @param uuid 玩家 UUID
     * @return 权限组对象    如果玩家没有使用任何权限组，则返回null
     */
    @Nullable GroupDTO getPlayerUsingGroupTitle(@NotNull UUID uuid);

    /**
     * 获取一个基于玩家的操作者对象，以用于创建领地事件。该操作者对象会模拟玩家的操作以及权限等信息。
     *
     * @param player 玩家
     * @return 操作者对象
     */
    @NotNull AbstractOperator getPlayerOperator(@NotNull Player player);

    /**
     * 获取一个基于插件的操作者对象，以用于创建领地事件。该操作者对象具备OP权限。
     *
     * @return 操作者对象
     */
    @NotNull AbstractOperator getPluginOperator();

    /**
     * 获取一个基于玩家的操作者对象。
     *
     * @param uuid 玩家 UUID
     * @return 操作者对象
     */
    @Nullable PlayerDTO getPlayerDTO(UUID uuid);

    /**
     * 获取一个基于玩家的操作者对象。
     *
     * @param name 玩家名称
     * @return 操作者对象
     */
    @Nullable PlayerDTO getPlayerDTO(String name);

    /**
     * 从数据库获取玩家拥有的领地列表
     *
     * @param playerUid 玩家 UUID
     * @return 领地列表
     */
    List<DominionDTO> getPlayerDominions(@NotNull UUID playerUid);
}
