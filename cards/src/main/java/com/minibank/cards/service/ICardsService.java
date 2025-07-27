package com.minibank.cards.service;


import com.minibank.cards.dto.CardsDto;

public interface ICardsService {

    /**
     *
     * @param mobileNumber - customer mobile number
     */
    void createCard(String mobileNumber);

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return CardsDto - customer cards detail
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     *
     * @param cardsDto - customer cards detail
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateCard(CardsDto cardsDto);

    /**
     *
     * @param mobileNumber - customer mobile number
     * @return boolean indicating if the delete of card details is successful or not
     */
    boolean deleteCard(String mobileNumber);
}
