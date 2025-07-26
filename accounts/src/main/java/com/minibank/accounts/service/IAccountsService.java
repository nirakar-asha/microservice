package com.minibank.accounts.service;

import com.minibank.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - customer details
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return CustomerDto - customer details
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - customer details
     * @return true if the account updated successfully else false
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return true if the account deleted successfully else false
     */
    boolean deleteAccount(String mobileNumber);
}
