package com.ozel.haritayukleyici.api.event.task;

import com.ozel.haritayukleyici.event.Event;

/**
 * Event which is fired when a generation task completes.
 *
 * @param world The world identifier associated with the completed task
 */
public record GenerationCompleteEvent(String world) implements Event {
}
