import org.junit.Test;
import static org.junit.Assert.*;

public class BabysitterKataTest {
    @Test public void testFindTimeDifference() {
        float[] start = {6F, 30F};
        float[] stop = {3F, 0F};
        assertEquals(8.5, BabysitterKata.findTimeDifference(start, stop), .01F);
    }
    
    @Test public void testConvertTime1() {
    	float[] temp = {1, 30};
    	String time =  "1:30";
    	assertArrayEquals(temp, BabysitterKata.convertTime(time), .01F);
    }
    
    @Test public void testConvertTime2() {
    	float[] temp = {0, 30};
    	String time = "0:30";
    	assertArrayEquals(temp, BabysitterKata.convertTime(time), .01F);
    }
    
    @Test public void testConvertTime3() {
    	float[] temp = {1, 0};
    	String time = "1:0";
    	assertArrayEquals(temp, BabysitterKata.convertTime(time), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime1() {
        assertEquals(36, BabysitterKata.calculateNightlyChargeWithBedtime("10:0", "1:0", "11:0"), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime2() {
        assertEquals(64, BabysitterKata.calculateNightlyChargeWithBedtime("5:0", "11:0", "9:0"), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime3() {
        assertEquals(32, BabysitterKata.calculateNightlyChargeWithBedtime("10:0", "1:0", "10:0"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge1() {
        assertEquals(36, BabysitterKata.calculateNightlyCharge("5:0", "8:0"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge2() {
        assertEquals(132, BabysitterKata.calculateNightlyCharge("5:0", "3:0"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge3() {
        assertEquals(0, BabysitterKata.calculateNightlyCharge("5:0", "5:0"), .01F);
    }
}
