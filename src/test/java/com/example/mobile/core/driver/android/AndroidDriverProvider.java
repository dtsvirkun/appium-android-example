package com.example.mobile.core.driver.android;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        File app = downloadApk();
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Espresso");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel 3");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appPackage", "com.example_mobile_ui");
        capabilities.setCapability("appActivity", "com.example_mobile_ui.MainActivity");
        capabilities.setCapability("appWaitActivity", "com.example_mobile_ui.MainActivity");
        capabilities.setCapability("allowTestPackages", true);
        capabilities.setCapability("espressoBuildConfig", "build.config.json");

        try {
            return new io.appium.java_client.android.AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private File downloadApk() {
        File apk = new File("../../test/example-ui/android/app/build/outputs/apk/debug/app-debug.apk");
        return apk;
    }
}