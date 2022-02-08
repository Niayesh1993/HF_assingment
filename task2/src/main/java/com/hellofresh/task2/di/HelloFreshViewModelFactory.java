package com.hellofresh.task2.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * This class should remain java because of a issue in dagger and providing viewmodel
 * workaround: follow https://github.com/google/dagger/issues/1478
 */

public class HelloFreshViewModelFactory implements ViewModelProvider.Factory{

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @Inject
    public HelloFreshViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
        this.creators = creators;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Provider<ViewModel> provider = creators.get(modelClass);
        if (provider != null) {
            return (T) provider.get();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
