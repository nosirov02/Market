package uz.isystem.market.exception;

public class ServerBadRequestException extends RuntimeException{
    public ServerBadRequestException(String message){
        super(message);
    }
}
