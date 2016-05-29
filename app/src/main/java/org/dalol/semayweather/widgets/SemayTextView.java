package org.dalol.semayweather.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class SemayTextView extends TextView {

    public SemayTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public SemayTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        applyCustomFont(context);
    }

    public SemayTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        //Typeface customFont = FontCache.getTypeface("SourceSansPro-Regular.ttf", context);
        //setTypeface(customFont);
    }
}