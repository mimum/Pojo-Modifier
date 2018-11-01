package com.miumum.commons.pojoModifier.test.modifier;

import com.miumum.commons.pojoModifier.modifier.Modifier;
import org.apache.commons.jxpath.Pointer;

/**
 * @author Roman Valina
 */
public class PrintModifier implements Modifier {

    @Override
    public boolean canModifyValue(Pointer pointer) {
        return true;
    }

    @Override
    public void modify(Pointer pointer) {
        System.out.println(pointer.asPath() + " -(" + pointer.getValue() +")");
    }

}
