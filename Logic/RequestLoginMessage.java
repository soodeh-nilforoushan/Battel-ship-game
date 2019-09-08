package ir.aut.test.Logic;


import java.nio.ByteBuffer;


/**
 * Created by Soudabeh4 on 6/4/2017.
 */



public class RequestLoginMessage extends BaseMessage {

    private String mUsername;


    public RequestLoginMessage(String username) {
        mUsername = username;

        serialize();
    }

    public RequestLoginMessage(byte[] serialized) {

        mSerialized = serialized;
        deserialize();
    }

    @Override
    protected void serialize() {

        int usernameLength = mUsername.getBytes().length;

        int messageLength = 4 + 1 + 1 + 4 + usernameLength;
        ByteBuffer byteBuffer = ByteBuffer.allocate(messageLength);
        byteBuffer.putInt(messageLength);
        byteBuffer.put(MessageTypes.PROTOCOL_VERSION);
        byteBuffer.put(MessageTypes.REQUEST_LOGIN);
        byteBuffer.putInt(usernameLength);
        byteBuffer.put(mUsername.getBytes());
        mSerialized = byteBuffer.array();
    }

    @Override
    protected void deserialize() {

        ByteBuffer byteBuffer = ByteBuffer.wrap(mSerialized);
        int messageLength = byteBuffer.getInt();
        byte protocolVersion = byteBuffer.get();
        byte messageType = byteBuffer.get();

        int usernameLength = byteBuffer.getInt();
        byte[] usernameBytes = new byte[usernameLength];
        byteBuffer.get(usernameBytes);
        mUsername = new String(usernameBytes);

        int passwordLength = byteBuffer.getInt();
        byte[] passwordBytes = new byte[passwordLength];
        byteBuffer.get(passwordBytes);

    }

    @Override
    public byte getMessageType() {
        return MessageTypes.REQUEST_LOGIN;
    }

    public String getUsername() {
        return mUsername;
    }


}