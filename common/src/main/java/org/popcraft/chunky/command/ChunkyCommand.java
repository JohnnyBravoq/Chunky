package com.ozel.haritayukleyici.command;

import com.ozel.haritayukleyici.platform.Sender;

import java.util.List;

public interface ChunkyCommand {
    void execute(Sender sender, CommandArguments arguments);

    List<String> suggestions(final CommandArguments arguments);
}
