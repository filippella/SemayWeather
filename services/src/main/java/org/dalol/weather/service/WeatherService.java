package org.dalol.weather.service;

import org.dalol.callback.ResponseCallback;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public interface WeatherService {

    void getForecast(String location, ResponseCallback callback);
}
