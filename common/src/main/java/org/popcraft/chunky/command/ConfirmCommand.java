package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;
import java.util.Optional;

public class ConfirmCommand implements ChunkyCommand {
    private final Chunky chunky;

    public ConfirmCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        final Optional<Runnable> pendingAction = chunky.getPendingAction(sender);
        if (pendingAction.isEmpty()) {
            sender.sendMessagePrefixed(TranslationKey.FORMAT_CONFIRM);
            return;
        }
        pendingAction.get().run();
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        return List.of();
    }
}
