package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void setParameters() {
        Configuration.baseUrl = "https://www.asos.com/";
        Configuration.browserSize = "1920x1080";
    }
}