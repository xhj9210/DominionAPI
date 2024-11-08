package cn.lunadeer.dominion.api.dtos;

import java.util.UUID;

public interface PlayerDTO {
    Integer getId();

    UUID getUuid();

    String getLastKnownName();

    PlayerDTO updateLastKnownName(String name);

    Integer getUsingGroupTitleID();
}
