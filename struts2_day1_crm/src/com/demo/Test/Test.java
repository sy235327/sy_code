package com.demo.Test;
import java.io.File;
public class Test {
        public static void main(String[] args) {
            String path = "c:\\";
            Show(path);
        }

        static void Show(String path) {
            File f = new File(path);
            File[] files = f.listFiles();

            if (files == null){
                return;
            }

            for (File file : files) {
                if (file.isFile()) {
                    if (file.getPath().toUpperCase().endsWith(".TXT")) {
                        System.out.println(file.getPath());
                        break;
                    }
                } else {
                    Show(file.getPath());
                }

            }
        }

    }
