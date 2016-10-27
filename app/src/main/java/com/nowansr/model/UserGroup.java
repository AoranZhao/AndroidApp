package com.nowansr.model;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class UserGroup {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("_id")
    @Expose
    private String Id;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The group
     */
    public Group getGroup() {
        return group;
    }

    /**
     *
     * @param group
     * The group
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

}