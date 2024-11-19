## 1. 基本功能介绍

### 1.1 主要功能

- 可以屏蔽任何应用中的按钮、广告、提示框等界面元素
- 支持长按选择要屏蔽的界面元素
- 可以查看和管理已经屏蔽的规则
- 支持备份和恢复屏蔽规则

### 1.2 使用条件

- 需要一个已经root的Android设备
- 需要安装Xposed框架(LSPosed/EdXposed等)
- Android版本要求：Android 5.0 (API 21) 及以上

## 2. 使用步骤

### 2.1 安装配置

1. 在已root设备上安装Xposed框架
2. 安装本模块APK
3. 在Xposed管理器中激活本模块
4. 重启设备

### 2.2 开始使用

1. 打开需要修改的目标应用
2. 从通知栏下拉，点击"上帝模式"通知开启编辑模式
3. 长按想要屏蔽的界面元素
4. 点击确认按钮完成屏蔽

### 2.3 管理规则

1. 打开模块主界面
2. 可以查看所有已屏蔽的规则
3. 支持删除或恢复已屏蔽的元素
4. 可以备份当前的所有规则

## 3. 特别说明

### 3.1 权限说明

- 模块需要一些权限

### 3.2 注意事项

- 首次使用时需要授予存储权限
- 某些系统可能需要额外授予通知权限
- 如果目标应用更新可能会导致规则失效
- 建议定期备份规则

### 3.3 错误处理

- 如果遇到问题，模块会自动收集错误日志

## 4. 高级功能

### 4.1 规则备份与恢复

- 可以导出所有规则到外部存储
- 支持从备份文件恢复规则
- 支持清除所有规则

### 4.2 界面定制

- 可以隐藏/显示桌面图标
- 可以调整选择器面板位置
- 支持查看组件ID信息

## 5. 项目结构

### 5.1 目录结构

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

### 5.2 核心文件说明

#### 5.2.1 应用配置文件

- `app/build.gradle`: 定义应用的构建配置
  - 应用ID: com.viewblocker.jrsen
  - 最低SDK: 21
  - 目标SDK: 34

#### 5.2.2 主要源代码文件

- `GodModeApplication.java`: 应用入口类
- `GodModeInjector.java`: Xposed模块主注入器
- `GodModeManagerService.java`: 核心服务类

#### 5.2.3 资源文件

- `values/strings.xml`: 中文字符串资源
- `values-en/strings.xml`: 英文字符串资源
- `xml/file_paths.xml`: 文件路径配置
- `xml/pref_general.xml`: 通用设置界面配置

#### 5.2.4 构建配置

- 使用 Gradle 7.4.2
- 支持 AndroidX
- 使用 Java 11
- 集成了多个重要依赖，如 Navigation 组件等