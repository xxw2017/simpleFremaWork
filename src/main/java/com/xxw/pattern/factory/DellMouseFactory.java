package com.xxw.pattern.factory;

import com.xxw.pattern.factory.entity.DellMouse;
import com.xxw.pattern.factory.entity.HpMouse;
import com.xxw.pattern.factory.entity.Mouse;

/**
 * @author xiongxianwei
 * 2020/6/5 0005
 */
public class DellMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
