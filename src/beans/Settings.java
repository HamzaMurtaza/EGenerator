/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settings implements Serializable {
    
    private int numberOfQuestions;
    private double priorityPercent1;
    private double priorityPercent2;
    private double priorityPercent3;
    
}
