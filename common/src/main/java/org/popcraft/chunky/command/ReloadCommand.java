package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.event.command.ReloadCommandEvent;
import com.ozel.haritayukleyici.platform.Config;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;

public class ReloadCommand implements ChunkyCommand {
    private final Chunky chunky;

    public ReloadCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        final String type = arguments.next().orElse(null);
        if ("tasks".equals(type)) {
            if (!chunky.getGenerationTasks().isEmpty()) {
                sender.sendMessagePrefixed(TranslationKey.FORMAT_RELOAD_TASKS_RUNNING);
                return;
            }
            chunky.getTaskLoader().reload();
        } else {
            final Config config = chunky.getServer().getConfig();
            config.reload();
            chunky.setLanguage(config.getLanguage());
            chunky.getEventBus().call(new ReloadCommandEvent());
        }
        sender.sendMessagePrefixed(TranslationKey.FORMAT_RELOAD);
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        if (arguments.size() == 1) {
            return List.of("config", "tasks");
        }
        return List.of();
    }
}
