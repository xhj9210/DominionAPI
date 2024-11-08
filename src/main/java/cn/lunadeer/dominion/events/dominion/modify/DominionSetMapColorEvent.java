package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.Color;
import org.jetbrains.annotations.NotNull;

public class DominionSetMapColorEvent extends DominionModifyEvent {

    private final Color oldColor;
    private Color newColor;

    public DominionSetMapColorEvent(@NotNull AbstractOperator operator,
                                    @NotNull DominionDTO dominion,
                                    @NotNull Color color) {
        super(operator, dominion);
        this.oldColor = Color.fromRGB(dominion.getColorR(), dominion.getColorG(), dominion.getColorB());
        this.newColor = color;
    }

    public @NotNull Color getOldColor() {
        return oldColor;
    }

    public void setNewColor(@NotNull Color newColor) {
        this.newColor = newColor;
    }

    public @NotNull Color getNewColor() {
        return newColor;
    }
}
