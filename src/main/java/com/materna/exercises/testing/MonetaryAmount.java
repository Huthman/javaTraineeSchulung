package com.materna.exercises.testing;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Represents an amount of Money. The Amount may not be negative.
 */
public class MonetaryAmount implements Serializable {
  private final double value;
  private MonetaryAmount(double value) {
    this.value = value;
  }

  // Erzeugen von immutable MonetaryAmount-Objekten durch Fabrikmethode

  /**
   * Factory Method to generate a MonetaryAmount Object with given value
   * @param value the MonetaryAmount value. May not be negative.
   * @return generated MonetaryAmount object
   */
  public static MonetaryAmount of( double value ) {
    if(value < 0){
      throw new IllegalArgumentException("Value may not be smaller than zero. Given value: "+value);
    }
    return new MonetaryAmount(value);
  }

  // liefert den Wert

  /**
   * Returns the Value of the called upon Monetary Amount Object
   * @return the Value
   */
  public double value() {
    return value;
  }

  /**
   * Generates a String representation of the MonetaryAmount object
   * @return the String representation
   */
  public String toString() {
    return String.format("MonetaryAmount[value: %s]",
            new DecimalFormat("#.######", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(value));
  }

  // MonetaryAmount-Objekte soll man mit equals(Object o) vergleichen können

  /**
   * Compares the MonetaryAmount object with any other Object
   * @param o the Object to be compared to
   * @return true if the given parameter is of type MonetaryAmount and has the same value
   */
  public boolean equals( Object o ) {
    return o instanceof MonetaryAmount monetaryAmount && value == monetaryAmount.value;
  }

  //

  /**
   * Adds up the called upon MonetaryAmount with a given one and returns a new MonetaryAmount
   * object with the combined value
   * @param amount the MonetaryAmount to be added to the called upon
   * @return a new MonetaryAmount object with the combined values
   */
  public MonetaryAmount add( MonetaryAmount amount ) {
    return MonetaryAmount.of(value+amount.value);
  }

  /**
   * Subtracts the value of the MonetaryAmount parameter from the value of the called upon
   * MonetaryAmount and returns the result as a MonetaryAmount object
   * @param amount the MonetaryAmount to be subtracted from the called upon.
   * @return a new MonetaryAmount object with the subtracted values.
   */
  public MonetaryAmount subtract( MonetaryAmount amount ) {
    double result = value - amount.value();
    if(result < 0){
      throw new IllegalArgumentException("Value of amount is greater than the value of the called" +
              " upon object resulting in a negative value.");
    }
    return MonetaryAmount.of(result);
  }

  @Override
  public int hashCode() {
    return Double.hashCode(value);
  }
}
