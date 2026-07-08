# Templates

个人项目脚手架合集,用于快速启动新项目,避免每次从零搭建重复的基础配置(依赖引入、全局异常处理、统一返回格式等)。

## 目录结构

```
templates/
└── spring-boot-basic/     # Java Spring Boot 后端模板
```

后续会陆续加入前端(Vue3)、移动端(Flutter)等模板。

---

## spring-boot-basic

一个开箱即用的 Spring Boot 后端脚手架,包含常见企业级项目的基础配置和工程化实践。

### 技术栈

| 组件 | 版本/说明 |
|---|---|
| JDK | 21 |
| Spring Boot | 4.x |
| 构建工具 | Maven |
| ORM | MyBatis |
| 数据库 | MySQL |
| 缓存 | Redis |
| 消息队列 | RabbitMQ |
| 工具库 | Lombok |

### 已包含的功能

- ✅ 统一返回格式封装(`Result<T>`)
- ✅ 全局异常处理(`@RestControllerAdvice`)
- ✅ 参数校验(`@Valid` + Jakarta Validation)
- ✅ MyBatis 基础配置(Mapper 扫描、下划线转驼峰)
- ✅ 多环境配置(`application-dev.yml` / `application-prod.yml`)
- ✅ Redis 基础连接配置
- ✅ RabbitMQ 基础连接配置

### 快速开始

1. 克隆本仓库到本地
   ```bash
   git clone https://github.com/07XYGIN/templates.git
   ```

2. 复制 `spring-boot-basic` 文件夹到你的新项目目录

3. 修改包名(在 IDEA 中右键包名 → Refactor → Rename,批量替换 `com.example` 为你的包名)

4. 修改 `pom.xml` 中的 `groupId`、`artifactId`、`name`

5. 修改 `application-dev.yml` 中的数据库、Redis 连接信息

6. 启动项目,验证基础接口是否正常返回

### 目录说明

```
spring-boot-basic/
├── src/main/java/xxx/
│   ├── controller/          # 控制层
│   ├── service/             # 业务逻辑层
│   ├── mapper/               # MyBatis Mapper 接口
│   ├── dto/                  # 数据传输对象
│   ├── common/
│   │   ├── result/           # 统一返回格式
│   │   └── exception/        # 全局异常处理
├── src/main/resources/
│   ├── mapper/                # MyBatis XML 文件
│   ├── application.yml
│   ├── application-dev.yml
│   └── application-prod.yml
└── pom.xml
```

---

## License

本仓库代码基于 [MIT License](https://opensource.org/licenses/MIT) 开源,可自由使用、修改。