package ir.aut.test.Logic;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Soudabeh on 6/4/2017.
 */

public class ServerSocketHandler extends Thread {

    private ServerSocket serverSocket;
    private Socket connection;

    private NetworkHandler.INetworkHandlerCallback iNetworkHandlerCallback;
    private ServerSocketHandler.IServerSocketHandlerCallback iServerSocketHandlerCallback;

    public ServerSocketHandler(int port, NetworkHandler.INetworkHandlerCallback iNetworkHandlerCallback,
                               IServerSocketHandlerCallback iServerSocketHandlerCallback) {

        this.iNetworkHandlerCallback = iNetworkHandlerCallback;
        this.iServerSocketHandlerCallback = iServerSocketHandlerCallback;

        try {
            this.serverSocket = new ServerSocket(port);
            ServerSocketHandler.currentThread().start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * While server socket is connected and stop is not called:
     * * if a connection receives, then create a network handler and pass it through onNewConnectionReceived
     * * else sleep for 100 ms.
     */
    @Override
    public void run() {

        while (!serverSocket.isClosed() && !isInterrupted()) {


            try {
                this.connection = serverSocket.accept();
                if (this.connection.isConnected()) {

                    NetworkHandler networkHandler = new NetworkHandler(connection, iNetworkHandlerCallback);
                    iServerSocketHandlerCallback.onNewConnectionReceived(networkHandler);


                } else try {
                    ServerSocketHandler.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    /**
     * Kill the thread and close the server socket.
     */
    public void stopSelf() {


        try {
            ServerSocketHandler.currentThread().sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ServerSocketHandler.currentThread().interrupt();
    }


    public interface IServerSocketHandlerCallback {

        void onNewConnectionReceived(NetworkHandler networkHandler);

    }
}
