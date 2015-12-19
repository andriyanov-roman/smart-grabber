package tldpack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Random;


public class RandomPassGenerator{
    private static final int charactersSize = 100;
    private static char [] characters = new char [charactersSize];
    private static int charactersCount = 0;
    private int passwordSize;

    public RandomPassGenerator(){
    passwordSize=10;
        initCharacters();
    }

    public RandomPassGenerator( int passwordSize ) {
        this.passwordSize = passwordSize;

        // set the characters that will be used to generate the pas
        initCharacters();
    }


    // METHODS
    // fill the array of characters that will be used to generate the password

    private static char [] initCharacters() {
        int i = 0;

        // add 0-9
        for ( int j = 48; j < 58; ++i, ++j, ++charactersCount ) {
            characters[i] = (char) j;
        }

        // add @ + a-z
        for ( int j = 64; j < 91; ++i, ++j, ++charactersCount ) {
            characters[i] = (char) j;
        }

        // add A-Z
        for ( int j = 97; j < 123; ++i, ++j, ++charactersCount ) {
            characters[i] = (char) j;
        }

        return characters;
    }

    // generate a random password
    public String get() {

        // initialize the random number generator
        Random rnd = new Random();

        char [] password = new char [passwordSize];


        // choose a random character from the array
        for ( int i = 0; i < passwordSize; ++i ) {
            password[i] = characters[ rnd.nextInt(charactersCount) ];
        }

        return String.valueOf(password);
    }

/*public void showCharacters() {
        for ( int i = 0; i < charactersCount && characters[i] != 0; ++i ) {
            System.out.println(characters[i]);
        }
    }

    public static void main(String[] args) {
        int passwordSize = 10;
        RandomPassGenerator password = new RandomPassGenerator(passwordSize );
        System.out.println( password.get());
    }*/
}
