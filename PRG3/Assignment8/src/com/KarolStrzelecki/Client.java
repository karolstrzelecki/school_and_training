package com.KarolStrzelecki;



import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Client {
    Socket socket1;



    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {

            socket.setSoTimeout(5000);
            BufferedReader echoes = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")) {
                    response = echoes.readLine();
                    System.out.println(response);
                }
            } while (!echoString.equals("exit"));
        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch (IOException e) {
            System.out.println("Client Error: " + e.getMessage());

        }
    }

//    private void getFile() {
//
//
//        byte[] mybytearray = new byte[FILE_SIZE];
//        InputStream is = socket1.getInputStream();
//        fos = new FileOutputStream(FILE_TO_RECEIVED);
//        bos = new BufferedOutputStream(fos);
//        bytesRead = is.read(mybytearray, 0, mybytearray.length);
//        current = bytesRead;
//
//        do {
//            bytesRead =
//                    is.read(mybytearray, current, (mybytearray.length - current));
//            if (bytesRead >= 0) current += bytesRead;
//        } while (bytesRead > -1);
//
//        bos.write(mybytearray, 0, current);
//        bos.flush();
//        System.out.println("File " + FILE_TO_RECEIVED
//                + " downloaded (" + current + " bytes read)");

    }


    public void obtain(String serverIp, int serverPortNumber, String fileName) {

        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            System.out.println("Downloading file: " + fileName + " from: " + serverIp +" port: " + serverPortNumber );
            System.out.println("                                                   ");

            Socket s = new Socket(serverIp, serverPortNumber);
            oos = new ObjectOutputStream(s.getOutputStream());
            PrintWriter stringToEcho = new PrintWriter(s.getOutputStream(), true);


            // ========== TUTAJ =========================

            ois = new ObjectInputStream(s.getInputStream());
            String path = getPath();
            path = path + fileName;
            File file = new File(getPath() + message.getFileRequested());
            byte[] content = (byte[]) ois.readObject();

            Files.write(file.toPath(), content);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(fileName + " zostal prawidlowo sciagniety!  ");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }catch(Exception e){

            try {
                ois.close();
                oos.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }


}



