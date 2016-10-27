package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class DisplayName {

    @SerializedName("en_US")
    @Expose
    private String enUS;
    @SerializedName("zh_CN")
    @Expose
    private String zhCN;

    /**
     *
     * @return
     * The enUS
     */
    public String getEnUS() {
        return enUS;
    }

    /**
     *
     * @param enUS
     * The en_US
     */
    public void setEnUS(String enUS) {
        this.enUS = enUS;
    }

    /**
     *
     * @return
     * The zhCN
     */
    public String getZhCN() {
        return zhCN;
    }

    /**
     *
     * @param zhCN
     * The zh_CN
     */
    public void setZhCN(String zhCN) {
        this.zhCN = zhCN;
    }

}