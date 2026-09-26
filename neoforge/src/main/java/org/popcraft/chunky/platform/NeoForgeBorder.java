package com.ozel.haritayukleyici.platform;

import net.minecraft.world.level.border.WorldBorder;
import com.ozel.haritayukleyici.platform.util.Vector2;
import com.ozel.haritayukleyici.shape.ShapeType;

public class NeoForgeBorder implements Border {
    private final WorldBorder worldBorder;

    public NeoForgeBorder(final WorldBorder worldBorder) {
        this.worldBorder = worldBorder;
    }

    @Override
    public Vector2 getCenter() {
        return Vector2.of(worldBorder.getCenterX(), worldBorder.getCenterZ());
    }

    @Override
    public double getRadiusX() {
        return worldBorder.getSize() / 2d;
    }

    @Override
    public double getRadiusZ() {
        return worldBorder.getSize() / 2d;
    }

    @Override
    public String getShape() {
        return ShapeType.SQUARE;
    }
}
