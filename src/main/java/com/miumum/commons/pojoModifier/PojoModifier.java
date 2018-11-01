package com.miumum.commons.pojoModifier;

import com.miumum.commons.pojoModifier.modifier.Modifier;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Roman Valina
 */
public class PojoModifier {

    private List<Modifier> modifiers = new ArrayList<>();

    private JXPathContext rootContext;

    public void executeModification(Object object) {
        rootContext = JXPathContext.newContext(object);
        rootContext.setLenient(true);
        for (Modifier modifier : modifiers) {
            executeModificationRecursive(rootContext, modifier);
        }
    }


    private void executeModificationRecursive(JXPathContext parentContext, Modifier modifier) {
            Iterator<Pointer> pointerIterable = parentContext.iteratePointers("*");
            while (pointerIterable.hasNext()) {
                Pointer pointer = pointerIterable.next();
                JXPathContext pathContext = parentContext.getRelativeContext(pointer);
                executeModificationRecursive(pathContext, modifier);
                if (modifier.canModifyValue(pointer)) {
                    modifier.modify(pointer);
                }
            }

    }

    public void addModifier(Modifier modifier) {
        modifiers.add(modifier);
    }

}
