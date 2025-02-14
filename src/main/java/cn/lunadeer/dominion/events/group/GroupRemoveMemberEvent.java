package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.api.dtos.MemberDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class GroupRemoveMemberEvent extends ResultEvent {

    private final DominionDTO dominion;
    private final GroupDTO group;
    private MemberDTO member;

    public GroupRemoveMemberEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group, @NotNull MemberDTO member) {
        super(operator);
        this.group = group;
        this.dominion = dominion;
        this.member = member;
    }

    public @NotNull GroupDTO getGroup() {
        return group;
    }

    public @NotNull MemberDTO getMember() {
        return member;
    }

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    public void setMember(@NotNull MemberDTO member) {
        this.member = member;
    }
}
