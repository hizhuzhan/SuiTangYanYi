package com.concurrent.base;

/*
 * �����߳�
 * ģ����ս˫������Ϊ
 */

public class ArmyRunnable implements Runnable {
	
	//volatile��֤���߳̿�����ȷ�Ķ�ȡ�����߳�д���ֵ
	//�ɼ���
	volatile boolean keepRunning = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(keepRunning){
			//����5����
			for(int i = 0; i < 5; i++){
				System.out.println(Thread.currentThread().getName()+"�����Է�[" + i +"]");
				
				Thread.yield();
				
			}
			
		}
		System.out.println(Thread.currentThread().getName()+"������ս����");
	}

}
