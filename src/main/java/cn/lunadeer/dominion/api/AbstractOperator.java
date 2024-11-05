package cn.lunadeer.dominion.api;

import cn.lunadeer.minecraftpluginutils.i18n.i18n;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.*;

public abstract class AbstractOperator {

    private boolean onceFlag = false;

    public enum ResultType {
        SUCCESS,
        WARNING,
        FAILURE
    }

    private final Map<ResultType, String> header = new HashMap<>();

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

    public AbstractOperator addResultHeader(ResultType type, String message) {
        header.put(type, message);
        return this;
    }

    public AbstractOperator addResultHeader(ResultType type, String message, Object... args) {
        return addResultHeader(type, String.format(message, args));
    }

    public AbstractOperator addResultHeader(ResultType type, i18n message, Object... args) {
        return addResultHeader(type, message.trans(), args);
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

    public void completeResult(boolean once) {
        if (once && !onceFlag) {
            onceFlag = true;
            completeResult();
        }
    }

    protected Map<ResultType, List<String>> getResults() {
        return results;
    }

    protected Map<ResultType, String> getHeader() {
        return header;
    }
}
