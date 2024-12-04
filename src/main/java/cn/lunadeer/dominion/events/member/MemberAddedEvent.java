package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 成员添加事件
 * <p>
 * 当玩家添加成员时触发
 * 添加成功后可以通过 {@link #getMember()} 获取新添加的成员
 * 如果添加失败则 {@link #getMember()} 返回null
 */
public class MemberAddedEvent extends ResultEvent {
    private DominionDTO dominion;
    private PlayerDTO player;
    private MemberDTO member = null;

    public MemberAddedEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull PlayerDTO player) {
        super(operator);
        this.dominion = dominion;
        this.player = player;
    }

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

    public void setPlayer(@NotNull PlayerDTO player) {
        this.player = player;
    }

    /**
     * 获取玩家
     *
     * @return 玩家
     */
    public @NotNull PlayerDTO getPlayer() {
        return player;
    }

    /**
     * 设置新添加的成员
     *
     * @param member 新添加的成员
     */
    public void setMember(@Nullable MemberDTO member) {
        this.member = member;
    }

    /**
     * 获取新添加的成员，如果没有则返回null，只有添加成功后才会有值
     *
     * @return 新添加的成员
     */
    public @Nullable MemberDTO getMember() {
        return member;
    }
}
