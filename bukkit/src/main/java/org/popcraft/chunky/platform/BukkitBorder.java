package com.ozel.haritayukleyici.platform;

import org.bukkit.WorldBorder;
import com.ozel.haritayukleyici.platform.util.Vector2;
import com.ozel.haritayukleyici.shape.ShapeType;

public class BukkitBorder implements Border {
    final WorldBorder worldBorder;

    public BukkitBorder(final WorldBorder worldBorder) {
        this.worldBorder = worldBorder;
    }

    @Override
    public Vector2 getCenter() {
        return Vector2.of(worldBorder.getCenter().getX(), worldBorder.getCenter().getZ());
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
