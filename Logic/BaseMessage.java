package ir.aut.test.Logic;

/**
 * Created by Soudabeh on 6/20/2017.
 */
public abstract class BaseMessage {

    protected byte[] mSerialized;

    /**
     * Fields are stored into serial bytes in this method.
     */
    protected abstract void serialize();

    /**
     * Fields are restored from serial bytes in this method.
     */
    protected abstract void deserialize();

    /**
     * Return message type code.
     */
    public abstract byte getMessageType();  //

    public byte[] getSerialized() {
        return mSerialized;
    }
}
