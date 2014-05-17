package utils;

public final class MessageType {
    public static final String AUTH = "AUTH";
    public static final String ACK = "ACK";
    public static final String NACK = "NACK";
    public static final String START_GAME = "START_GAME";
    public static final String QUESTION = "QUESTION";
    public static final String QUESTION_RESPONSE = "QUESTION_RESPONSE";
    public static final String QUESTION_ANSWER = "QUESTION_ANSWER";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String WRONG_TYPE = "WRONG_TYPE";
    public static final String END_GAME = "END_GAME";
    public static final String STOP_GAME = "STOP_GAME";
    
    private MessageType() {}  
}
