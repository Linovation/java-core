package com.mina.vitualthreads;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VirtualThreadExampleTest {

  @Test
  void testGetDownloadedTotalByte() throws InterruptedException {
    int result = VirtualThreadExample.getDownloadedTotalByte();
    int expected = 10 * DownloadFileTask.DOWNLOAD_SIZE;

    assertEquals(expected, result);
  }

  @Test
  void getTotalNumberOfVirtual() throws InterruptedException {
    int result = VirtualThreadExample.getTotalNumberOfVirtualThreads();

    assertEquals(100, result);
  }
}