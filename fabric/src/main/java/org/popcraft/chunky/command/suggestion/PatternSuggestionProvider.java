package com.ozel.haritayukleyici.command.suggestion;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.commands.CommandSourceStack;
import com.ozel.haritayukleyici.command.CommandLiteral;
import com.ozel.haritayukleyici.iterator.PatternType;

import java.util.concurrent.CompletableFuture;

public class PatternSuggestionProvider implements SuggestionProvider<CommandSourceStack> {
    @Override
    public CompletableFuture<Suggestions> getSuggestions(final CommandContext<CommandSourceStack> context, final SuggestionsBuilder builder) {
        try {
            final String input = context.getArgument(CommandLiteral.PATTERN, String.class);
            PatternType.ALL.forEach(pattern -> {
                if (pattern.contains(input.toLowerCase())) {
                    builder.suggest(pattern);
                }
            });
        } catch (IllegalArgumentException e) {
            PatternType.ALL.forEach(builder::suggest);
        }
        return builder.buildFuture();
    }
}
