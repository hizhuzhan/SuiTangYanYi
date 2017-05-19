package com.concurrent.base;

/*
 * ��������Ĵ�Ϸ��̨
 */
public class Stage extends Thread {
	
	public void run(){
		System.out.println("��ӭ�ۿ���������");
		//�ù����ǰ���Ƭ�̡��ȴ���Ϸ����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("��Ļ��������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("��˵�峯ĩ�꣬�����ũ�������ɱ�û���ڵ�...");
		
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		//ʹ��Runnable�ӿڴ����߳�
		Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"���");
		Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"ũ�������");
		
		//�����߳�
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//��̨�߳����ߣ����ר�Ĺۿ�������ɱ
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("����˫����ս��������·ɱ������ҧ��");
		
		Thread mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
		
		/*
		 * ����ֹͣ��ս
		 * ֹͣ�̷߳���
		 */
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//��ʷ��Ϸ�����ؼ�����
		mrCheng.start();
		
		//������Ŀ�������̵߳ȴ����������ʹ��
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("ս�����������񰲾���ҵ��������ʵ���˻������������룬Ϊ���������˹��ס�");
		System.out.println("лл�ۿ��������壬�ټ���");
		
//		armyTaskOfSuiDynasty.keepRunning = false;
//		armyTaskOfRevolt.keepRunning = false;
//		
//		
//		try {
//			armyOfRevolt.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Stage().start();
	}

}
