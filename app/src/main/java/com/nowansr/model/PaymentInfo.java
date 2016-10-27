package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class PaymentInfo {

    @SerializedName("cardInfo")
    @Expose
    private CardInfo cardInfo;

    /**
     *
     * @return
     * The cardInfo
     */
    public CardInfo getCardInfo() {
        return cardInfo;
    }

    /**
     *
     * @param cardInfo
     * The cardInfo
     */
    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

}
