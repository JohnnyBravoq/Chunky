package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.util.Input;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;
import java.util.Optional;

public class QuietCommand implements ChunkyCommand {
    private final Chunky chunky;

    public QuietCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        final Optional<Integer> newQuiet = arguments.next().flatMap(Input::tryInteger);
        if (newQuiet.isEmpty()) {
            sender.sendMessage(TranslationKey.HELP_QUIET);
            return;
        }
        final int quietInterval = Math.max(0, newQuiet.get());
        chunky.getConfig().setUpdateInterval(quietInterval);
        sender.sendMessagePrefixed(TranslationKey.FORMAT_QUIET, quietInterval);
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        return List.of();
    }
}
