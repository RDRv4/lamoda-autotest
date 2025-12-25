package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote.properties",
        "classpath:config/credentials.properties"
})

public interface ProjectConfig extends Config {

    @DefaultValue("https://www.lamoda.by")
    String baseUrl();

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("127.0")
    String browserVersion();

    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteDriverUrl();

    String userEmail();

    String userPassword();
}