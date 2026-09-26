package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.GenerationTask;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.platform.World;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;
import java.util.Map;

public class ProgressCommand implements ChunkyCommand {
    private final Chunky chunky;

    public ProgressCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        final Map<String, GenerationTask> generationTasks = chunky.getGenerationTasks();
        if (generationTasks.isEmpty()) {
            sender.sendMessagePrefixed(TranslationKey.FORMAT_PROGRESS_NO_TASKS);
            return;
        }
        for (World world : chunky.getServer().getWorlds()) {
            if (generationTasks.containsKey(world.getName())) {
                generationTasks.get(world.getName()).getProgress().sendUpdate(sender);
            }
        }
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        return List.of();
    }
}
