package com.minibank.accounts.service.impl;

import com.minibank.accounts.dto.AccountsDto;
import com.minibank.accounts.dto.CustomerDto;
import com.minibank.accounts.entity.Accounts;
import com.minibank.accounts.entity.Customer;
import com.minibank.accounts.mapper.AccountsMapper;
import com.minibank.accounts.mapper.CustomerMapper;
import com.minibank.accounts.repository.AccountsRepository;
import com.minibank.accounts.repository.CustomerRepository;
import com.minibank.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     *
     * @param customerDto - customer details
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Unknown");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    /**
     *
     * @param customer entity
     * @return accounts entity
     */
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType("Savings");
        newAccount.setBranchAddress("Bengaluru");

        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Unknown");
        return newAccount;
    }

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return CustomerDto - customer details
     */
    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).get();

        Accounts account = accountsRepository.findByCustomerId(customer.getCustomerId()).get();

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(account, new AccountsDto()));
        return customerDto;
    }

    /**
     *
     * @param customerDto - customer details
     * @return boolean
     */
    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if( accountsDto != null ) {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).get();

            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).get();
            CustomerMapper.mapToCustomer(customerDto, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return boolean
     */
    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).get();
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
