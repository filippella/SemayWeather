package org.dalol.semayweather.utilities;

import android.content.Context;
import android.graphics.Typeface;

import java.util.HashMap;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class FontCache {

    private static HashMap<String, Typeface> cache = new HashMap<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = cache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                return null;
            }

            cache.put(fontname, typeface);
        }

        return typeface;
    }
}
