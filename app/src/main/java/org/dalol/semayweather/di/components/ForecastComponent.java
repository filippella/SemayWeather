package org.dalol.semayweather.di.components;

import org.dalol.semayweather.di.CustomScope;
import org.dalol.semayweather.di.modules.WeatherModule;
import org.dalol.semayweather.ui.activity.MainActivity;

import dagger.Component;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
@CustomScope
@Component(modules = WeatherModule.class, dependencies = NetworkComponent.class)
public interface ForecastComponent {

    void inject(MainActivity activity);
}
