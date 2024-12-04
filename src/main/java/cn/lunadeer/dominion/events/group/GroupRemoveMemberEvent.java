package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.jetbrains.annotations.NotNull;

public class GroupRemoveMemberEvent extends ResultEvent {

    private GroupDTO group;
    private MemberDTO member;

    public GroupRemoveMemberEvent(@NotNull AbstractOperator operator, @NotNull GroupDTO group, @NotNull MemberDTO member) {
        super(operator);
        this.group = group;
        this.member = member;
    }

    public @NotNull GroupDTO getGroup() {
        return group;
    }

    public @NotNull MemberDTO getMember() {
        return member;
    }

    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }
}
