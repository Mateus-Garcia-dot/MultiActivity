package com.example.multiactivity;

import android.text.InputFilter;
import android.text.Spanned;

public class MinMaxInputFilter implements InputFilter {
    private int min;
    private int max;

    public MinMaxInputFilter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean isInRange(float number) {
        return number >= this.min && number <= this.max;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            float numberParsed = Float.parseFloat(dest.subSequence(0, dstart)
                    + source.subSequence(start, end).toString()
                    + dest.subSequence(dend, dest.length()));
            if (isInRange(numberParsed)) {
                return null;
            }
        } catch (Exception ignored) {}
        return "";
    }
}
