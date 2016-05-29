package org.dalol.weather.model;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class WeatherResponse {

    private String id;
    private String dt;
    private Clouds clouds;
    private Coord coord;
    private org.dalol.weather.model.Wind wind;
    private String cod;
    private org.dalol.weather.model.Sys sys;
    private String name;
    private String base;
    private Weather[] weather;
    private org.dalol.weather.model.Rain rain;
    private org.dalol.weather.model.Main main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public org.dalol.weather.model.Wind getWind() {
        return wind;
    }

    public void setWind(org.dalol.weather.model.Wind wind) {
        this.wind = wind;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public org.dalol.weather.model.Sys getSys() {
        return sys;
    }

    public void setSys(org.dalol.weather.model.Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public org.dalol.weather.model.Rain getRain() {
        return rain;
    }

    public void setRain(org.dalol.weather.model.Rain rain) {
        this.rain = rain;
    }

    public org.dalol.weather.model.Main getMain() {
        return main;
    }

    public void setMain(org.dalol.weather.model.Main main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return "WeatherResponse [id = " + id + ", dt = " + dt + ", clouds = " + clouds + ", coord = " + coord + ", wind = " + wind + ", cod = " + cod + ", sys = " + sys + ", name = " + name + ", base = " + base + ", weather = " + weather + ", rain = " + rain + ", main = " + main + "]";
    }
}
