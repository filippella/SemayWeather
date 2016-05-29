package org.dalol.semayweather.di.modules;

import org.dalol.config.ApiEndPoint;
import org.dalol.semayweather.di.CustomScope;
import org.dalol.weather.service.WeatherApiEndPoint;
import org.dalol.weather.service.WeatherService;
import org.dalol.weather.service.WeatherServiceImpl;
import org.dalol.weather.api.WeatherApi;
import org.dalol.weather.WeatherPresenter;
import org.dalol.weather.WeatherPresenterImpl;
import org.dalol.weather.WeatherView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
@Module
public class WeatherModule {

    private WeatherView mView;

    public WeatherModule(WeatherView mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    WeatherView provideView() {
        return mView;
    }

    @Provides
    @CustomScope
    WeatherService provideService(WeatherServiceImpl service) {
        return service;
    }

    @Provides
    @CustomScope
    WeatherPresenter providePresenter(WeatherPresenterImpl presenter) { return presenter;  }

    @Provides
    @CustomScope
    WeatherApi provideWeatherApi(Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }

    @Provides
    @CustomScope
    ApiEndPoint provideEndPoint(WeatherApiEndPoint endPoint) { return endPoint; }
}
