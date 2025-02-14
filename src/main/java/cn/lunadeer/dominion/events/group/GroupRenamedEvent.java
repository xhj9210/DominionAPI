package cn.lunadeer.dominion.events.group;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.api.dtos.GroupDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import cn.lunadeer.minecraftpluginutils.ColorParser;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class GroupRenamedEvent extends ResultEvent {

    private final DominionDTO dominion;
    private GroupDTO group;
    private final String oldName;
    private String newName;


    public GroupRenamedEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull GroupDTO group, @NotNull String newName) {
        super(operator);
        this.dominion = dominion;
        this.group = group;
        this.oldName = group.getNameRaw();
        this.newName = newName;
    }

    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    public @NotNull GroupDTO getGroup() {
        return group;
    }

    public void setGroup(@NotNull GroupDTO group) {
        this.group = group;
    }

    public void setNewName(@NotNull String newName) {
        this.newName = newName;
    }

    public String getNewNameColored() {
        return newName;
    }

    public String getNewNamePlain() {
        return ColorParser.getPlainText(newName);
    }

    public String getOldNameColored() {
        return oldName;
    }

    public String getOldNamePlain() {
        return ColorParser.getPlainText(oldName);
    }
}
