package com.ozel.haritayukleyici.platform;

import com.ozel.haritayukleyici.platform.util.Location;

import java.util.UUID;

public interface Player extends Sender {
    UUID getUUID();

    void teleport(Location location);

    void sendActionBar(String key);
}
