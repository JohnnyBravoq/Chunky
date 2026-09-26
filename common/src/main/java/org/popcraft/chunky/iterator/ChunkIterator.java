package com.ozel.haritayukleyici.iterator;

import com.ozel.haritayukleyici.util.ChunkCoordinate;

import java.util.Iterator;

public interface ChunkIterator extends Iterator<ChunkCoordinate> {
    long total();

    String name();

    default boolean process() {
        return true;
    }
}
