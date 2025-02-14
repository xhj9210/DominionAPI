package cn.lunadeer.dominion.api.dtos;

import cn.lunadeer.dominion.api.dtos.flag.PriFlag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public interface MemberDTO {
    /**
     * 获取成员 ID
     *
     * @return 成员 ID
     */
    Integer getId();

    /**
     * 获取成员 UUID
     *
     * @return 成员 UUID
     */
    UUID getPlayerUUID();

    /**
     * 获取成员所属领地 ID
     *
     * @return 领地 ID
     */
    Integer getDomID();

    /**
     * 获取成员所属权限组 ID
     *
     * @return 权限组 ID 如果成员不属于任何权限组，则返回-1
     */
    Integer getGroupId();

    /**
     * 获取成员某个权限配置
     *
     * @param flag 权限
     * @return 权限配置值，如果权限不存在则返回默认值
     */
    @NotNull Boolean getFlagValue(PriFlag flag);

    /**
     * 获取成员所有权限配置
     *
     * @return 权限配置值
     */
    @NotNull Map<PriFlag, Boolean> getFlagsValue();

    /**
     * 设置成员某个权限配置，设置成功后返回成员对象，设置失败返回null
     *
     * @param flag  权限
     * @param value 权限配置值
     * @return 成员对象
     */
    @Nullable MemberDTO setFlagValue(@NotNull PriFlag flag, @NotNull Boolean value) throws SQLException;

    /**
     * 获取成员对象
     *
     * @return 成员对象
     */
    @NotNull PlayerDTO getPlayer();
}
