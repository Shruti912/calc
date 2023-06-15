package io.itpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class server
{
    public static void main(String args[]) throws IOException
    {
        ServerSocket ss = new ServerSocket(8080);
        Socket s = ss.accept();

        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter writer = new PrintWriter(s.getOutputStream(), true);

        while (true)
        {
            String input = reader.readLine();

            if (input.equals("bye"))
                break;

            System.out.println("Equation received: " + input);
            float result;

            StringTokenizer st = new StringTokenizer(input);

            float oprnd1 = Float.parseFloat(st.nextToken());
            String operation = st.nextToken();
            float oprnd2 = Float.parseFloat(st.nextToken());

            if (operation.equals("+"))
            {
                result = oprnd1 + oprnd2;
            }
            else if (operation.equals("-"))
            {
                result = oprnd1 - oprnd2;
            }
            else if (operation.equals("*"))
            {
                result = oprnd1 * oprnd2;
            }
            else if (operation.equals("^"))
            {
                result = (float) Math.pow(oprnd1, oprnd2);
            }
            else
            {
                result = oprnd1 / oprnd2;
            }
            System.out.println("Sending the result...");

            writer.println(result);
        }
    }
}
