package Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
String a = "Toma";
String b = "Leonas";
            int number = randomNumber();
            randomNumber();
            String ID = a.toUpperCase().substring(0, 1) + "" + b.toUpperCase().substring(0, 1) + "" + number;
        System.out.println(ID);
        }

        private static int randomNumber() {
            int random = (int) Math.floor(Math.random() * 899)+100;
            return random;
        }
    }

