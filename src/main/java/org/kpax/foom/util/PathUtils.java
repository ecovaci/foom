package org.kpax.foom.util;

import org.apache.commons.lang3.Validate;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PathUtils {

    private PathUtils() {
    }

    public static String toClassName (String pathSegment) {
        Validate.isTrue(pathSegment != null && pathSegment.endsWith(".class"),
                "Invalid filename [%s]. It cannot be null and must end with '.class'", pathSegment);
        String className = pathSegment.replace(File.separatorChar, '.');
        return className.substring(0, className.length() - ".class".length());
    }

}
