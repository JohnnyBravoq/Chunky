package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.Chunky;
import com.ozel.haritayukleyici.platform.Sender;
import com.ozel.haritayukleyici.shape.ShapeType;
import com.ozel.haritayukleyici.util.Input;
import com.ozel.haritayukleyici.util.TranslationKey;

import java.util.List;
import java.util.Optional;

import static com.ozel.haritayukleyici.util.Translator.translate;

public class ShapeCommand implements ChunkyCommand {
    private final Chunky chunky;

    public ShapeCommand(final Chunky chunky) {
        this.chunky = chunky;
    }

    @Override
    public void execute(final Sender sender, final CommandArguments arguments) {
        final Optional<String> inputShape = arguments.next().flatMap(Input::tryShape);
        if (inputShape.isEmpty()) {
            sender.sendMessage(TranslationKey.HELP_SHAPE);
            return;
        }
        final String shape = inputShape.get();
        chunky.getSelection().shape(shape);
        sender.sendMessagePrefixed(TranslationKey.FORMAT_SHAPE, translate("shape_" + shape));
    }

    @Override
    public List<String> suggestions(final CommandArguments arguments) {
        if (arguments.size() == 1) {
            return ShapeType.all();
        }
        return List.of();
    }
}
