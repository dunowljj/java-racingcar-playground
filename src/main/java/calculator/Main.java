package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



//        String input = sc.nextLine();
        String input = br.readLine();

        int result = stringAddCalculator.splitAndSum(input);
        System.out.println(result);
        }
    }
