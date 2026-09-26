package com.ozel.haritayukleyici.nbt.util;

public record ChunkPos(int x, int z) {
    public static ChunkPos of(final int x, final int z) {
        return new ChunkPos(x, z);
    }
}
