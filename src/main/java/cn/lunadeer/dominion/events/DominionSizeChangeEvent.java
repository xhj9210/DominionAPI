package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

@ApiStatus.Experimental
public class DominionSizeChangeEvent extends ResultEvent {

    public enum SizeChangeType {
        CONTRACT,
        EXPAND
    }

    private boolean skipEconomy;
    private final DominionDTO before;
    private DominionDTO after;
    private final BlockFace face;
    private final int size;
    private final SizeChangeType type;

    public DominionSizeChangeEvent(AbstractOperator operator, @NotNull DominionDTO dominion, SizeChangeType type, BlockFace face, int size) {
        super(operator);
        this.skipEconomy = false;
        this.before = dominion;
        this.face = face;
        this.size = size;
        this.type = type;
    }

    public BlockFace getFace() {
        return face;
    }

    public int getSize() {
        return size;
    }

    public void setSkipEconomy(boolean skipEconomy) {
        this.skipEconomy = skipEconomy;
    }

    public boolean isSkipEconomy() {
        return skipEconomy;
    }

    public @NotNull DominionDTO getBefore() {
        return before;
    }

    public @NotNull DominionDTO getAfter() {
        return after;
    }

    public void setAfter(@NotNull DominionDTO after) {
        this.after = after;
    }

    public SizeChangeType getType() {
        return type;
    }
}
