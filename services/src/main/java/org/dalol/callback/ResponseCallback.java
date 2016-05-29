package org.dalol.callback;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 5/22/2016
 */
public interface ResponseCallback<R> {

    void onResponse(R response);

    void onError(String errorMessage);
}
