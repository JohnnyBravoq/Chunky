package com.ozel.haritayukleyici.shape;

import com.ozel.haritayukleyici.Selection;
import com.ozel.haritayukleyici.platform.util.Vector2;

import java.util.List;

public abstract class AbstractPolygon extends AbstractShape {
    protected AbstractPolygon(final Selection selection, final boolean chunkAligned) {
        super(selection, chunkAligned);
    }

    public abstract List<Vector2> points();
}
