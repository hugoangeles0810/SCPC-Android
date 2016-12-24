package io.github.hugoangeles0810.android.scpc.presenter;

/**
 * Created by hugo on 24/12/16.
 */

public interface Presenter<T> {
    void addView(T view);
    void removeView();
}
