package org.dalol.weather.service;

import org.dalol.config.ApiEndPoint;

import javax.inject.Inject;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class WeatherApiEndPoint implements ApiEndPoint {

    @Inject
    public WeatherApiEndPoint() {
    }

    @Override
    public String getBaseUrl() {
        return "http://api.openweathermap.org";
    }

    @Override
    public String getAppKey() {
        return "c4de2422dc8eeae4be82b2a39ff405f3";
    }
}
