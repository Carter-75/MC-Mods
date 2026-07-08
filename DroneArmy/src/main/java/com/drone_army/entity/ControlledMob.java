package com.drone_army.entity;

import java.util.UUID;

public interface ControlledMob {
    void setOwnerUuid(UUID uuid);

    UUID getOwnerUuid();

    void setCommandMode(CommandMode mode);

    CommandMode getCommandMode();

    boolean isControlled();

    // For recall logic
    void setControllerStackId(UUID id); // Optional, if we track which controller it came from
}
