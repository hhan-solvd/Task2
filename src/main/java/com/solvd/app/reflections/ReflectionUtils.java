package com.solvd.app.reflections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class ReflectionUtils {
    private static final Logger LOGGER = LogManager.getLogger(ReflectionUtils.class);

    // Get and print the names, types and modifiers of fields
    public static void printFields(Class<?> className) {
        LOGGER.info("-------------Field List----------------");
        Field[] fields = className.getDeclaredFields();
        for (Field field : fields) {
            LOGGER.info("Field: " + field.getName() +
                    ", Type: " + field.getType() + ", " +
                    "Modifiers: " + Modifier.toString(field.getModifiers()));
        }
    }

    // Get and print the names, number of parameters and modifiers of constructors
    public static void printConstructors(Class<?> className) {
        LOGGER.info("-------------Constructor List----------------");
        Constructor<?>[] constructors = className.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            LOGGER.info("Constructor: " + constructor.getName() +
                    ", Number of parameters: " + constructor.getParameterCount() +
                    ", Modifiers: " + Modifier.toString(constructor.getModifiers()));
        }
    }

    // Get and print the names, return type, number of parameters and modifiers of methods
    public static void printMethods(Class<?> className) {
        LOGGER.info("-------------Method List----------------");
        Method[] methods = className.getDeclaredMethods();
        for (Method method : methods) {
            LOGGER.info("Method: " + method.getName() +
                    ", Return type: " + method.getReturnType() +
                    ", Number of parameters: " + method.getParameterCount() +
                    ", Modifiers: " + Modifier.toString(method.getModifiers()));
        }
    }
}
