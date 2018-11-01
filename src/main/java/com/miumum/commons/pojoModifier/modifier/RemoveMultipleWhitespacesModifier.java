package com.miumum.commons.pojoModifier.modifier;

/**
 * @author Roman Valina
 */
public class RemoveMultipleWhitespacesModifier extends AbstractStringModifier {

    @Override
    public String modifyString(String string) {
        return string.replaceAll(" +", " ");
    }

}
