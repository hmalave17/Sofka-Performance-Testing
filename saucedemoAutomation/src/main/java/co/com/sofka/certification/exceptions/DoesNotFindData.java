package co.com.sofka.certification.exceptions;

public class DoesNotFindData extends AssertionError{
    public static final String NO_DATA_FOUND = "No data found";
    public DoesNotFindData(){
        super(NO_DATA_FOUND);
    }
}