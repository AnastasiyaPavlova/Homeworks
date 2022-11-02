package homework_1.task_1;
import org.junit.Assert;
import org.junit.Test;


public class MainTest {

    @Test
    public void testProfitCalculation() {
        // given
        float deposit = 20000;
        int year = 1;
        float percent = 10;
        float expectedResult = 2000;
        //when
float actualResult = Main.profitCalculation(deposit, year, percent);
        // then
        Assert.assertEquals(expectedResult, actualResult,2);
    }
}