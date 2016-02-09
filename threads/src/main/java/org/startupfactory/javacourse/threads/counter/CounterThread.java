package org.startupfactory.javacourse.threads.counter;

public class CounterThread extends Thread {
	private long maxCounterValue;
	private long counter;
	
	private boolean stopped;
	public CounterThread(long maxCounterValue) {
		this.maxCounterValue=maxCounterValue;
	}
	public long getValue(){
		return counter;
	}
	public void run(){
		while(counter<maxCounterValue && !isStopped()){
			counter++;
		}
	}
	public synchronized void stopCounter(){
		stopped=true;
	}
	private boolean isStopped() {
		// TODO Auto-generated method stub
		return stopped;
	}

}
