package org.dalol.weather;

import org.dalol.callback.ResponseCallback;
import org.dalol.weather.service.WeatherService;
import org.dalol.weather.model.WeatherResponse;
import org.dalol.weather.mapper.WeatherMapper;
import org.dalol.weather.model.WeatherModel;

import javax.inject.Inject;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public class WeatherPresenterImpl implements WeatherPresenter {

    @Inject WeatherView mContract;
    @Inject WeatherService mService;
    @Inject WeatherMapper mMapper;

    @Inject
    public WeatherPresenterImpl() {
    }

    @Override
    public void getForecast(String location) {
        mService.getForecast(location, new ResponseCallback<WeatherResponse>() {
            @Override
            public void onResponse(WeatherResponse response) {
                mContract.onWeatherProvide(mMapper.map(response));
            }

            @Override
            public void onError(String errorMessage) {
                mContract.onWeatherError(errorMessage);
            }
        });
    }
}
