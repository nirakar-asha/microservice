package com.minibank.loans.service;


import com.minibank.loans.dto.LoansDto;

public interface ILoansService {
    /**
     *
     * @param mobileNumber - customer mobile number
     */
    void createLoan(String mobileNumber);

    /**
     *
     * @param mobileNumber - customer mobile number
     *  @return Loan Details based on a given mobileNumber
     */
    LoansDto fetchLoan(String mobileNumber);

    /**
     *
     * @param loansDto - LoansDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateLoan(LoansDto loansDto);

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    boolean deleteLoan(String mobileNumber);
}
