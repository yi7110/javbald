package com.liuzf.pra.abstractfactory.factory;

import com.liuzf.pra.abstractfactory.service.Color;
import com.liuzf.pra.abstractfactory.service.Shape;

/**
 * com.liuzf.pra.abstractfactory.factory
 *
 * @author Liuzf
 * @date 2020-06-19 14:54:51
 */
public abstract class AbstracFactory {
    /**
     * 获取颜色
     * @return
     */
    public abstract Color getColor(String colorType);

    /**
     * 获取形状
     * @return
     */
    public abstract Shape getShape(String shapeType);
}
