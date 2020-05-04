/**
 * 
 */
package com.cg.obs.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.model.Transaction;
import com.cg.obs.service.TransactionService;

/**
 * @author sohel
 *
 */
@RestController
public class TransactionController {
	@Autowired
	private TransactionService service;
	
	@GetMapping(path = "/transactions")
	public List<Transaction> getAllTransactions(){
		System.out.println("This will return list of all transactions");
		return service.findAll();
	}
	
	@GetMapping(path = "/transactions/{accountNo}")
	public List<Transaction> getTransactionByAccountNo(@PathVariable String accountNo){
		System.out.println("this will return transaction for account");
		return service.findAll().stream().filter(x->(x.getAccountNo().equals(accountNo))).collect(Collectors.toList());
	}
	
	@PostMapping(path = "/transactions/add")
	public String addTransaction(@RequestBody Transaction transaction) {
		System.out.println("this will add transaction into db");
		service.save(transaction);
		return "transaction added";
	}
}
