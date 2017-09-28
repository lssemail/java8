package part01.chapt02.impl;

import part01.chapt02.interfaces.AppleFormatter;
import part01.model.Apple;

/**
 * Created by lssemail on 2017/8/11.
 */
public class ApplePrintWeightPredicate implements AppleFormatter {

    @Override
    public String accept(Apple apple) {

        return apple.getName();
    }
}
