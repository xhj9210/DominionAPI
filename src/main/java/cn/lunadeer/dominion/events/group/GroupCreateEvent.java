package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import cn.lunadeer.dominion.utils.ColorParser;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 权限组添加事件
 * <p>
 * 当权限组添加时触发
 * 添加成功后可以通过 {@link #getGroup()} 获取新添加的权限组
 * 如果添加失败则 {@link #getGroup()} 返回null
 */
public class GroupCreateEvent extends ResultEvent {

    private DominionDTO dominion;
    private String groupName;
    private GroupDTO group = null;

    public GroupCreateEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull String groupName) {
        super(operator);
        this.dominion = dominion;
        this.groupName = groupName;
    }

    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    public void setGroupNameColored(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupNameColored() {
        return groupName;
    }

    public String getGroupNamePlain() {
        return ColorParser.getPlainText(groupName);
    }

    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    /**
     * 获取新添加的权限组，如果添加失败则返回null
     *
     * @return 新添加的权限组
     */
    public @Nullable GroupDTO getGroup() {
        return group;
    }
}
