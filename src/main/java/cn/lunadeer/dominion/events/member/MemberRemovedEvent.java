package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * 成员移除事件
 * <p>
 * 当玩家移除成员时触发
 */
public class MemberRemovedEvent extends ResultEvent {
    private DominionDTO dominion;
    private MemberDTO member;

    /**
     * 构造成员移除事件
     *
     * @param operator 操作者
     * @param dominion 领地
     * @param member   成员
     */
    public MemberRemovedEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull MemberDTO member) {
        super(operator);
        this.dominion = dominion;
        this.member = member;
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
     * 设置成员
     *
     * @param member 成员
     */
    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    /**
     * 获取成员
     *
     * @return 成员
     */
    public @NotNull MemberDTO getMember() {
        return member;
    }
}
