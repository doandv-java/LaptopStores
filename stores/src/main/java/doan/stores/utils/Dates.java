package doan.stores.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Dates {
    /**
     * Retrieve date now
     *
     * @return {@link Date} now
     */
    public static Date now() {
        return new Date();
    }

    /**
     * parse String source to date with format pattern and time zone
     *
     * @param source   date String
     * @param format   pattern convert
     * @param timeZone time zone
     * @return the Date {@link Date}
     */
    public static Date parseExact(final String source, final String format, final TimeZone timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if (timeZone != null) {
            formatter.setTimeZone(timeZone);
        }
        formatter.setLenient(false);
        try {
            return formatter.parse(source);
        } catch (ParseException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * format Date to String with format pattern
     *
     * @param source the Date
     * @param format the pattern
     * @return the String
     */
    public static String format(final Date source, final String format) {
        return format(source, format, null);
    }

    /**
     * Format date with pattern format anf time zone
     *
     * @param source   the date String
     * @param format   the pattern
     * @param timeZone the time zone
     * @return the String
     */
    public static String format(final Date source, final String format, final TimeZone timeZone) {
        if (source == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (timeZone != null) {
            sdf.setTimeZone(timeZone);
        }
        return sdf.format(source);
    }


    /**
     * Parse string date to date in format pattern
     *
     * @param source the date String
     * @param format the pattern
     * @return the Date {@link Date}
     */
    public static Date parseExact(final String source, final String format) {
        return parseExact(source, format, null);
    }
}
