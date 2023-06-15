package io.itpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class client
{
    public static void main(String[] args) throws IOException
    {
        InetAddress ip = InetAddress.getLocalHost();
        int port = 8080;
        Scanner sc = new Scanner(System.in);

        Socket s = new Socket(ip, port);

        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter writer = new PrintWriter(s.getOutputStream(), true);

        while (true)
        {

            System.out.println("Enter the equation in the form: 'operand operator operand'");

            String input = sc.nextLine();

            if (input.equals("bye"))
                break;


            writer.println(input);

            String ans = reader.readLine();
            System.out.println("Answer: " + ans);
        }
    }
}
