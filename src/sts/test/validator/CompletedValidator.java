package sts.test.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CompletedValidator implements Validator{

    final Pattern pattern;
    final byte DLE = 0x10;

    private String convertBytesToString(byte[] message){
        String[] stringBytes = new String[message.length];
        for(int i=0;i<message.length;i++){
            stringBytes[i] = String.format("0x%02X", message[i]);
        }
        return String.join("",stringBytes);
    }

    //Use regex to check the format of the message is correct
    private boolean checkFormat(String message){
        Matcher matcher = pattern.matcher(message);
        return matcher.matches(); 
    }

    private boolean checkLRC(byte[] message){
        byte calculatedLRC = 0;
        for(int i=1;i<message.length-1;i++){ //Start and end are set to disclude STX and LRC
            if (message[i] != DLE || message[i-1] == DLE){ // XOR is not performed if the value is DLE
                calculatedLRC ^= message[i];
            }
        }  
        return calculatedLRC==message[message.length-1];
    } 


    @Override
    public boolean isValid(byte[] message){
        String stringMessage = convertBytesToString(message);
        return checkFormat(stringMessage) && checkLRC(message); 
    }

    public CompletedValidator(){
        String regEx = 
            "0x02" // STX
            + "(" // Data
                + "0x100x(02|03|10)" //0x10 followed by a byte that needs to be escaped
                + "|(0x(0[^23]|(1[^0])|[^01].))" //Any byte that does not need to be escaped (not 0x02,0x03,or0x10)
            + ")*"// Zero or more bytes
            + "0x03" // ETX
            + "0x.."; // LRC

        pattern = Pattern.compile(regEx);
    }

}