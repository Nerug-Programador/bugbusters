package com.nerugdev.bugbusters.usuario;

public enum Stack {
    PYTHON,
    JAVASCRIPT,
    JAVA,
    GOLANG,
    RUBY,
    SWIFT,
    KOTLIN;

    public static Stack fromString(String stack) {
        return Stack.valueOf(stack.toUpperCase()); // Convierte el string a mayúsculas
    }
}