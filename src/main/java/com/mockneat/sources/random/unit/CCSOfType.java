package com.mockneat.sources.random.unit;

import com.mockneat.sources.random.Rand;
import com.mockneat.sources.random.unit.interfaces.RandUnitGeneric;
import com.mockneat.types.enums.CreditCardType;

import java.util.Arrays;
import java.util.List;

import static com.mockneat.utils.NextUtils.checkCreditCardTypeNotNull;

/**
 * Created by andreinicolinciobanu on 27/01/2017.
 */
public class CCSOfType implements RandUnitGeneric<String> {

    private Rand rand;
    private CreditCardType type;

    public CCSOfType(Rand rand, CreditCardType creditCardType) {
        this.rand = rand;
        this.type = creditCardType;
    }

    /**
     * Returns a Credit Card Number number
     * @return
     */
    @Override
    public String val() {

        checkCreditCardTypeNotNull(type);

        int arraySize = type.getLength();
        int cnt = arraySize - 1;

        int[] results = new int[arraySize];

        // Pick random prefix
        List<Integer> prefix = rand.objs().from(type.getPrefixes()).val();

        // Initialize the array with random numbers
        // prefix + rest of the arrays
        for (int i = 0; i < cnt; i++)
            results[i] = (i < prefix.size()) ? prefix.get(i) :
                    rand.ints().inRange(0, 10).val();

        // Computing sum
        boolean dblFlag = true;
        int sum = 0;
        int dbl;
        while (cnt-- > 0) {
            if (dblFlag) {
                dbl = 2 * results[cnt];
                sum += (dbl > 9) ? (dbl % 10 + 1) : dbl;
            } else {
                sum += results[cnt];
            }
            dblFlag = !dblFlag;
        }
        // Add the check digit
        results[arraySize - 1] = (9 * sum) % 10;

        // Returning result
        StringBuilder buff = new StringBuilder();
        Arrays.stream(results).forEach(buff::append);
        return buff.toString();
    }
}
