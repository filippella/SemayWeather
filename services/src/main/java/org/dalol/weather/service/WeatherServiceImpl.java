package org.dalol.weather.service;

import org.dalol.callback.ResponseCallback;
import org.dalol.config.ApiEndPoint;
import org.dalol.weather.api.WeatherApi;
import org.dalol.weather.model.WeatherResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class WeatherServiceImpl implements WeatherService {

    @Inject WeatherApi api;
    @Inject ApiEndPoint endPoint;

    @Inject
    public WeatherServiceImpl() {
    }

    @Override
    public void getForecast(String location, final ResponseCallback callback) {
        Call<WeatherResponse> apiWeather = api.getWeather(location, endPoint.getAppKey());
        apiWeather.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                callback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}
