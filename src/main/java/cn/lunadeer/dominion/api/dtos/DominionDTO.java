package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.EnvFlag;
import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface DominionDTO {
    /**
     * 获取领地 ID
     *
     * @return 领地 ID
     */
    @NotNull Integer getId();

    /**
     * 获取领地所有者 UUID
     *
     * @return 领地所有者 UUID
     */
    @NotNull UUID getOwner();

    /**
     * 获取领地所有者 DTO
     *
     * @return 领地所有者 DTO
     */
    @NotNull PlayerDTO getOwnerDTO();

    /**
     * 设置领地所有者，设置成功后返回领地对象，设置失败返回null
     *
     * @param owner 领地所有者 UUID
     * @return 领地对象
     */
    @NotNull DominionDTO setOwner(UUID owner) throws SQLException;

    /**
     * 设置领地所有者，设置成功后返回领地对象，设置失败返回null
     *
     * @param owner 领地所有者
     * @return 领地对象
     */
    @NotNull DominionDTO setOwner(Player owner) throws SQLException;

    /**
     * 获取领地名称
     *
     * @return 领地名称
     */
    @NotNull String getName();

    /**
     * 设置领地名称，设置成功后返回领地对象，设置失败返回null
     *
     * @param name 领地名称
     * @return 领地对象
     */
    @NotNull DominionDTO setName(String name) throws SQLException;

    /**
     * 获取领地所在世界，如果世界不存在，则返回null
     *
     * @return 领地所在世界
     */
    @Nullable World getWorld();

    /**
     * 获取领地所在世界 UUID，该接口返回的 UUID 一定不为 null，但是不保证世界一定存在。
     * 如果需要判断世界是否存在，请使用 {@link #getWorld()} 方法。
     *
     * @return 领地所在世界 UUID
     */
    @NotNull UUID getWorldUid();

    /**
     * 获取领地范围
     * @return 领地范围
     */
    @NotNull CuboidDTO getCuboid();

    /**
     * 设置领地范围，设置成功后返回领地对象，设置失败返回null
     * @return 领地对象
     */
    @NotNull DominionDTO setCuboid(@NotNull CuboidDTO cuboid) throws SQLException;

    /**
     * 获取父领地 ID
     *
     * @return 父领地 ID  如果没有父领地，则返回 -1
     */
    @NotNull Integer getParentDomId();

    /**
     * 获取领地欢迎提示语
     *
     * @return 领地欢迎提示语
     */
    @NotNull String getJoinMessage();

    /**
     * 设置领地欢迎提示语，设置成功后返回领地对象，设置失败返回null
     *
     * @param joinMessage 领地欢迎提示语
     * @return 领地对象
     */
    @NotNull DominionDTO setJoinMessage(String joinMessage) throws SQLException;

    /**
     * 获取领地离开提示语
     *
     * @return 领地离开提示语
     */
    @NotNull String getLeaveMessage();

    /**
     * 设置领地离开提示语，设置成功后返回领地对象，设置失败返回null
     *
     * @param leaveMessage 领地离开提示语
     * @return 领地对象
     */
    @NotNull DominionDTO setLeaveMessage(String leaveMessage) throws SQLException;

    /**
     * 获取领地所有环境配置
     *
     * @return 领地环境权限配置
     */
    @NotNull Map<EnvFlag, Boolean> getEnvironmentFlagValue();

    /**
     * 获取领地某个环境配置的值
     *
     * @param flag 权限
     * @return 权限值
     */
    boolean getEnvFlagValue(@NotNull EnvFlag flag);

    /**
     * 获取领地访客所有权限配置
     *
     * @return 领地访客权限配置
     */
    @NotNull Map<PriFlag, Boolean> getGuestPrivilegeFlagValue();

    /**
     * 获取领地某个访客权限的值
     *
     * @param flag 权限
     * @return 权限值
     */
    boolean getGuestFlagValue(@NotNull PriFlag flag);

    /**
     * 设置领地某个环境配置或访客权限的值，设置成功后返回领地对象，设置失败返回null
     *
     * @param flag  权限
     * @param value 权限值
     * @return 领地对象
     */
    @NotNull DominionDTO setEnvFlagValue(@NotNull EnvFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * 设置领地某个环境配置或访客权限的值，设置成功后返回领地对象，设置失败返回null
     *
     * @param flag  权限
     * @param value 权限值
     * @return 领地对象
     */
    @NotNull DominionDTO setGuestFlagValue(@NotNull PriFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * 获取领地传送点坐标
     *
     * @return 领地传送点坐标  如果没有设置传送点，则返回领地中心坐标
     */
    @NotNull Location getTpLocation();

    /**
     * 设置领地传送点坐标，设置成功后返回领地对象，设置失败返回null
     *
     * @param tpLocation 领地传送点坐标
     * @return 领地对象
     */
    @NotNull DominionDTO setTpLocation(Location tpLocation) throws SQLException;

    int getColorR();

    int getColorG();

    int getColorB();

    @NotNull String getColor();

    int getColorHex();

    /**
     * 设置领地颜色，设置成功后返回领地对象，设置失败返回null
     *
     * @param color 颜色
     * @return 领地对象
     */
    @NotNull DominionDTO setColor(@NotNull Color color) throws SQLException;

    /**
     * 获取领地的所有权限组
     *
     * @return 权限组列表
     */
    List<GroupDTO> getGroups();

    /**
     * 获取领地的所有成员
     *
     * @return 成员列表
     */
    List<MemberDTO> getMembers();

    Integer getServerId();
}
