public class BabysitterKata {
    public float findTimeDifference(float startHour, float startMinute, float stopHour, float stopMinute) {
    	float tempStartHour = startHour;
    	float tempStartMinute = startMinute/60;
    	float tempStopHour = stopHour;
    	float tempStopMinute = stopMinute/60;
    	if (startHour <= 4) {
    		tempStartHour += 12;
    	}
    	if (stopHour <= 4) {
    		tempStopHour += 12;
    	}
    	float difference = (tempStopHour + tempStopMinute) - (tempStartHour + tempStartMinute);
        return difference;
    }
    
    public float[] convertTime (float time) {
    	float[] temp = new float[2];
    	String timeString = String.valueOf(time);
    	String[] splitTime = timeString.split("[.]");
    	if (splitTime[1].length() == 0) {
    		splitTime[1] = "0";
    	} else if (splitTime[1].length() == 1) {
    		splitTime[1] = splitTime[1].concat("0");
    	}
    	temp[0] = Float.parseFloat(splitTime[0]);
    	temp[1] = Float.parseFloat(splitTime[1]);
    	return temp;
    }
    
    public float calculateNightlyChargeWithBedtime (float startTime, float stopHour, float bedTime) {
    	return 0;
    }
}
