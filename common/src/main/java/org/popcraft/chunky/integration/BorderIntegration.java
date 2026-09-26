package com.ozel.haritayukleyici.integration;

import com.ozel.haritayukleyici.platform.Border;

public interface BorderIntegration extends Integration {
    boolean hasBorder(String world);

    Border getBorder(String world);
}
