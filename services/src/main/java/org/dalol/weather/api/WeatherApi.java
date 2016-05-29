package org.dalol.weather.api;

import org.dalol.weather.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public interface WeatherApi {

    @GET("/data/2.5/weather")
    Call<WeatherResponse> getWeather(@Query("q") String where, @Query("appid") String appId);
}
