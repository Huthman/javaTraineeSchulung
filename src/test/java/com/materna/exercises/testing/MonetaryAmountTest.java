package com.materna.exercises.testing;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MonetaryAmountTest {


  @Nested
  class of {
    @Test
    void ofNegative() {
      assertThatIllegalArgumentException().isThrownBy(() -> {
        MonetaryAmount.of(-1);
      });
    }

    @Test
    void ofPositive() {
      assertThat(MonetaryAmount.of(1).value()).isEqualTo(1d);
    }
  }


  @Test
  void value() {
    assertThat(MonetaryAmount.of(5).value()).isEqualTo(5d);
  }


  @Test
  void testToString() {
    assertThat(MonetaryAmount.of(5).toString()).isEqualTo("MonetaryAmount[value: 5]");
    assertThat(MonetaryAmount.of(5.12345).toString()).isEqualTo("MonetaryAmount[value: 5.12345]");
  }

  @Nested
  class equals {
    MonetaryAmount five = MonetaryAmount.of(5);

    @Test
    void equalsMonetaryAmountTrue() {
      assertThat(MonetaryAmount.of(5)).isEqualTo(MonetaryAmount.of(5));
    }

    @Test
    void equalsMonetaryAmountFalse() {
      assertThat(five).isNotEqualTo(MonetaryAmount.of(6));
    }

    @Test
    void equalsNull() {
      assertThat(five).isNotEqualTo(null);
    }

    @Test
    void equalsObject() {
      assertThat(five).isNotEqualTo(new Object());
    }
  }

  @Test
  void add() {
    MonetaryAmount five = MonetaryAmount.of(5);
    MonetaryAmount ten = MonetaryAmount.of(10);
    assertThat(five.add(ten).value()).isEqualTo(15d);
  }

  @Nested
  class subtract {
    MonetaryAmount one = MonetaryAmount.of(1);
    MonetaryAmount two = MonetaryAmount.of(2);

    @Test
    void subtractWithNegativeResult() {
      assertThatIllegalArgumentException().isThrownBy(() -> {
        one.subtract(two);
      });
    }

    @Test
    void subtractWithPositiveResult() {
      assertThat(two.subtract(one).value()).isEqualTo(1d);
    }
  }

}