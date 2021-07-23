package com.nnk.springboot.dto;

public class BidListDto {

    Integer BidListId;

    String account;

    String type;

    Double bid;

    public BidListDto() {
    }

    public BidListDto(Integer bidListId, String account, String type, Double bid) {
        BidListId = bidListId;
        this.account = account;
        this.type = type;
        this.bid = bid;
    }

    public Integer getBidListId() {
        return BidListId;
    }

    public void setBidListId(Integer bidListId) {
        BidListId = bidListId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }
}
