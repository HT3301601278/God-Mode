# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/software/android-sdk-linux/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-keep class com.kaisar.xposed.godmode.injection.GodModeInjector{*;}

# 保留所有注解
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable
-keepattributes Exceptions,InnerClasses

# 保留序列化相关
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# 保留 Parcelable
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# 保留所有实现了 IXposedHookLoadPackage 接口的类
-keep class * implements de.robv.android.xposed.IXposedHookLoadPackage {
    public void handleLoadPackage(...);
}

# 保留所有实现了 IXposedHookZygoteInit 接口的类 
-keep class * implements de.robv.android.xposed.IXposedHookZygoteInit {
    public void initZygote(...);
}

# 保留 GodMode 相关的所有类
-keep class com.kaisar.xposed.godmode.** {*;}
-keep class com.kaisar.xposed.godmode.injection.** {*;}
-keep class com.kaisar.xposed.godmode.rule.** {*;}
-keep class com.kaisar.xposed.godmode.service.** {*;}
-keep class com.kaisar.xposed.godmode.util.** {*;}

# 保留 AIDL 接口
-keep interface com.kaisar.xposed.godmode.IGodModeManager {*;}
-keep interface com.kaisar.xposed.godmode.IObserver {*;}
-keep class com.kaisar.xposed.godmode.IGodModeManager$** {*;}
-keep class com.kaisar.xposed.godmode.IObserver$** {*;}
-keep class com.kaisar.xposed.godmode.rule.** {*;}

# 保留 View 相关
-keepclassmembers class * extends android.view.View {
   void set*(***);
   *** get*();
}

# 保留 native 方法
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保留 R 文件
-keepclassmembers class **.R$* {
    public static <fields>;
}

# 保留 Gson 相关
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }

# 保留 Xposed 相关
-keep class de.robv.android.xposed.** { *; }
-keep class android.** { *; }
-keep class com.android.** { *; }
