import org.junit.Test;
import static org.junit.Assert.*;

public class BabysitterKataTest {
    @Test public void testFindTimeDifference() {
        BabysitterKata classUnderTest = new BabysitterKata();
        float[] start = {6F, 30F};
        float[] stop = {3F, 0F};
        assertEquals(8.5, classUnderTest.findTimeDifference(start, stop), .01F);
    }
    
    @Test public void testConvertTime1() {
    	BabysitterKata classUnderTest = new BabysitterKata();
    	float[] temp = {1, 30};
    	String time =  "1:30";
    	assertArrayEquals(temp, classUnderTest.convertTime(time), .01F);
    }
    
    @Test public void testConvertTime2() {
    	BabysitterKata classUnderTest = new BabysitterKata();
    	float[] temp = {0, 30};
    	String time = "0:30";
    	assertArrayEquals(temp, classUnderTest.convertTime(time), .01F);
    }
    
    @Test public void testConvertTime3() {
    	BabysitterKata classUnderTest = new BabysitterKata();
    	float[] temp = {1, 0};
    	String time = "1:0";
    	assertArrayEquals(temp, classUnderTest.convertTime(time), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime() {
        BabysitterKata classUnderTest = new BabysitterKata();
        assertEquals(36, classUnderTest.calculateNightlyChargeWithBedtime("10:0", "1:0", "11:0"), .01F);
    }
}
