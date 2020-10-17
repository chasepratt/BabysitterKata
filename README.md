This project requires gradle, a java runtime environment (JRE), and a java development kit (JDK) to already be installed.
The JRE and JDK need to have matching versions.

Inputs to this program need to follow the following rules or there may be potentially incorrect results.
The start time will always be before midnight.
If there is a bedtime, it will be before or at midnight.
Bed times must also be after or at start time and before or at end time.
Start times must be at or after 5:00 and end time must be at or before 4:00.

After this project is downloaded and unpackaged, navigate to the BabysitterKata folder with a terminal.
Once there, the command to run the project is "gradle run -Pmyargs=start,finish,bed"
the args start, finish, and bed are all times and should follow this format: 6:00.
Midnight should be represented as 0:00.
The bed argument is optional and doesn't have to be included.

An example of this command would be:

gradle run -Pmyargs=5:00,3:00,8:00

An example without a bedtime would be:

gradle run -Pmyargs=5:00,3:00