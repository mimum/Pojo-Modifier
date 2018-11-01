package com.miumum.commons.pojoModifier.test.modifier;

import com.miumum.commons.pojoModifier.modifier.Modifier;
import com.miumum.commons.pojoModifier.test.model.ClassC;
import org.apache.commons.jxpath.Pointer;

/**
 * @author Roman Valina
 */
public class ClassCReplacingModifier implements Modifier {

    @Override
    public boolean canModifyValue(Pointer pointer) {
        return pointer.getValue() instanceof ClassC;
    }

    @Override
    public void modify(Pointer pointer) {
        ClassC classC = new ClassC();
        classC.setString("xxx  ");
        pointer.setValue(classC);
    }
}
