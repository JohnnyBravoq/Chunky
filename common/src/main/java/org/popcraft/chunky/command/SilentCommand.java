package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;

import static com.ozel.haritayukleyici.util.Translator.translate;

public class SilentCommand implements ChunkyCommand {
    private final Chunky chunky;

    public SilentCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        chunky.getConfig().setSilent(!chunky.getConfig().isSilent());
        final String status = translate(chunky.getConfig().isSilent() ? TranslationKey.ENABLED : TranslationKey.DISABLED);
        sender.sendMessagePrefixed(TranslationKey.FORMAT_SILENT, status);
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        return List.of();
    }
}
