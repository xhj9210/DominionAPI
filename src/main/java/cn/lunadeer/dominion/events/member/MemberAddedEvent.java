package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.api.dtos.PlayerDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    public void setPlayer(@NotNull PlayerDTO player) {
        this.player = player;
    }

    public @NotNull PlayerDTO getPlayer() {
        return player;
    }

    public void setMember(@Nullable MemberDTO member) {
        this.member = member;
    }

    public @Nullable MemberDTO getMember() {
        return member;
    }
}
