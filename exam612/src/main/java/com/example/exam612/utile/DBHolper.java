package com.example.exam612.utile;

import com.example.exam612.bean.HomeBean;
import com.example.exam612.commer.BaseApp;
import com.example.xts.greendaodemo.db.DaoMaster;
import com.example.xts.greendaodemo.db.DaoSession;
import com.example.xts.greendaodemo.db.HomeBeanDao;

import java.util.List;

public class DBHolper {
    private static volatile DBHolper ourInstance;
    private final HomeBeanDao homeBeanDao;

    public static DBHolper getInstance() {
        if (ourInstance==null){
            synchronized (DBHolper.class){
                if (ourInstance==null){
                    ourInstance=new DBHolper();
                }
            }
        }
        return ourInstance;
    }

    private DBHolper() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApp.getApp(), "db.holper");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

        DaoSession daoSession = daoMaster.newSession();

        homeBeanDao = daoSession.getHomeBeanDao();
    }

    public long insert(HomeBean homeBean){
        long l = homeBeanDao.insertOrReplace(homeBean);
        return l;
    }

    public boolean queryOun(HomeBean homeBean){
        List<HomeBean> list = homeBeanDao.queryBuilder().where(HomeBeanDao.Properties.Id.eq(homeBean.getId())).list();
        if (list.size()>=0){
            return true;
        } else {
            return false;
        }
    }

    public void delete(HomeBean homeBean){
        queryOun(homeBean);
        homeBeanDao.delete(homeBean);
    }
}
