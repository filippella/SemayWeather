package org.dalol.semayweather.di.components;

import org.dalol.semayweather.di.modules.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
@Singleton
@Component(modules = NetModule.class)
public interface NetworkComponent {

    Retrofit retrofit();
}
