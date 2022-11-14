package homework_1.task_2;

import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MainTest {
    @Test
    public void numberFibonachchi() {
        // given
        int n = 16;
        int expectedResult = 610;
        //when
        int actualResult = Main.numberFibonachchi(n);
        // then
        assertEquals(expectedResult, actualResult);
    }
}
