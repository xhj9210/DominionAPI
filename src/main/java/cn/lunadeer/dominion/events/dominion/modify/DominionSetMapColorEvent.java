package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.Color;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * Event that handles setting the map color of a dominion.
 */
public class DominionSetMapColorEvent extends DominionModifyEvent {

    private final Color oldColor;
    private Color newColor;

    /**
     * Constructs a new DominionSetMapColorEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion whose map color is being set
     * @param newColor the new color to set for the dominion
     */
    public DominionSetMapColorEvent(@NotNull CommandSender operator,
                                    @NotNull DominionDTO dominion,
                                    @NotNull Color newColor) {
        super(operator, dominion);
        this.oldColor = Color.fromRGB(dominion.getColorR(), dominion.getColorG(), dominion.getColorB());
        this.newColor = newColor;
    }

    /**
     * Gets the old color of the dominion.
     *
     * @return the old color
     */
    public @NotNull Color getOldColor() {
        return oldColor;
    }

    /**
     * Sets the new color for the dominion.
     *
     * @param newColor the new color to set
     */
    public void setNewColor(@NotNull Color newColor) {
        this.newColor = newColor;
    }

    /**
     * Gets the new color of the dominion.
     *
     * @return the new color
     */
    public @NotNull Color getNewColor() {
        return newColor;
    }
}