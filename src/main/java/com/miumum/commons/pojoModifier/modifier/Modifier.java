package com.miumum.commons.pojoModifier.modifier;

import org.apache.commons.jxpath.Pointer;

/**
 * @author Roman Valina
 */
public interface Modifier {

    public boolean canModifyValue(Pointer pointer);

    public void modify(Pointer pointer);
}
