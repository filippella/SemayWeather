package org.dalol.weather;

import org.dalol.weather.model.WeatherModel;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public interface WeatherView {

    void onWeatherProvide(WeatherModel model);

    void onWeatherError(String errorMessage);
}
