import org.junit.Test;
import static org.junit.Assert.*;

public class BabysitterKataTest {
    @Test public void testFindTimeDifference() {
        BabysitterKata classUnderTest = new BabysitterKata();
        assertEquals(8.5, classUnderTest.findTimeDifference(6, 30, 3, 0), .01F);
    }
    
    @Test public void testConvertTime1() {
    	BabysitterKata classUnderTest = new BabysitterKata();
    	float[] temp = {1, 30};
    	float time = (float) 1.30;
    	assertArrayEquals(temp, classUnderTest.convertTime(time), .01F);
    }
    
    @Test public void testConvertTime2() {
    	BabysitterKata classUnderTest = new BabysitterKata();
    	float[] temp = {0, 30};
    	float time = (float) 0.30;
    	assertArrayEquals(temp, classUnderTest.convertTime(time), .01F);
    }
    
    @Test public void testConvertTime3() {
    	BabysitterKata classUnderTest = new BabysitterKata();
    	float[] temp = {1, 0};
    	float time = (float) 1;
    	assertArrayEquals(temp, classUnderTest.convertTime(time), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime() {
        BabysitterKata classUnderTest = new BabysitterKata();
        assertEquals(36, classUnderTest.calculateNightlyChargeWithBedtime(10, 1, 11), .01F);
    }
}
