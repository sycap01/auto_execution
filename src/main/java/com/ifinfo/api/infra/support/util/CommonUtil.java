package com.ifinfo.api.infra.support.util;

import java.math.BigDecimal;

public class CommonUtil {

    public static boolean isNullOrBlank(String obj) {

        return obj == null || obj.isBlank();
    }

    public static boolean isNullOrZero(BigDecimal obj) {

        return obj == null || obj.compareTo(BigDecimal.ZERO) == 0;
    }

    public static boolean isNullOrZero(Long obj) {

        return obj == null || obj == 0;
    }
}
