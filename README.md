# 项目目录结构

```
God-Mode/
├── app/                                # 主应用模块
│   ├── build/                         # 构建输出目录
│   ├── libs/                          # 本地依赖库
│   ├── src/
│   │   └── main/
│   │       ├── aidl/                  # AIDL接口定义
│   │       │   └── com/kaisar/xposed/godmode/
│   │       │       └── IGodModeManager.aidl    # 主服务接口定义
│   │       ├── assets/                # 资源文件
│   │       │   └── xposed_init        # Xposed模块初始化配置
│   │       ├── java/                  # Java源代码
│   │       │   └── com/kaisar/xposed/godmode/
│   │       │       ├── GodModeApplication.java # 应用入口类
│   │       │       ├── fragment/      # 界面Fragment
│   │       │       ├── injection/     # 注入相关代码
│   │       │       │   ├── GodModeInjector.java  # 主注入器
│   │       │       │   ├── ViewHelper.java       # 视图工具类
│   │       │       │   └── util/      # 工具类
│   │       │       ├── service/       # 服务相关
│   │       │       │   └── GodModeManagerService.java  # 核心管理服务
│   │       │       └── util/          # 通用工具类
│   │       └── res/                   # 资源文件
│   │           ├── drawable/          # 图片资源
│   │           ├── layout/            # 布局文件
│   │           ├── values/            # 默认值资源(中文)
│   │           ├── values-en/         # 英文资源
│   │           └── xml/               # XML配置文件
│   ├── build.gradle                   # 应用模块构建配置
│   └── proguard-rules.pro             # 混淆规则配置
│
├── libxservicemanager/                # 服务管理库模块
│   ├── src/
│   │   └── main/
│   │       ├── java/                  # Java源代码
│   │       └── AndroidManifest.xml    # 模块清单文件
│   └── build.gradle                   # 库模块构建配置
│
├── gradle/                            # Gradle包装器目录
│   └── wrapper/
├── build.gradle                       # 项目级构建配置
├── settings.gradle                    # 项目设置
├── gradle.properties                  # Gradle属性配置
├── local.properties                   # 本地属性配置
├── gradlew                           # Linux/Mac构建脚本
├── gradlew.bat                       # Windows构建脚本
├── .gitignore                        # Git忽略配置
├── .gitmodules                       # Git子模块配置
├── community.json                    # 社区信息配置
└── LICENSE                          # GNU GPL v3许可证
```

# 核心文件说明

1. **应用配置文件**

- `app/build.gradle`: 定义应用的构建配置，包括:
  - 应用ID: com.viewblocker.jrsen
  - 最低SDK: 21
  - 目标SDK: 34
  - 版本号: 22
  - 版本名: 3.0.0

2. **主要源代码文件**

- `GodModeApplication.java`: 应用入口类，负责初始化应用
- `GodModeInjector.java`: Xposed模块的主注入器，处理界面修改
- `GodModeManagerService.java`: 核心服务类，管理所有跨进程通信

3. **资源文件**

- `values/strings.xml`: 中文字符串资源
- `values-en/strings.xml`: 英文字符串资源
- `xml/file_paths.xml`: 文件路径配置
- `xml/pref_general.xml`: 通用设置界面配置

4. **权限配置**
   在 `AndroidManifest.xml` 中定义了主要权限


5. **服务管理库**

- `libxservicemanager`: 独立的服务管理模块，提供基础服务支持
- 最低支持 Android 5.0 (API 21)

6. **构建配置**

- 使用 Gradle 7.4.2
- 支持 AndroidX
- 使用 Java 11
- 集成了多个重要依赖，如 Navigation 组件等