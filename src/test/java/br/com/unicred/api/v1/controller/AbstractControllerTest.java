package br.com.unicred.api.v1.controller;

import br.com.unicred.utils.CenarioTestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class AbstractControllerTest {
    @Autowired
    protected CenarioTestHelper cenarioTestHelper;
}
