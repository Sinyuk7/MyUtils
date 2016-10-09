package com.sinyuk.myutils.resource;

public final class StringUtils {
    private StringUtils() {
        // No instances.
    }

    public static boolean isBlank(CharSequence string) {
        return (string == null || string.toString().trim().length() == 0);
    }

    /**
     *
     * @param string
     * @param defaultString
     * @return
     */
    public static String valueOrDefault(String string, String defaultString) {
        return isBlank(string) ? defaultString : string;
    }

    /**
     * 截取
     * @param string
     * @param length
     * @return
     */
    public static String truncateAt(String string, int length) {
        return string.length() > length ? string.substring(0, length) : string;
    }

    /**
     *
     * @param string
     * @return
     */
    public static boolean ignoreBlank(CharSequence string) {
        return isBlank(string) || " ".equals(string);
    }
}
