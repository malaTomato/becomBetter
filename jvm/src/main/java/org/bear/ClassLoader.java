package org.bear;

public class ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException {
    
        System.out.println(String.class.getClassLoader());
        System.out.println(ClassLoader.class.getClassLoader());

       Class cpu =  ClassLoader.class.getClassLoader().loadClass("org.bear.CpuSoaring");
       System.out.println(cpu.getName());

    }
}

