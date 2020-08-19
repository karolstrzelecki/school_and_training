package com.KarolStrzelecki;



import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Echoer extends Thread {
    private Socket socket;



    public Echoer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            StringTokenizer st;
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            //PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            //String message = "Hello in our Server- Socket app";

            //output.println(message);

            while(true) {
                List<String> mList= new ArrayList();
                String echoString = input.readLine();
                if(echoString != null) {

                    st = new StringTokenizer(echoString, " ");

                    while (st.hasMoreTokens()) {
                        mList.add(st.nextToken());
                    }
                }


                if(mList.size() == 2) {
                    if (mList.get(0).equals("exit")) {
                        break;
                    }
                    if (mList.get(0).equals("download")) {
                        //output.println("Server is sending file: " + mList.get(1));
                        sendFile(mList.get(1));
                        break;


                    }
                    if (mList.get(0).equals("upload")) {
                        System.out.println("uploading");
                        upload(mList.get(1));
                        break;
                    }
                }

            }

        } catch(IOException e) {
            System.out.println("Oops: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch(IOException e) {
            }
        }

    }

    private void sendFile(String source) {



        String dir = System.getProperty("user.dir") + System.getProperty("file.separator") + source;

        try {
            File myFile = new File(dir);

            byte[] fileData = new byte[(int) myFile.length()];
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
            bis.read(fileData, 0, fileData.length);
            OutputStream os = socket.getOutputStream();
            socket.isConnected();
            os.write(fileData, 0, fileData.length);
            os.flush();

            System.out.println("sent");

            bis.close();




        }catch(Exception ex){
            System.out.println(ex.getMessage());
           // ex.printStackTrace();
        }


    }


    private void upload(String fileName){

        String dir = System.getProperty("user.dir") + System.getProperty("file.separator") + fileName;
        ObjectInputStream ois = null;

try {
    ois = new ObjectInputStream(socket.getInputStream());
    File file = new File(dir);
    byte[] content = (byte[]) ois.readObject();

    Files.write(file.toPath(), content);
    System.out.println("Done");
}catch(Exception ex){
    System.out.println(ex.getMessage());
    try{
        ois.close();
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}

    }


}

