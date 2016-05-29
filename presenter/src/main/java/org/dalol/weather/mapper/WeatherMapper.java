package org.dalol.weather.mapper;

import org.dalol.weather.model.Weather;
import org.dalol.weather.model.WeatherResponse;
import org.dalol.weather.model.WeatherModel;

import javax.inject.Inject;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class WeatherMapper {

    @Inject
    public WeatherMapper() {
    }

    public WeatherModel map(WeatherResponse response) {
        WeatherModel weatherModel = new WeatherModel();
        Weather weather = response.getWeather()[0];
        weatherModel.setName(response.getName());
        weatherModel.setWindDegree(response.getWind().getDeg());
        weatherModel.setCountry(response.getSys().getCountry());
        return weatherModel;
    }
}
