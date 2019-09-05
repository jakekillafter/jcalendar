package com.toedter.calendar;

import org.junit.Test;

import javax.swing.JSpinner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static java.util.Calendar.getInstance;
import static org.junit.Assert.assertEquals;

/**
 * @author Luis Miranda
 */
public class JSpinnerDateEditorTimeZoneTest {
    /**
     * The date format string used for testing.
     */
    private final String dateFormatString = "yyyy/MM/dd HH:mm:ss";

    @Test
    public void testDefaultTimeZone() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatString);

        JSpinnerDateEditor editor = new JSpinnerDateEditor();
        editor.setDateFormatString(dateFormatString);
        editor.setDate(now);
        assertEquals(formatter.format(now), ((JSpinner.DateEditor) editor.getEditor()).getTextField().getText());
    }

    @Test
    public void testDifferentTimeZones() throws ParseException {
        // parse the GMT+1 date
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormatString);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        final Date testDate = formatter.parse("2009/12/25 22:00:00");

        // test that display is in GMT
        JSpinnerDateEditor editor = new JSpinnerDateEditor();
        editor.setDateFormatString(dateFormatString);
        editor.setDateFormatCalendar(getInstance(TimeZone.getTimeZone("GMT")));
        editor.setDate(testDate);
        assertEquals("2009/12/25 21:00:00", ((JSpinner.DateEditor) editor.getEditor()).getTextField().getText());
    }
}