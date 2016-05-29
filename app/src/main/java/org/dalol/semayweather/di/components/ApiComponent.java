package org.dalol.semayweather.di.components;

import org.dalol.semayweather.di.CustomScope;
import org.dalol.semayweather.di.modules.ApiModule;
import org.dalol.semayweather.ui.activity.MainActivity;

import dagger.Component;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
@CustomScope
@Component(modules = ApiModule.class, dependencies = NetworkComponent.class)
public interface ApiComponent {

    //void inject(MainActivity activity);
}
