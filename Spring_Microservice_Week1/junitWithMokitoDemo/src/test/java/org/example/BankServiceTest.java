package org.example;

import org.example.dao.BankDAO;
import org.example.model.SCBAccount;
import org.example.model.Transaction;
import org.example.service.BankService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BankServiceTest {

    @Mock
    private BankDAO bankDAO;

    @InjectMocks
    private BankService bankService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeposit() {
        
        SCBAccount account = new SCBAccount("123", "Vivek Adarsh", new Date(), "Savings", 100.0, new ArrayList<>());
        Transaction transaction = new Transaction(1, new Date());
        double amount = 50.0;
        
        when(bankDAO.deposit(account, amount, transaction)).thenReturn(true);
        
        boolean depositSuccessful = bankService.deposit(account, amount, transaction);
        
        assertEquals(true, depositSuccessful);
        
        verify(bankDAO, times(1)).deposit(account, amount, transaction);
    }

    @Test
    public void testWithdraw() {
       
        SCBAccount account = new SCBAccount("123", "Vivek Adarsh", new Date(), "Savings", 100.0, new ArrayList<>());
        Transaction transaction = new Transaction(2, new Date());
        double amount = 30.0;

        
        when(bankDAO.withdraw(account, amount, transaction)).thenReturn(true);

        
        boolean withdrawSuccessful = bankService.withdraw(account, amount, transaction);

     
        assertEquals(true, withdrawSuccessful);

    
        verify(bankDAO, times(1)).withdraw(account, amount, transaction);
    }

    @Test
    public void testCheckBalance() {
      
        SCBAccount account = new SCBAccount("123", "Vivek Adarsh", new Date(), "Savings", 100.0, new ArrayList<>());

        
        when(bankDAO.checkBalance(account)).thenReturn(100.0);

        
        double balance = bankService.checkBalance(account);

        
        assertEquals(100.0, balance, 0.001); // Use delta for double comparison

        
        verify(bankDAO, times(1)).checkBalance(account);
    }
}
