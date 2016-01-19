package org.kantega.notsoserial.transformers;

import org.kantega.notsoserial.*;
import org.objectweb.asm.ClassVisitor;

/**
 * JBossAbstractClassResolverNotSoSerialTransformer
 */
public class JBossAbstractClassResolverNotSoSerialTransformer implements NotSoSerialTransformer {

    public boolean shouldRetransform(Class clazz) {
        return "org.jboss.marshalling.AbstractClassResolver".equals(clazz.getName());
    }

    public boolean shouldTransform(String className) {
        return "org/jboss/marshalling/AbstractClassResolver".equals(className);
    }

    public ClassVisitor createClassVisitor(ClassVisitor writer) {
        return new ObjectInputStreamClassVisitor(writer);
    }
}
