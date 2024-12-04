package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import cn.lunadeer.minecraftpluginutils.ColorParser;
import org.jetbrains.annotations.NotNull;

public class GroupRenamedEvent extends ResultEvent {

    private GroupDTO groupBefore;
    private String newName;
    private GroupDTO groupAfter = null;


    public GroupRenamedEvent(@NotNull AbstractOperator operator, @NotNull GroupDTO group, @NotNull String newName) {
        super(operator);
        this.groupBefore = group;
        this.newName = newName;
    }

    public @NotNull GroupDTO getGroupBefore() {
        return groupBefore;
    }

    public String getNewNameColored() {
        return newName;
    }

    public String getNewNamePlain() {
        return ColorParser.getPlainText(newName);
    }

    public @NotNull GroupDTO getGroupAfter() {
        return groupAfter;
    }

    public void setGroupAfter(@NotNull GroupDTO groupAfter) {
        this.groupAfter = groupAfter;
    }

    public void setNewNameColored(String newName) {
        this.newName = newName;
    }

    public void setGroupBefore(@NotNull GroupDTO groupBefore) {
        this.groupBefore = groupBefore;
    }
}
