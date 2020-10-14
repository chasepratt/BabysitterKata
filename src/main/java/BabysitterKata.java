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
    
    public float calculateNightlyChargeWithBedtime (float startTime, float stopTime, float bedTime) {
    	float[] convertedStart = convertTime(startTime);
    	float[] convertedStop = convertTime(stopTime);
    	float[] convertedBed = convertTime(bedTime);
    	float startToBed = findTimeDifference(convertedStart[0], convertedStart[1], convertedBed[0], convertedBed[1]);
    	float bedToMid = findTimeDifference(convertedBed[0], convertedBed[1], 0F, 0F);
    	float midToStop = findTimeDifference(0F, 0F, convertedStop[0], convertedStop[1]);
    	float charge = startToBed * 12F + bedToMid * 8F + midToStop * 16F;
    	return charge;
    }
    
    public float calculateNightlyCharge(float startTime, float stopTime) {
    	float[] convertedStart = convertTime(startTime);
    	float[] convertedStop = convertTime(stopTime);
    	float startToStop = findTimeDifference(convertedStart[0], convertedStart[1], convertedStop[0], convertedStop[1]);
    	float charge = startToStop * 12F;
    	return charge;
    }
}
