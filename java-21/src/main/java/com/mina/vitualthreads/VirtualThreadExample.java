package com.mina.vitualthreads;

import static java.lang.Thread.sleep;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VirtualThreadExample {

  public static int getDownloadedTotalByte() throws InterruptedException {

    ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

    // Create a DownloadStatus object to track the download progress.
    DownloadStatus downloadStatus = new DownloadStatus();

    // Submit 10 tasks to the executor service to download the file.
    for (int i = 0; i < 10; i++) {
      executorService.submit(new DownloadFileTask(downloadStatus));
    }

//    shutdown means the executor service takes no more incoming tasks.
//    awaitTermination is invoked after a shutdown request.
    executorService.shutdown();
    executorService.awaitTermination(10000, TimeUnit.SECONDS);
    return downloadStatus.getTotalByte();
  }

  public static int getTotalNumberOfVirtualThreads() throws InterruptedException {
    var observed = new ConcurrentSkipListSet<>();
    var threads = IntStream
        .range(0, 100)
        .mapToObj(index -> Thread.ofVirtual() // ①
            .unstarted(() -> {
              observed.add(Thread.currentThread().toString());
              try {
                sleep(2000);
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            }))
        .toList();

    for (var t : threads) {
      t.start();
    }

    for (var t : threads) {
      t.join();
    }
    return observed.size();
  }
}
