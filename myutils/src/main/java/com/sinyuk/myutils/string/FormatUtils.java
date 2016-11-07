package com.sinyuk.myutils.string;

import android.text.TextUtils;

import java.text.DecimalFormat;

/**
 * Created by Sinyuk on 16/8/7.
 */
public class FormatUtils {

    private FormatUtils() {
        throw new AssertionError("can't access a private constructor");
    }

    public static String shortenNumber(CharSequence sequence) {
        if (!TextUtils.isEmpty(sequence)) {
            int length = sequence.length();
            String suffix = "";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (sequence.charAt(i) < '0' || sequence.charAt(i) > '9') {
                    throw new IllegalArgumentException("Must only have numbers");
                }
            }
            int invalidLength = 0;

            if (length >= 9) {
                invalidLength = 8;
                suffix = "bn";
            } else if (length >= 7) {
                invalidLength = 6;
                suffix = "m";
            } else if (length > 4) {
                invalidLength = 3;
                suffix = "k";
            }
            for (int i = 0; i < (length - invalidLength); i++) {
                sb.append(sequence.charAt(i));
            }
            if (invalidLength > 0) {
                sb.append('.');
                sb.append(sequence.charAt(length - invalidLength));
            }

            sb.append(suffix);
            return sb.toString();
        }
        return null;
    }


    /**
     * 给价格加上逗号分隔和rmb符号
     *
     * @param unFormatted
     * @return
     */
    public static String formatPrice(String unFormatted) {
        final String prefix = "";

        String formatted = null;
        try {

            int price;
            DecimalFormat formatter = new DecimalFormat("#,###");
            if (unFormatted.contains(".")) {
                String[] split = unFormatted.split("\\.", 2);
                try {
                    price = Integer.parseInt(split[0]);
                    formatted = prefix + formatter.format(price);

                } catch (ArrayIndexOutOfBoundsException exception) {
                    exception.printStackTrace();
                }

            } else {

                price = Integer.parseInt(unFormatted);
                formatted = prefix + formatter.format(price);

            }
            if (formatted == null)
                formatted = prefix + unFormatted;


        } catch (NumberFormatException exception) {
            exception.printStackTrace();

        }
        return "¥" + formatted;
    }
}
