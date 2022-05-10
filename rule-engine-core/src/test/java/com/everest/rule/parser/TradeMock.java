package com.everest.rule.parser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TradeMock {

    private long id;
    private String book;
    private String legalEntity;
    private String counterparty;
    private LocalDate maturityDate;
    private List<String> userRoles;
    private Optional<TradeGenralMock> tradeGeneral;
    private String assetClass;

    private String currency;

    public TradeMock(long id, String book, String legalEntity, String assetClass, String counterparty, LocalDate maturityDate) {
        this.id = id;
        this.book = book;
        this.legalEntity = legalEntity;
        this.maturityDate = maturityDate;
        this.assetClass = assetClass;
        this.counterparty = counterparty;
    }

    public long getId() {
        return id;
    }

    public String getBook() {
        return book;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public String getLegalEntity() {
        return legalEntity;
    }

    public List<String> getUserRoles() {
        return userRoles;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isInternalBook() {
        return this.book.startsWith("internal_book");
    }



    public Optional<TradeGenralMock> getTradeGeneral() {
        return tradeGeneral;
    }

    public void setTradeGeneral(Optional<TradeGenralMock> tradeGeneral) {
        this.tradeGeneral = tradeGeneral;
    }


    public void setUserRoles(ArrayList<String> userRoles) {
        this.userRoles = userRoles;
    }

    public String objectMethod(String username) {
        return username + "_objectMethod";
    }

    public boolean checkRegion(String country, String region) {
        return "Asia".equalsIgnoreCase(region);
    }

    public boolean checkMaturityDate(String country, int year) {
        return year == 2019;
    }
}
