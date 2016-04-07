package com.daotesting.main;

public class StringMemoryTest {

	private static final int MBinBytes = 1048576;
	private static final int KBinBytes = 1024;

	/**
	 * 
	 */
	public StringMemoryTest() {
		// TODO Auto-generated constructor stub
		;
	}

	/**
	 * Perform GC
	 */
	private void performGC() {
		for (int i = 0; i < 10; i++) {
			System.gc();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	/**
	 * Get the memory used value.
	 * 
	 * @return long
	 */
	private long memoryUsed() {
		return ((Runtime.getRuntime().totalMemory() / KBinBytes) - (Runtime
				.getRuntime().freeMemory() / KBinBytes));
	}

	/**
	 * Method to test String object memory consumption in a BIG loop
	 */
	public void testStringMemory() {
		System.out
				.println("Initial Total memory in Java virtual machine in KBs="
						+ Runtime.getRuntime().totalMemory() / KBinBytes);
		System.out
				.println("Initial Free memory in Java virtual machine in KBs="
						+ Runtime.getRuntime().freeMemory() / KBinBytes);
		long initialmemory = memoryUsed();
		long startTime = System.currentTimeMillis();
		String s = "";
		for (int i = 1; i < 50000; i++) {
			s = s + i;
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out
				.println("Time taken to complete the process :" + elapsedTime);

		System.out.println("Memory used by String in KBs="
				+ (memoryUsed() - initialmemory));
		s = null;
		performGC();
		System.out.println("Free Memory after GC in KBs="
				+ Runtime.getRuntime().freeMemory() / KBinBytes);

	}

	/**
	 * Method to test StringBuilder object memory consumption in a BIG loop
	 */
	public void testStringBuilderMemory() {
		System.out
				.println("Initial Total memory in Java virtual machine in KBs="
						+ Runtime.getRuntime().totalMemory() / KBinBytes);
		System.out
				.println("Initial Free memory in Java virtual machine in KBs="
						+ Runtime.getRuntime().freeMemory() / KBinBytes);
		long initialmemory = memoryUsed();
		long startTime = System.currentTimeMillis();
		StringBuilder s = new StringBuilder();
		for (int i = 1; i < 50000; i++) {
			s.append(i);
		}
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out
				.println("Time taken to complete the process in MilliSeconds:"
						+ elapsedTime);
		System.out.println("Memory used by StringBuilder in KBs="
				+ (memoryUsed() - initialmemory));
		s = null;
		performGC();
		System.out.println("Free Memory after GC in KBs="
				+ Runtime.getRuntime().freeMemory() / KBinBytes);

	}

	/**
	 * Method to test StringBuffer object memory consumption in a BIG loop
	 */
	public void testStringBufferMemory() {
		System.out
				.println("Initial Total memory in Java virtual machine in KBs="
						+ Runtime.getRuntime().totalMemory() / KBinBytes);
		System.out
				.println("Initial Free memory in Java virtual machine in KBs="
						+ Runtime.getRuntime().freeMemory() / KBinBytes);
		long initialmemory = memoryUsed();
		long startTime = System.currentTimeMillis();
		StringBuffer s = new StringBuffer();

		for (int i = 1; i < 50000; i++) {
				s.append(i);
		}
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Time taken to complete the process :" + elapsedTime);
		System.out.println("Memory used by StringBuffer in KBs="
				+ (memoryUsed() - initialmemory));
		s = null;
		performGC();
		System.out.println("Free Memory after GC in KBs="
				+ Runtime.getRuntime().freeMemory() / KBinBytes);

	}

	/**
	 * Main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Initial Max memory in Java virtual machine in KBs="+ Runtime.getRuntime().maxMemory() / KBinBytes);
		
		StringMemoryTest memoryTest = new StringMemoryTest();
		
		System.out.println(" ........\nString memory test\n");
		
		memoryTest.testStringMemory();
		

		System.out.println("  ........\nStringBuffer memory test\n");
		
		memoryTest.testStringBufferMemory();
		
		System.out.println("  ........\nStringBuilder memory test\n");
		
		memoryTest.testStringBuilderMemory();

	}
	
}