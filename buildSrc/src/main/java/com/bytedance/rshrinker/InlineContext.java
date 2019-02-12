package com.bytedance.rshrinker;

import java.util.ArrayList;
import java.util.List;

/**
 * author: AllenWang
 * date: 2019/2/12
 */
public class InlineContext {

    public static ShrinkerExtension config;

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
                System.out.println("after parse,pkg:" + pkg)
        );

    }
}
