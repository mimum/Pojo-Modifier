package com.miumum.commons.pojoModifier

import com.miumum.commons.pojoModifier.modifier.TrimModifier
import com.miumum.commons.pojoModifier.test.modifier.ClassCReplacingModifier
import com.miumum.commons.pojoModifier.test.model.ClassA
import com.miumum.commons.pojoModifier.test.model.ClassB
import com.miumum.commons.pojoModifier.test.model.ClassC
import com.miumum.commons.pojoModifier.test.modifier.PrintModifier
import org.junit.Test
/**
 * @author Roman Valina
 */
public class PojoModifierTest {

    @Test
    public void executeModification() {
        ClassA model = new ClassA(
                filedOfB1: new ClassB(
                        collectionOfC: [
                                new ClassC(
                                        string: "string in C   1"
                                ),
                                new ClassC(
                                        string: "string in C 2  "
                                )
                        ],
                        fieldOfB: new ClassB(
                                collectionOfC: //Collections.unmodifiableList(
                                        [
                                        new ClassC(
                                                string: "string in C 3  "
                                        )  ]
                                //)
                        )
                ),
                string: "string in  class A  "
        );

        def b = new ClassB(
                collectionOfC: [
                        new ClassC(
                                string: "string in C   1"
                        ),
                        new ClassC(
                                string: "string in C 2  "
                        )
                ]
        )
        b.setFieldOfB(b)


        ClassA modelCyklus = new ClassA(
                filedOfB1:b,
                string: "string in  class A  "
        );

        PojoModifier modifier = new PojoModifier()

        modifier.addModifier(new ClassCReplacingModifier())
        modifier.addModifier(new TrimModifier())
        modifier.addModifier(new PrintModifier())
        modifier.executeModification(modelCyklus)
        println model
    }
}