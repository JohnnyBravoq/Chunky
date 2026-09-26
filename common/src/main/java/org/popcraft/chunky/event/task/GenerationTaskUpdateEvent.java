package com.ozel.haritayukleyici.event.task;

import com.ozel.haritayukleyici.GenerationTask;
import com.ozel.haritayukleyici.event.Event;

public record GenerationTaskUpdateEvent(GenerationTask generationTask) implements Event {
}
