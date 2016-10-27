package com.nowansr.model;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Questions {

    @SerializedName("object")
    @Expose
    private String object;
    @SerializedName("hasNext")
    @Expose
    private Boolean hasNext;
    @SerializedName("data")
    @Expose
    private List<Question> data = new ArrayList<Question>();
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("limit")
    @Expose
    private Integer limit;
    @SerializedName("pageCount")
    @Expose
    private Integer pageCount;

    /**
     *
     * @return
     * The object
     */
    public String getObject() {
        return object;
    }

    /**
     *
     * @param object
     * The object
     */
    public void setObject(String object) {
        this.object = object;
    }

    /**
     *
     * @return
     * The hasNext
     */
    public Boolean getHasNext() {
        return hasNext;
    }

    /**
     *
     * @param hasNext
     * The hasNext
     */
    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Question> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Question> data) {
        this.data = data;
    }

    /**
     *
     * @return
     * The currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     *
     * @param currentPage
     * The currentPage
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     *
     * @return
     * The limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     *
     * @param limit
     * The limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     *
     * @return
     * The pageCount
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     *
     * @param pageCount
     * The pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

}