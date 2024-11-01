package cn.lunadeer.dominion.api;

import cn.lunadeer.minecraftpluginutils.i18n.i18n;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractOperator {

    public enum ResultType {
        SUCCESS,
        WARNING,
        FAILURE
    }

    private final Map<ResultType, List<String>> results = Map.of(
            ResultType.SUCCESS, new ArrayList<>(),
            ResultType.WARNING, new ArrayList<>(),
            ResultType.FAILURE, new ArrayList<>()
    );

    public AbstractOperator addResult(ResultType type, String message) {
        results.get(type).add(message);
        return this;
    }

    public AbstractOperator addResult(ResultType type, String message, Object... args) {
        return addResult(type, String.format(message, args));
    }

    public AbstractOperator addResult(ResultType type, i18n message, Object... args) {
        return addResult(type, message.trans(), args);
    }

    public UUID getUniqueId() {
        return UUID.randomUUID();
    }

    public boolean isOp() {
        return false;
    }

    @Nullable
    public Location getLocation() {
        return null;
    }

    @Nullable
    public Player getPlayer() {
        return null;
    }

    @Nullable
    public BlockFace getDirection() {
        return null;
    }

    public void completeResult() {
    }

    protected Map<ResultType, List<String>> getResults() {
        return results;
    }
}
