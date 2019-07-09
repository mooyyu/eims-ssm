package service.impl;

import dao.SuperuserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.SuperuserService;

@Service
public class SuperuserServiceImpl implements SuperuserService {
    @Autowired
    private SuperuserDao superuserDao;

    @Override
    public boolean checkLogin(String name, String password) {
        return superuserDao.checkLogin(name, password);
    }
}
