package org.dalol.semayweather.di.modules;

import org.dalol.semayweather.di.CustomScope;
import org.dalol.weather.api.WeatherApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
@Module
public class ApiModule {

    @Provides
    @CustomScope
    WeatherApi provideForcastApi(Retrofit retrofit) {
        return retrofit.create(WeatherApi.class);
    }
}
