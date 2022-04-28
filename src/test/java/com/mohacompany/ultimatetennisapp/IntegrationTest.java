package com.mohacompany.ultimatetennisapp;

import com.mohacompany.ultimatetennisapp.UltimateTennisApplicationApp;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = UltimateTennisApplicationApp.class)
public @interface IntegrationTest {
}
