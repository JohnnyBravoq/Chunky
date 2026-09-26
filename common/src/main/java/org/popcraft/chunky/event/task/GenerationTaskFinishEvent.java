package com.ozel.haritayukleyici.event.task;

import com.ozel.haritayukleyici.GenerationTask;
import com.ozel.haritayukleyici.event.Event;

public record GenerationTaskFinishEvent(GenerationTask generationTask) implements Event {
}
