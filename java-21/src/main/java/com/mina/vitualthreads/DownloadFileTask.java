package com.mina.vitualthreads;

public class DownloadFileTask implements Runnable {

  private DownloadStatus downloadStatus;

  public static int DOWNLOAD_SIZE = 10_000;

  public DownloadFileTask(DownloadStatus downloadStatus) {
    this.downloadStatus = downloadStatus;
  }

  @Override
  public void run() {
    System.out.println("Start downloading a file..." + Thread.currentThread().getName());
    for (var i = 0; i < DOWNLOAD_SIZE; i++) {
      if (Thread.currentThread().isInterrupted()) {
        return;
      }
      downloadStatus.incrementTotalByte();
    }
  }
}
