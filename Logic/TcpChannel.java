package ir.aut.test.Logic;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.*;


/**
 * Created by Soudabeh1 on 6/4/2017.
 */
public class TcpChannel {

    private Socket mSocket;
    private OutputStream mOutputStream;  // ro shabake chizi bnevisim
    private InputStream mInputStream;   //  az shabake chizi bkhoonim


    public TcpChannel(SocketAddress socketAddress, int timeout) throws IOException {

        // to halate guest hast

        this.mSocket = new Socket();
        mSocket.connect(socketAddress,timeout);
        this.mInputStream=mSocket.getInputStream();

    }

    public TcpChannel(Socket socket, int timeout){

        // to halate host hast

        this.mSocket=socket;
        try {
            mSocket.setSoTimeout(timeout);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            this.mInputStream=mSocket.getInputStream();
            this.mOutputStream= mSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /**
     * Try to read specific count from input stream.
     */
    public byte[] read(final int count) throws IOException{

        byte[] buffer = new byte[count];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int read = 0;
        while ((read = mInputStream.read(buffer, 0, buffer.length)) != -1) {
            baos.write(buffer, 0, read);
        }
        baos.flush();
        return baos.toByteArray();

    }



    /**
     * Write bytes on output stream.
     */
    public void write(byte[] data) throws IOException{

        mOutputStream = new ByteArrayOutputStream(data.length);
        mOutputStream.write(data, 0, data.length);
        mOutputStream.flush();

    }

    /**
     * Check socket’s connectivity.
     */
    public boolean isConnected(){

        if(mSocket.isConnected())
            return true;

        return false;
    }


    /**
     * Try to close socket and input-output streams.
     */
    public void closeChannel() throws IOException{

        mSocket.close();
        mInputStream.close();
        mOutputStream.close();
    }


}