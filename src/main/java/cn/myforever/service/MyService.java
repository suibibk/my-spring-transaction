package cn.myforever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.myforever.annotation.ExtTransaction;
import cn.myforever.dao.MyDao;
import cn.myforever.transaction.MyTransaction;
@Service
public class MyService {
	@Autowired
	private MyTransaction myTransaction;
	@Autowired
	private MyDao myDao;
	public void add() {
		try {
			myTransaction.begin();
			myDao.add("1", "1");
			int i =1/0;
			myDao.add("2", "2");
			myTransaction.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			myTransaction.rollback();
		}
	}
	
	@ExtTransaction
	public void add1() {
		myDao.add("1", "1");
		int i =1/0;
		myDao.add("2", "2");
	}
}
