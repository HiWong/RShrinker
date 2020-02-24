package wang.imallen.blog.rshrinker;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

import java.nio.file.Path;
import java.util.List;

/**
 * author: AllenWang
 * date: 2020-02-23
 */
public class DetectClassOnlyVisitor extends ClassVisitor {

    private List<String> targetClasses;
    private Path path;

    DetectClassOnlyVisitor(ClassVisitor cv, List<String> targetClasses, Path path) {
        super(Opcodes.ASM5, cv);
        this.targetClasses = targetClasses;
        this.path = path;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        System.out.println("=========this is class: " + name);
        for (String targetClass : targetClasses) {
            //KP: 要注意包名用/还是.
            //System.out.println("targetClass:" + targetClass);
            if (targetClass.equals(name)) {
                System.out.println("============found " + targetClass + " in " + path.toString());
            }
        }
    }

}
