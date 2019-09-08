package ir.aut.test.Logic;

import ir.aut.test.view.GuestList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.List;

/**
 * Created by Soudabeh on 6/20/2017.
 */

public class MessageManager implements ServerSocketHandler.IServerSocketHandlerCallback, NetworkHandler.INetworkHandlerCallback {

    private ServerSocketHandler mServerSocketHandler;
    private List<NetworkHandler> mNetworkHandlerList;
    InetSocketAddress inetSocketAddress;
    private  NetworkHandler networkHandler;
    String name ;



    /**
     * Instantiate server socket handler and start it. (Call this constructor in host mode)
     */
    public MessageManager(int port) {

        try {

            mServerSocketHandler= new ServerSocketHandler(port,this,this);

            //mServerSocketHandler.start();  // dorosteeee?????


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Instantiate a network handler and start it. (Call this constructor in guest mode)
     */

    public MessageManager(String ip, int port) {

        //mode guest
        try {

            inetSocketAddress= new InetSocketAddress(ip,port);
            networkHandler= new NetworkHandler(inetSocketAddress ,this);
            mNetworkHandlerList.add(networkHandler);
            //  networkHandler.start();




        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private void sendRequestLoginMessage(String username){

        RequestLoginMessage requestLoginMessage = new RequestLoginMessage(username);
        networkHandler.sendMessage(requestLoginMessage);

    }


    private void consumeRowMessage(RequestLoginMessage message){

        name= message.getUsername();
        GuestList guestList= new GuestList(name);


    }




    @Override
    public void onMessageReceived(BaseMessage baseMessage) {

        switch (baseMessage.getMessageType()) {

            case MessageTypes.SELECT_CONNECTION_MODE :
                //  consumeSelectConnectionMode((SelectConnectionMode) baseMessage);
                break;


        }
    }



    @Override
    public void onSocketClosed() {




    }



    @Override
    public void onNewConnectionReceived(NetworkHandler networkHandler) {

        mNetworkHandlerList.add(networkHandler);

    }
}