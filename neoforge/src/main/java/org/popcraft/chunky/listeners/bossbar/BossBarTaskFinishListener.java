package com.ozel.haritayukleyici.listeners.bossbar;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerBossEvent;
import com.ozel.haritayukleyici.GenerationTask;
import com.ozel.haritayukleyici.event.task.GenerationTaskFinishEvent;
import com.ozel.haritayukleyici.platform.World;

import java.util.Map;
import java.util.function.Consumer;

public class BossBarTaskFinishListener implements Consumer<GenerationTaskFinishEvent> {
    private final Map<Identifier, ServerBossEvent> bossBars;

    public BossBarTaskFinishListener(final Map<Identifier, ServerBossEvent> bossBars) {
        this.bossBars = bossBars;
    }

    @Override
    public void accept(final GenerationTaskFinishEvent event) {
        final GenerationTask task = event.generationTask();
        final World world = task.getSelection().world();
        final Identifier worldIdentifier = Identifier.tryParse(world.getKey());
        if (worldIdentifier == null) {
            return;
        }
        final ServerBossEvent bossBar = bossBars.get(worldIdentifier);
        if (bossBar != null) {
            bossBar.removeAllPlayers();
            bossBars.remove(worldIdentifier);
        }
    }
}
