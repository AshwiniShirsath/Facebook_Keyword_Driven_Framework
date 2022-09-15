package com.fb.qa.test;

import com.fb.qa.kewordengine.KeywordEngine;
import org.testng.annotations.Test;

public class LoginTest {
    public KeywordEngine keywordEngine;

    @Test
    public void logintest() {
        keywordEngine = new KeywordEngine();
        keywordEngine.startExecution("login");
    }
}