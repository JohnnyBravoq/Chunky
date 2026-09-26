package com.ozel.haritayukleyici.platform;

import com.ozel.haritayukleyici.platform.util.Vector2;

public interface Border {
    Vector2 getCenter();

    double getRadiusX();

    double getRadiusZ();

    String getShape();
}
