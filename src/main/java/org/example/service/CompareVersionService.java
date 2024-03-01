package org.example.service;

import org.example.exception.CompareVersionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareVersionService {

    public int compareVersion(String version1, String version2) throws CompareVersionException {
        if (checkLength(version1) && checkLength(version2)) {
            if (matchesRegex(version1) && matchesRegex(version2)) {
                String[] v1 = version1.split("\\.");
                String[] v2 = version2.split("\\.");
                int n1 = v1.length;
                int n2 = v2.length;

                if (checkValidVersion(n1) && checkValidVersion(n2)) {
                    for (int i = 0; i < Math.max(n1, n2); i++) {
                        int num1 = i < n1 ? Integer.parseInt(v1[i]) : 0;
                        int num2 = i < n2 ? Integer.parseInt(v2[i]) : 0;

                        if (num1 < num2) {
                            return -1;
                        } else if (num1 > num2) {
                            return 1;
                        }
                    }
                } else {
                    throw new CompareVersionException("version1 and version2 are valid version numbers.");
                }
            } else {
                throw new CompareVersionException("version1 and version2 only contain digits and '.'");
            }
        }else {
            throw new CompareVersionException("1 <= version1.length, version2.length <= 500");
        }

        return 0;
    }

    public boolean matchesRegex(String input) {
        Pattern pattern = Pattern.compile("^[0-9.]+$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public boolean checkLength(String input) {
        return 1 <= input.length() && input.length() <= 500;
    }

    public boolean checkValidVersion(int input) {
        return 1 < input;
    }
}
