public class BabysitterKata {
	
	//Used to find the difference between two different times.
	//Start and Stop should both be 2 variable arrays where the first element
	//represents hours and the second represents minutes.
    public float findTimeDifference(float[] start, float[] stop) {
    	float tempStartHour = start[0];
    	float tempStartMinute = start[1]/60;
    	float tempStopHour = stop[0];
    	float tempStopMinute = stop[1]/60;
    	if (start[0] <= 4) {
    		tempStartHour += 12;
    	}
    	if (stop[0] <= 4) {
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
    
    public float calculateNightlyChargeWithBedtime (float startTime, float stopTime, float bedTime) {
    	float[] convertedStart = convertTime(startTime);
    	float[] convertedStop = convertTime(stopTime);
    	float[] convertedBed = convertTime(bedTime);
    	float[] midnight = {0F, 0F};
    	float startToBed = findTimeDifference(convertedStart, convertedBed);
    	float bedToMid = findTimeDifference(convertedBed, midnight);
    	float midToStop = findTimeDifference(midnight, convertedStop);
    	float charge = startToBed * 12F + bedToMid * 8F + midToStop * 16F;
    	return charge;
    }
    
    public float calculateNightlyCharge(float startTime, float stopTime) {
    	float[] convertedStart = convertTime(startTime);
    	float[] convertedStop = convertTime(stopTime);
    	float startToStop = findTimeDifference(convertedStart, convertedStop);
    	float charge = startToStop * 12F;
    	return charge;
    }
}
