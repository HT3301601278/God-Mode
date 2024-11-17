package com.kaisar.xposed.godmode.injection.hook;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Optional;

public final class DisplayPropertiesHook extends ASystemPropertiesHook {

    private boolean mDebugLayout;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void beforeHookedMethod(MethodHookParam param) {
        if (check(param)) {
            param.setResult(Optional.of(true));
        }
    }
}