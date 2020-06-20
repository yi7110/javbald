package com.liuzf.pra.abstractfactory;

import com.liuzf.pra.abstractfactory.service.Color;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

/**
 * com.liuzf.pra.abstractfactory
 *
 * @author Liuzf
 * @date 2020-06-19 14:53:01
 */
public class Yellow implements Color {

    @Override
    public void fill() {
        System.out.println("黄色");
    }
}
