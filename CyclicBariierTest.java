package com.hp.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class CyclicBariierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable run2 = () -> {
				System.out.println("this will executes once all threads reaches the barrier point");
		};
		
		CyclicBarrier barrier = new CyclicBarrier(2, run2);		
		Runnable run = () ->{			
			System.out.println("Started: " + Thread.currentThread().getName());
			//do shopping cart related business logic
			//wait for payment gate way completion...			
			try {
				Thread.sleep(10);
				System.out.println("Waiting.. " + Thread.currentThread().getName());
				barrier.await(); //barrier point to wait for completion of all other threads.,
			} catch (InterruptedException e) {			
			} catch (BrokenBarrierException e) {				
			}
			System.out.println("redirect to succssful page logic.. for: " + Thread.currentThread().getName());
		};		
		Runnable run1 = () ->{			
			try {
				Thread.sleep(100);
				System.out.println("Started: " + Thread.currentThread().getName());
			//payment gate way completion...			
			
				 //business logic for payment gateway completion...
				System.out.println("Waiting.. " + Thread.currentThread().getName());
				
				barrier.await(); //barrier point to wait for completion of all other threads.,
			} catch (InterruptedException e) {			
			} catch (BrokenBarrierException e) {				
			}
			System.out.println("storing into logs after successful:" + Thread.currentThread().getName());
		};
		
		new Thread(run).start();
		new Thread(run1).start();
		
	}

}
