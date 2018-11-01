package com.miumum.commons.pojoModifier.modifier;

import org.apache.commons.jxpath.Pointer;

/**
 * @author Roman Valina
 */
public abstract class AbstractStringModifier implements Modifier {

    @Override
    public boolean canModifyValue(Pointer pointer) {
        return pointer.getValue() instanceof String; // TODO I do nto like this
    }

    @Override
    public void modify(Pointer pointer) {
        String modifiedString = modifyString(pointer.getValue().toString());
        pointer.setValue(modifiedString);
    }

    public abstract String modifyString(String string);
}
