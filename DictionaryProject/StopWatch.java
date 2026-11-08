//  Copyright 1996, Joseph Bergin.  All rights reserved. 


// Stopwatch with a variable accuracy
// 

public class StopWatch
{	private long startTime;
	private long markTime;
	private long stopTime;
	private long ticks;
	
	public StopWatch(int millisecondsPerTick)
	{	startTime = System.currentTimeMillis();
		markTime = 0;
		stopTime = 0;
		if(millisecondsPerTick<1) millisecondsPerTick = 1;
		ticks = millisecondsPerTick;
	}

	public long start()
	{	reset();
		startTime = System.currentTimeMillis();
		markTime = startTime;
		return startTime;
	}
	
	public long mark()
	{	long newTime = System.currentTimeMillis();
		long diffTime = (newTime - markTime) / ticks;
		long totalTime = (newTime - startTime) / ticks;
		
		System.out.println("Mark Elapsed Time" + totalTime);
		System.out.println("Lap Time" + diffTime);
		markTime = newTime;
		return markTime;
	}
	
	public long stop()
	{	stopTime = System.currentTimeMillis();
		return stopTime-startTime;
	}
	
	void reset()
	{	startTime = System.currentTimeMillis();;
		markTime = 0;
		stopTime = 0;
	}

}
