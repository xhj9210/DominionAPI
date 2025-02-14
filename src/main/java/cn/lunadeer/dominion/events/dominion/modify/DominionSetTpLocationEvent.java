package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DominionSetTpLocationEvent extends DominionModifyEvent {

    private final Location oldTpLocation;
    private Location newTpLocation;

    public DominionSetTpLocationEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion, @NotNull Location newTpLocation) {
        super(operator, dominion);
        this.oldTpLocation = dominion.getTpLocation();
        this.newTpLocation = newTpLocation;
    }

    public @Nullable Location getOldTpLocation() {
        return oldTpLocation;
    }

    public @NotNull Location getNewTpLocation() {
        return newTpLocation;
    }

    public void setNewTpLocation(@NotNull Location newTpLocation) {
        this.newTpLocation = newTpLocation;
    }
}
