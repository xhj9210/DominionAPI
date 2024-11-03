package cn.lunadeer.dominion.events;

import cn.lunadeer.dominion.api.AbstractOperator;
import cn.lunadeer.dominion.api.dtos.DominionDTO;

import java.util.UUID;

public class DominionTransferEvent extends DominionEvent {

    private UUID newOwner;
    private final UUID oldOwner;

    public DominionTransferEvent(AbstractOperator operator, DominionDTO dominion, UUID newOwner) {
        super(operator, dominion);
        this.newOwner = newOwner;
        this.oldOwner = dominion.getOwner();
    }

    public UUID getNewOwner() {
        return newOwner;
    }

    public UUID getOldOwner() {
        return oldOwner;
    }

    public void setNewOwner(UUID newOwner) {
        this.newOwner = newOwner;
    }
}
