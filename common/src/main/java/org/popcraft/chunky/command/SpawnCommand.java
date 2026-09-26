package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.Selection;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.util.Formatting;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;

public class SpawnCommand implements ChunkyCommand {
    private final Chunky chunky;

    public SpawnCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        chunky.getSelection().spawn();
        final Selection current = chunky.getSelection().build();
        sender.sendMessagePrefixed(TranslationKey.FORMAT_CENTER, Formatting.number(current.centerX()), Formatting.number(current.centerZ()));
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        return List.of();
    }
}
