package wang.imallen.blog.rshrinker;

import java.util.ArrayList;
import java.util.List;

import wang.imallen.blog.rshrinker.log.Logger;

/**
 * author: AllenWang
 * date: 2019/2/12
 */
public class InlineContext {

    public static DetectClassExtension config;

    public static void parseShrinkerExtension() {
        if (config.skipRPkgs == null || config.skipRPkgs.size() < 1) {
            return;
        }
        List<String> pkgs = new ArrayList<>();
        config.skipRPkgs.forEach(pkg ->
                pkgs.add(pkg.replace(".", "/"))
        );
        config.skipRPkgs = pkgs;

        config.skipRPkgs.forEach(pkg ->
                Logger.i("after parse,pkg:" + pkg)
        );

        List<String> tmpClasses = new ArrayList<>();
        config.targetClasses.forEach(clazzName ->
                tmpClasses.add(clazzName.replace(".", "/"))
        );
        config.targetClasses = tmpClasses;
    }
}
