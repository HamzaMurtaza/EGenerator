/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.lang.StringBuilder;

/**
 *
 * @author Hamza
 */
public class DigitFilter extends DocumentFilter{

//    @Override
//    public void insertString(String text) throws BadLocationException {
//       // super.insertString(fb, offset, revise(text), attr);
//    }



    public String revise(String text) {
        @SuppressWarnings("ReplaceStringBufferByString")
        StringBuilder builder = new StringBuilder(text);
        int index = 0;
        while (index < builder.length()) {
            if (accept(builder.charAt(index))) {
                index++;
            } else {
                // Don't increment index here, or you'll skip the next character!
                builder.deleteCharAt(index);
            }
        }
        return builder.toString();
    }

    public boolean accept(final char c) {
        return Character.isDigit(c) || c == '.';
    }

}
