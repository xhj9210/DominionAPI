package cn.lunadeer.dominion.events.dominion.modify;

import cn.lunadeer.dominion.api.dtos.DominionDTO;
import cn.lunadeer.dominion.events.ResultEvent;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Event triggered when a Dominion is modified in the Dominion system.
 */
@ApiStatus.Experimental
public class DominionModifyEvent extends ResultEvent {

    private DominionDTO dominion;
    private final CompletableFuture<DominionDTO> future = new CompletableFuture<>();

    /**
     * Constructs a new DominionModifyEvent.
     *
     * @param operator the command sender who initiated the event
     * @param dominion the dominion being modified
     */
    public DominionModifyEvent(@NotNull CommandSender operator, @NotNull DominionDTO dominion) {
        super(operator);
        this.dominion = dominion;
    }

    /**
     * Gets the CompletableFuture that will be completed with the created DominionDTO.
     * <p>
     * Under most circumstances, you should not need to use this method directly. If you
     * need to perform actions after the dominion is modified, you should use the
     * {@link #afterModified(Consumer)} method instead.
     *
     * @return the CompletableFuture to be completed
     */
    public CompletableFuture<DominionDTO> getFutureToComplete() {
        return future;
    }

    /**
     * Call back after the dominion is modified.
     * <p>
     * Use this method to perform actions after the dominion has been modified.
     *
     * @param consumer the consumer to handle the created dominion
     * @return a CompletableFuture that completes when the consumer has been executed
     */
    public CompletableFuture<Void> afterModified(Consumer<DominionDTO> consumer) {
        return future.thenAccept(consumer);
    }

    /**
     * Returns the dominion to be modified.
     * <p>
     * This method retrieves the dominion that is going to be modified by this event.
     * To get the modified dominion after the event is processed, use the
     * {@link #afterModified(Consumer)} method to register a callback.
     *
     * @return the dominion
     */
    public @NotNull DominionDTO getDominion() {
        return dominion;
    }

    /**
     * Sets the dominion to be modified.
     * <p>
     * This method can only change which dominion will be modified.
     *
     * @param dominion the dominion to set
     */
    public void setDominion(@NotNull DominionDTO dominion) {
        this.dominion = dominion;
    }

}