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
        assertEquals(36, BabysitterKata.calculateNightlyChargeWithBedtime("10:00", "1:00", "11:00"), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime2() {
        assertEquals(64, BabysitterKata.calculateNightlyChargeWithBedtime("5:00", "11:00", "9:00"), .01F);
    }
    
    @Test public void testCalculateNightlyChargeWithBedtime3() {
        assertEquals(32, BabysitterKata.calculateNightlyChargeWithBedtime("10:00", "1:00", "10:00"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge1() {
        assertEquals(36, BabysitterKata.calculateNightlyCharge("5:00", "8:00"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge2() {
        assertEquals(132, BabysitterKata.calculateNightlyCharge("5:00", "3:00"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge3() {
        assertEquals(0, BabysitterKata.calculateNightlyCharge("5:00", "5:00"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge4() {
        assertEquals(12, BabysitterKata.calculateNightlyCharge("11:00", "0:30"), .01F);
    }
    
    @Test public void testCalculateNightlyCharge5() {
        assertEquals(12.666, BabysitterKata.calculateNightlyCharge("11:10", "0:40"), .01F);
    }
}
