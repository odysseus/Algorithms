package com.company.HW;

import com.company.ADTs.Stack;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by ryan on 6/22/14.
 */
public class Parentheses {

    public static String cleanString(String str) {
        char[] parens = {'(', ')', '{', '}', '[', ']'};
        String parsed = "";
        for (int i = 0; i < str.length(); i++) {
            for (int x = 0; x < parens.length; x++) {
                if (parens[x] == str.charAt(i)) {
                    parsed += str.charAt(i);
                }
            }
        }
        return parsed;
    }

    public static boolean test(String s) {
        String str = cleanString(s);
        if (str.length() % 2 != 0) {
            return false;
        }
        Hashtable<String, String> matches = new Hashtable<String, String>();
        matches.put("{", "}");
        matches.put("(", ")");
        matches.put("[", "]");
        Stack<String> stackOne = new Stack<String>();
        Stack<String> stackTwo = new Stack<String>();
        for (int i=0; i<str.length(); i++) {
            stackOne.push(Character.toString(str.charAt(i)));
        }
        while (!stackOne.isEmpty()) {
            String item = stackOne.pop();
            if (matches.containsKey(item)) {
                if (stackTwo.isEmpty()) {
                    return false;
                } else {
                    if (!matches.get(item).equals(stackTwo.pop())) {
                        return false;
                    }
                }
            } else {
                stackTwo.push(item);
            }
        }
        return true;
    }

}
