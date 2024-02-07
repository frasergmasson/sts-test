package sts.test.validator;



public class CompletedValidator implements Validator{

    @Override
    public boolean isValid(byte[] message){
        return true;
    }

}