package com.x.smc.bill.service.process;

public abstract class LoopThread extends Thread{

	public boolean exitFlag = false;
	
	public abstract boolean init();
	
	public abstract boolean unInit();

	public abstract void work();

	public void run() {
		if (init()) {
			while (true) {
				work();
				if (exitFlag)
					break;
			}
		}
		unInit();
	}
	
}
