package ch14;

import java.util.concurrent.*;

class NanoDelay implements Delayed {
    long trigger;
    NanoDelay(long i) {
      trigger = System.nanoTime() + i;
    }
    public int compareTo(Delayed d) {
	         long i = trigger;
	         long j = ((NanoDelay)d).trigger;
	         int returnValue;
	         if (i < j) {
	           returnValue = -1;
	         } else if (i > j) {
	           returnValue = 1;
	         } else {
	           returnValue = 0;
	         }
	         return returnValue;
       }

    public long getDelay(TimeUnit unit) {
      long n = trigger - System.nanoTime();
      return unit.convert(n, TimeUnit.NANOSECONDS);
    }
    public long getTriggerTime() {
      return trigger;
    }
  }