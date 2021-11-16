package com.moon.senla;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractDao<T> implements GenericDao<T>{

    private static final Logger logger = LoggerFactory.getLogger(AbstractDao.class);

    public AbstractDao() {
    }
}
