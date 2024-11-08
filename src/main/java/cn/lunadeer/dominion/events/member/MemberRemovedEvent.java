package cn.lunadeer.dominion.events.member;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.NotNull;

public class MemberRemovedEvent extends ResultEvent {
    private DominionDTO dominion;
    private MemberDTO member;

    public MemberRemovedEvent(@NotNull AbstractOperator operator, @NotNull DominionDTO dominion, @NotNull MemberDTO member) {
        super(operator);
        this.dominion = dominion;
        this.member = member;
    }

    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }

    public @NotNull MemberDTO getMember() {
        return member;
    }
}
