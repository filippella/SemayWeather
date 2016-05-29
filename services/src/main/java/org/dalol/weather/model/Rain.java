package org.dalol.weather.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class Rain {

    @SerializedName("3h")
    private String hour;

    public String getHour() {
        return hour;
    }

    public void set3h(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Rain [3h = " + hour + "]";
    }
}
