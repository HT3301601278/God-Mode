package com.kaisar.xposed.godmode.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.kaisar.xposed.godmode.injection.util.Logger;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

public class PermissionHelper {
    private static final String TAG = "PermissionHelper";
    private static final int REQUEST_PERMISSION_CODE = 100;
    private final WeakReference<Activity> mActivityReference;

    public PermissionHelper(Activity activity) {
        mActivityReference = new WeakReference<>(activity);
    }

    public void applyPermissions(String... permissions) {
        try {
            Activity activity = Objects.requireNonNull(mActivityReference.get(), "Activity can't be null");
            ArrayList<String> unauthorizedPermissionList = new ArrayList<>();
            
            // 检查通知权限
            if (Build.VERSION.SDK_INT >= 33) { // TIRAMISU
                if (ContextCompat.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") 
                    != PackageManager.PERMISSION_GRANTED) {
                    unauthorizedPermissionList.add("android.permission.POST_NOTIFICATIONS");
                }
            }
            
            // 检查存储权限
            if (Build.VERSION.SDK_INT >= 33) { // TIRAMISU
                if (ContextCompat.checkSelfPermission(activity, "android.permission.READ_MEDIA_IMAGES") 
                    != PackageManager.PERMISSION_GRANTED) {
                    unauthorizedPermissionList.add("android.permission.READ_MEDIA_IMAGES");
                }
            } else if (Build.VERSION.SDK_INT <= 29) { // Q
                if (ContextCompat.checkSelfPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE") 
                    != PackageManager.PERMISSION_GRANTED) {
                    unauthorizedPermissionList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                }
            }
            
            // 检查其他权限
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                    unauthorizedPermissionList.add(permission);
                }
            }
            
            if (!unauthorizedPermissionList.isEmpty()) {
                ActivityCompat.requestPermissions(activity, 
                    unauthorizedPermissionList.toArray(new String[0]), 
                    REQUEST_PERMISSION_CODE);
            }
        } catch (Throwable e) {
            Logger.e(TAG, e.getMessage(), e);
        }
    }

    public boolean checkSelfPermission(String permission) {
        Activity activity = Objects.requireNonNull(mActivityReference.get(), "Activity can't be null");
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED;
    }

}
