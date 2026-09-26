package com.ozel.haritayukleyici.shape;

import com.ozel.haritayukleyici.Selection;
import com.ozel.haritayukleyici.platform.util.Vector2;

public abstract class AbstractEllipse extends AbstractShape {
    protected AbstractEllipse(final Selection selection, final boolean chunkAligned) {
        super(selection, chunkAligned);
    }

    public abstract Vector2 radii();
}
