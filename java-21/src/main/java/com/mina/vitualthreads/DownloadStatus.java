package com.mina.vitualthreads;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {

//  Or AtomicInteger
  private LongAdder totalByte = new LongAdder();

  public int getTotalByte() {
    return totalByte.intValue();
  }

  public void incrementTotalByte() {
    totalByte.increment();
  }
}
