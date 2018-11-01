package com.miumum.commons.pojoModifier.test.model;

import java.util.Collection;

/**
 * @author Roman Valina
 */
public class ClassB {

    private Collection<ClassC> collectionOfC;

    private ClassB fieldOfB;

    public Collection<ClassC> getCollectionOfC() {
        return collectionOfC;
    }

    public void setCollectionOfC(Collection<ClassC> collectionOfC) {
        this.collectionOfC = collectionOfC;
    }

    public ClassB getFieldOfB() {
        return fieldOfB;
    }

    public void setFieldOfB(ClassB fieldOfB) {
        this.fieldOfB = fieldOfB;
    }
}
