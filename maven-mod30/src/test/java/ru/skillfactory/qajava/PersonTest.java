package ru.skillfactory.qajava;


import org.testng.annotations.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.testng.Assert.assertEquals;


public class PersonTest {
    @BeforeClass
    public void beforeClass() {
        System.out.println("isTeenage test started");
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dt.format(now));
    }

    @AfterClass
    public void afterClass() {
        System.out.println("isTeenage test done");
        DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dt.format(now));
    }

    @DataProvider(name = "ageTest")
    Object[][] ageDataProvider() {
        return new Object[][] {
                {-1, false},
                {0, false},
                {5, false},
                {12, false},
                {13, true},
                {15, true},
                {19, true},
                {20, false},
                {50, false}
        };
    }

    @Test(dataProvider = "ageTest")
    public void isTeenagerTest(int age, boolean expectedResult) {
        boolean result = Person.isTeenager(age);
        System.out.println(result);
        assertEquals(result, expectedResult);
    }
}
