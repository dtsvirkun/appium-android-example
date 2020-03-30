package com.example.mobile.tests.field;

import com.codeborne.selenide.Condition;
import com.example.mobile.tests.BaseMobileTest;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;


public class MobileTest extends BaseMobileTest {

    @Test
    public void verifyTitleFieldIsExpanded() {

         $(MobileBy.AndroidViewTag("show-title-button")).click();
         $(MobileBy.AndroidViewTag("test-id-title")).val("test");
         $(MobileBy.AndroidViewTag("test-id-title")).shouldHave(Condition.text("test"));
    }
}
