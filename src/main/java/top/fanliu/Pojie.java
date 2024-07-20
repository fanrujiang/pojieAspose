package top.fanliu;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Pojie {

    public static void main(String[] args) {
        modifyPptJar();
    }

    /**
     * 修改slides.jar包里面的校验
     */
    public static void modifyPptJar() {
        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("C:\\Users\\53094\\Downloads\\aspose-slides-22.11-jdk16.jar");
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.slides.internal.of.public");
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
            for (CtMethod ctMethod : methodA) {
                CtClass[] ps = ctMethod.getParameterTypes();
                if (ps.length == 3 && ctMethod.getName().equals("do")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    ctMethod.setBody("{}");
                }
            }
            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("C:\\Users\\53094\\Desktop\\");
        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }

}
