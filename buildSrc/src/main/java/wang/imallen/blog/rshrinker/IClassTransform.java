package wang.imallen.blog.rshrinker;

import java.nio.file.Path;

/**
 * author: AllenWang
 * date: 2020-02-23
 */
public interface IClassTransform {
    byte[] apply(String className, byte[] origin, Path path);
}
