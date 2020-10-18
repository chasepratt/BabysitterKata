public class BabysitterKata {
	//Used to find the difference between two different times
	//Start and Stop should both be 2 variable arrays where the first element
	//represents hours and the second represents minutes
    static float findTimeDifference(float[] start, float[] stop) {
    	float tempStartHour = start[0];
    	float tempStartMinute = start[1]/60;
    	float tempStopHour = stop[0];
    	float tempStopMinute = stop[1]/60;
    	//if the start or stop are after midnight, add 12 to them in order to make finding difference easier
    	if (start[0] <= 4) {
    		tempStartHour += 12;
    	}
    	if (stop[0] <= 4) {
    		tempStopHour += 12;
    	}
    	float difference = (tempStopHour + tempStopMinute) - (tempStartHour + tempStartMinute);
        return difference;
    }
    
    //Converts a time float into an array where hours are in the first
    //position and minutes are in the second
    static float[] convertTime(String time) {
    	float[] temp = new float[2];
    	String[] splitTime = time.split("[:]");
    	if (splitTime[1].length() == 0) {
    		//if there are no minutes in the time set it to 0
    		splitTime[1] = "0";
    	} else if (splitTime[1].length() == 1) {
    		//add a 0 to make it so 1:3 becomes 1:30
    		splitTime[1] = splitTime[1].concat("0");
    	}
    	temp[0] = Float.parseFloat(splitTime[0]);
    	temp[1] = Float.parseFloat(splitTime[1]);
    	return temp;
    }
    
    //Calculates the charge for a night with a bedtime included
    static float calculateNightlyChargeWithBedtime(String startTime, String stopTime, String bedTime) {
    	float[] convertedStart = convertTime(startTime);
    	float[] convertedStop = convertTime(stopTime);
    	float[] convertedBed = convertTime(bedTime);
    	float[] midnight = {0F, 0F};
    	float charge = 0F;
    	if (convertedStop[0] <= 4) {
    		//if stop is after midnight then after midnight cost is needed
    		float startToBed = findTimeDifference(convertedStart, convertedBed);
        	float bedToMid = findTimeDifference(convertedBed, midnight);
        	float midToStop = findTimeDifference(midnight, convertedStop);
        	float totalTime = findTimeDifference(convertedStart, convertedStop);
    		int chargeableTime = (int) totalTime;
    		float difference = totalTime - chargeableTime;
    		//Remove time so the charge is only for full hours
    		//IE worked 8 hours 45 minutes should only be paid for 8 hours
    		if (midToStop < difference) {
    			//if difference is more than the time spent from midnight to end, remove time from bed to mid
    			difference -= midToStop;
    			midToStop = 0;
    			if (bedToMid < difference) {
    				//if difference is still more than the time spent from bed to mid, remove time from start to bed
    				difference -= bedToMid;
    				bedToMid = 0;
    				startToBed -= difference;
    			} else {
    				bedToMid -= difference;
    			}
    		} else {
    			midToStop -= difference;
    		}
        	charge = startToBed * 12F + bedToMid * 8F + midToStop * 16F;
    	} else {
    		float startToBed = findTimeDifference(convertedStart, convertedBed);
    		float bedToStop = findTimeDifference(convertedBed, convertedStop);
    		float totalTime = findTimeDifference(convertedStart, convertedStop);
    		int chargeableTime = (int) totalTime;
    		float difference = totalTime - chargeableTime;
    		//Remove time so the charge is only for full hours
    		if (bedToStop < difference) {
    			//if difference is more than the time spent from bed to stop, remove time from start to bed
    			difference -= bedToStop;
    			bedToStop = 0;
    			startToBed -= difference;
    		} else {
    			bedToStop -= difference;
    		}
    		charge = startToBed * 12F + bedToStop * 8F;
    	}
    	return charge;
    }
    
    //Calculates the charge for a night without a bedtime included
    static float calculateNightlyCharge(String startTime, String stopTime) {
    	float[] convertedStart = convertTime(startTime);
    	float[] convertedStop = convertTime(stopTime);
    	float[] midnight = {0F, 0F};
    	float charge = 0F;
    	if (convertedStop[0] <= 4) {
    		float startToMid = findTimeDifference(convertedStart, midnight);
    		float midToStop = findTimeDifference(midnight, convertedStop);
    		float totalTime = findTimeDifference(convertedStart, convertedStop);
    		int chargeableTime = (int) totalTime;
    		float difference = totalTime - chargeableTime;
    		//Remove time so the charge is only for full hours
    		if (midToStop < difference) {
    			//if difference is more than the time spent from mid to stop, remove time from start to mid
    			difference -= midToStop;
    			midToStop = 0;
    			startToMid -= difference;
    		} else {
    			midToStop -= difference;
    		}
    		charge = startToMid * 12F + midToStop * 16F;
    	} else {
    		float startToStop = findTimeDifference(convertedStart, convertedStop);
    		float totalTime = startToStop;
    		int chargeableTime = (int) totalTime;
    		float difference = totalTime - chargeableTime;
    		//Remove time so the charge is only for full hours
    		startToStop -= difference;
    		charge = startToStop * 12F;
    	}
    	return charge;
    }
    
	public static void main(String[] args) {
		float charge = 0F;
		if (args.length <= 1 || args.length > 3) {
			System.out.println("\nError: Incorrect number of inputs");
			System.exit(1);
		} else if (args.length == 2) {
			charge = calculateNightlyCharge(args[0],args[1]);
		} else if (args.length == 3) {
			charge = calculateNightlyChargeWithBedtime(args[0],args[1], args[2]);
		}
		System.out.println("\nThe charge for the night is $" + charge);
	}
}
