package com.techelevator.view;

import com.techelevator.MoneyCounter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoneyCounterTest {

    @Test
    public void FeedMoneyTest() {
        MoneyCounter feedMoney = new MoneyCounter(5.00, 5);
        feedMoney.feedMoney(5);
        assertEquals(10.00, feedMoney.getCurrentBalance(),0);
        feedMoney.feedMoney(-10);
        assertEquals(10, feedMoney.getCurrentBalance(), 0);
    }
    @Test
    public void FinishTransactionTest() {
        MoneyCounter finishTransaction = new MoneyCounter(5.00, 5);
        finishTransaction.finishTransaction();
        assertEquals(0, finishTransaction.getCurrentBalance(), 0);
    }

}
