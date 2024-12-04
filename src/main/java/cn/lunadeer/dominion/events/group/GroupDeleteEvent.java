package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 权限组移除事件
 * <p>
 * 当权限组移除时触发
 */
public class GroupDeleteEvent extends ResultEvent {

    private DominionDTO dominion;
    private GroupDTO group;

    /**
     * 构造权限组移除事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param group    权限组
     */
    public GroupDeleteEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group) {
        super(operator);
        this.dominion = dominion;
        this.group = group;
    }

    /**
     * 设置领地
     *
     * @param dominion 领地
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

    /**
     * 获取领地
     *
     * @return 领地
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * 设置权限组
     *
     * @param group 权限组
     */
    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    /**
     * 获取权限组
     *
     * @return 权限组
     */
    public @NotNull GroupDTO getGroup() {
        return group;
    }
}
