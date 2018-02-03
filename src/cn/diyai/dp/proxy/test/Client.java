package cn.diyai.dp.proxy.test;

import  cn.diyai.dp.proxy.InvocationHandler;
import  cn.diyai.dp.proxy.Proxy;
import  cn.diyai.dp.proxy.TimeHandler;

public class Client {
	public static void main(String[] args) throws Exception {
		UserMgr mgr = new UserMgrImpl();
		InvocationHandler h = new TransactionHandler(mgr);
		//TimeHandler h2 = new TimeHandler(h);
		UserMgr u = (UserMgr)Proxy.newProxyInstance(UserMgr.class,h);
		u.addUser();
	}
}
