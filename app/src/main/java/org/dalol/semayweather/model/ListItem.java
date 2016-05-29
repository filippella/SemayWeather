package org.dalol.semayweather.model;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class ListItem {
    public String name, place;
    public int logo;

    public void setData(String name, String place, int logo) {
        this.name = name;
        this.place = place;
        this.logo = logo;
    }
}