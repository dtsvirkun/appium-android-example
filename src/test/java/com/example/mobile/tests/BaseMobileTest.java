package com.example.mobile.tests;

import com.example.mobile.core.driver.android.AndroidDriverProvider;

import com.codeborne.selenide.Configuration;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.*;

public class BaseMobileTest {

    private static AppiumDriverLocalService server;

    @BeforeSuite(alwaysRun = true)
    public void mobileTestBeforeSuite() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 12000;
        Configuration.browser = AndroidDriverProvider.class.getName();
    }

    @BeforeClass(alwaysRun = true)
    public void mobileBeforeAllClasses() {
        open();
    }

    @AfterClass(alwaysRun = true)
    public void mobileAfterAllClasses() {
        closeWebDriver();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        server.stop();
    }

}
