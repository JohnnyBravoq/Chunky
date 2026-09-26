package com.ozel.haritayukleyici.shape;

import com.ozel.haritayukleyici.Selection;
import com.ozel.haritayukleyici.platform.util.Vector2;

public class Circle extends AbstractEllipse {
    public Circle(final Selection selection, final boolean chunkAligned) {
        super(selection, chunkAligned);
    }

    @Override
    public boolean isBounding(final double x, final double z) {
        return Math.hypot(centerX - x, centerZ - z) <= radiusX;
    }

    @Override
    public String name() {
        return ShapeType.CIRCLE;
    }

    @Override
    public Vector2 radii() {
        return Vector2.of(radiusX, radiusX);
    }
}
