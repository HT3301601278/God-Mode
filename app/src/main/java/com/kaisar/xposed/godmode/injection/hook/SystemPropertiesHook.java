package com.kaisar.xposed.godmode.injection.hook;


public final class SystemPropertiesHook extends ASystemPropertiesHook {

    private boolean mDebugLayout;

    @Override
    protected void beforeHookedMethod(MethodHookParam param) {
        if (check(param)&&"debug.layout".equals(param.args[0])) {
            param.setResult(true);
        }
    }
}