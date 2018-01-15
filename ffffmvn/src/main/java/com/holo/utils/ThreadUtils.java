package com.holo.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * @author 曾腾鹏
 *
 * 2016年7月1日
 */
public class ThreadUtils {
	private static ExecutorService es=Executors.newCachedThreadPool();
	
	public static ExecutorService getThead(){
		return es;
	}
	
	/**
	 * 执行任务
	 * @param runnable
	 */
	public static void execRun(Runnable runnable){
		es.execute(runnable);
	}
}
