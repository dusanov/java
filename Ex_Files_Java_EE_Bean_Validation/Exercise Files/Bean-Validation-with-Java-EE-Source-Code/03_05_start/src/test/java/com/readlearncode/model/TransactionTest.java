package com.readlearncode.model;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.text.ParseException;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class TransactionTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void givenTransactionPOJO_whenDataNull_shouldNotValidate() throws ParseException {
        Transaction transaction = new Transaction();
        transaction.setQuantity(null);
        transaction.setPriceLimit(null);
        transaction.setType(null);
        transaction.setStock(null);
        transaction.setExerciseDate(null);

        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);
        assertThat(violations.size()).isEqualTo(5);
    }

    @Test
    public void givenTransactionPOJO_whenDataInvalid_shouldNotValidate() {

    }

    @Test
    public void givenTransactionPOJO_whenPriceHasLongFraction_shouldNotValidate() {

    }

    @Test
    public void givenTransactionPOJO_whenPriceHasLongIntegral_shouldNotValidate() {

    }

    @Test
    public void givenTransactionPOJO_whenPriceIsZero_shouldNotValidate() {

    }

    @Test
    public void givenTransactionPOJO_whenPriceIsNegative_shouldNotValidate() {

    }
}