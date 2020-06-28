package com.example.trianingdemo.utile;

import com.example.trianingdemo.base.BaseApp;
import com.example.trianingdemo.bean.HomeBean;
import com.example.trianingdemo.db.DaoMaster;
import com.example.trianingdemo.db.DaoSession;
import com.example.trianingdemo.db.HomeBeanDao;

public class DBHolper {
    private static volatile DBHolper ourInstance;
    private final HomeBeanDao homeBeanDao;

    public static DBHolper getInstance() {
        if (ourInstance == null) {
            synchronized (DBHolper.class) {
                if (ourInstance == null) {
                    ourInstance = new DBHolper();
                }
            }
        }
        return ourInstance;
    }

    private DBHolper() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApp.getBaseApp(), "attention.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

        DaoSession daoSession = daoMaster.newSession();

        homeBeanDao = daoSession.getHomeBeanDao();
    }

    public long insert(HomeBean homeBean) {
        long l = homeBeanDao.insertOrReplace(homeBean);
        return l;
    }

    public void delete(HomeBean homeBean) {
        homeBeanDao.delete(homeBean);
    }
}
