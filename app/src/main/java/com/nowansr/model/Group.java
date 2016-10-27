package com.nowansr.model;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Group {

    @SerializedName("_id")
    @Expose
    private String Id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("accessPrivileges")
    @Expose
    private List<Object> accessPrivileges = new ArrayList<Object>();

    /**
     * @return The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The valid
     */
    public Boolean getValid() {
        return valid;
    }

    /**
     * @param valid The valid
     */
    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    /**
     * @return The accessPrivileges
     */
    public List<Object> getAccessPrivileges() {
        return accessPrivileges;
    }

    /**
     *
     * @param accessPrivileges
     * The accessPrivileges
     */
    public void setAccessPrivileges(List<Object> accessPrivileges) {
        this.accessPrivileges = accessPrivileges;
    }

}