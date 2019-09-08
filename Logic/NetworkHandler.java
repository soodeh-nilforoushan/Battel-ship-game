package ir.aut.test.Logic;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Queue;



/**
 * Created by Soudabeh2 on 6/4/2017.
 */

public class NetworkHandler extends Thread {


    private TcpChannel mTcpChannel;
    private Queue<byte[]> mSendQueue;
    private Queue<byte[]> mReceivedQueue;
    private ReceivedMessageConsumer mConsumerThread;
    private INetworkHandlerCallback miNetworkHandlerCallback;




    public NetworkHandler(SocketAddress socketAddress, INetworkHandlerCallback iNetworkHandlerCallback){

        mTcpChannel= new TcpChannel(socketAddress,100);
        miNetworkHandlerCallback= iNetworkHandlerCallback;
        NetworkHandler.currentThread().start();


    }


    public NetworkHandler(Socket socket, INetworkHandlerCallback iNetworkHandlerCallback){

        mTcpChannel= new TcpChannel(socket,100);
        miNetworkHandlerCallback= iNetworkHandlerCallback;
        NetworkHandler.currentThread().start();


    }

    /**
     * Add serialized bytes of message to the sendQueue.
     */
    public void sendMessage(BaseMessage baseMessage){

        mSendQueue.add(baseMessage.mSerialized);

    }

    /**
     * While channel is connected and stop is not called:
     * * if sendQueue is not empty, then poll a message and send it
     * * else if readChannel() is returning bytes, then add it to receivedQueue.
     */
    @Override
    public void run() {

        while (mTcpChannel.isConnected() && mConsumerThread.isAlive()){ //*************** hatman check ************//

            if(!(mSendQueue.isEmpty())){
                try {

                    // mTcpChannel.write(mSendQueue.poll());
                    miNetworkHandlerCallback.onMessageReceived(new RequestLoginMessage(mSendQueue.poll()));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else  if(readChannel().length !=0 ){
                mReceivedQueue.add(readChannel());
            }

        }


    }



    /**
     * Kill the thread and close the channel.
     */
    public void stopSelf(){

        try {
            mConsumerThread.sleep(100);
            NetworkHandler.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mConsumerThread.interrupt();
        NetworkHandler.currentThread().interrupt();
        //********************** injoori kill konaaaam?? *****************//


        mTcpChannel.closeChannel();
    }

    /**
     * Try to read some bytes from the channel.
     */
    private byte[] readChannel(){

        return mTcpChannel.read(mReceivedQueue.size());

      //  return new byte[0];

    }

    private class ReceivedMessageConsumer extends Thread {


        @Override
        public void run(){

            while (mTcpChannel.isConnected() && mConsumerThread.isAlive()){
                if(!(mReceivedQueue.isEmpty())){

                    byte[] arrayOfByte = mReceivedQueue.poll();

                    switch (arrayOfByte[5]){

                        case(2):
                            //SelectConnectionMode selectConnectionMode= new SelectConnectionMode(arrayOfByte);
                            //  miNetworkHandlerCallback.onMessageReceived(selectConnectionMode);

                            break;




                    }




                }
                else if(mReceivedQueue.isEmpty()){
                    ReceivedMessageConsumer receivedMessageConsumer= new ReceivedMessageConsumer();
                    try {
                        receivedMessageConsumer.sleep(100);  //********** injoorieeee*************/
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }

    public interface INetworkHandlerCallback {

        void onMessageReceived(BaseMessage baseMessage);
        void onSocketClosed();

    }

}