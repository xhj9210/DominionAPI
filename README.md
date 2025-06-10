# DominionAPI

[![Javadoc](https://img.shields.io/badge/Javadoc-Link-70f3ff?logo=readthedocs)](https://lunadeermc.github.io/DominionAPI/)
[![DemoPlugin](https://img.shields.io/badge/DemoPlugin-GitHub-blue?logo=github)](https://github.com/LunaDeerMC/DominionAddonExample)

> Since Dominion-2.9.0-beta, DominionAPI is supported.

## First: Import DominionAPI

### 1. Add Dependency

For gradle, you can add the following code to your `build.gradle` file:

```groovy
// build.gradle
repositories {
    mavenCentral()
}

dependencies {
    compileOnly("cn.lunadeer:DominionAPI:4.4")
}
```

### 2. Add Plugin Dependency

Add the following configuration to your plugin's `plugin.yml` file to ensure that your plugin is loaded after Dominion
is ready:

```yaml
# plugin.yml
depend: [ Dominion ]
```

## Second: Implement DominionAPI

Get the DominionAPI instance directly as follows:

```java
import cn.lunadeer.dominion.api.DominionAPI;

DominionAPI dominionAPI = Dominion.getInstance();
```

Then you can use the API, for example, to get the dominion information at a certain location:

```java

DominionAPI dominionAPI;

@Override
public void onEnable() {
    // Plugin startup logic
    if (Bukkit.getPluginManager().isPluginEnabled("Dominion")) {
        dominionAPI = DominionAPI.getInstance();
        this.getLogger().info("Got Dominion instance");
    } else {
        throw new IllegalStateException("Dominion plugin is not enabled. Please ensure it is installed and enabled.");
    }

    DominionDTO d = dominionAPI.getDominionByLoc(some_location);
    if (d == null) {
        this.getLogger().info("no dominion found");
        return;
    }
    this.getLogger().info("name:" + d.getName());
}
```

