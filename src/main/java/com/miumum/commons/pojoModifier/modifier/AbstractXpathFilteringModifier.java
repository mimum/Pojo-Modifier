package com.miumum.commons.pojoModifier.modifier;

import org.apache.commons.jxpath.Pointer;

/**
 * @author Roman Valina
 */
public abstract class AbstractXpathFilteringModifier implements Modifier {

    //Collections<Pointer> allowedPointers;

    @Override
    public boolean canModifyValue(Pointer pointer) {
        return pointer.getRootNode() instanceof String;

    }
}
