package org.kpax.foom.util;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ClassUtils {

    private static Logger logger = LoggerFactory.getLogger(ClassUtils.class);

    private ClassUtils() {
    }

    public static List<String> listClassNames(String jarPath) throws IOException {
        List<String> classNames = new ArrayList<String>();
        ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
            if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                String className = entry.getName().replace('/', '.');
                classNames.add(className.substring(0, className.length() - ".class".length()));
            }
        }
        return classNames;
    }

    public static ClassLoader createClassLoader(List<String> locations)
            throws IOException {
        if (CollectionUtils.isEmpty(locations)) {
            throw new IllegalArgumentException("At least one classpath location is required");
        }
        List<URL> urls = new ArrayList<>();
        for (String location : locations) {
            Path locationPath = Paths.get(location);
            if (Files.exists(locationPath)) {
                urls.add(locationPath.toUri().toURL());
            } else {
                throw new IllegalArgumentException("The classpath location [" + location + "] does not exist!");
            }
        }
        logger.debug("urls {}", urls);
        return new URLClassLoader(urls.toArray(new URL[urls.size()]), null);
    }

}
