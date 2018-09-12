package com.murphy.wechat.admin.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Integer count0 = 1;
	private Integer count1 = 1;
	private Integer count2 = 1;

	/**
	 * 表示每隔5000ms
	 * 
	 * @throws InterruptedException
	 */
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() throws InterruptedException {
		System.out.println(String.format("---第%s次执行，当前时间为：%s", count0++, dateFormat.format(new Date())));
	}

	/**
	 * 表示当方法执行完毕5000ms后，Spring scheduling会再次调用该方法
	 * 
	 * @throws InterruptedException
	 */
	@Scheduled(fixedDelay = 5000)
	public void reportCurrentTimeAfterSleep() throws InterruptedException {
		System.out.println(String.format("===第%s次执行，当前时间为：%s", count1++, dateFormat.format(new Date())));
	}

	@Scheduled(cron = "0 0/6 * * * ?")
	public void reportCurrentTimeCron() throws InterruptedException {
		System.out.println(String.format("+++第%s次执行，当前时间为：%s", count2++, dateFormat.format(new Date())));
	}

}