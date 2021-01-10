package org.zuel.app.module;


/**
 * the module of dept
 * @author 陈昕
 * **/
public class DeptData {

    protected String id,name,type,description,address;


    public DeptData() {
        id=null;
        name=null;
        type=null;
        description=null;
        address=null;
    }


    public DeptData(String id,String name,String type,String description,String address) {
        this.id=id;
        this.name=name;
        this.type=type;
        this.description=description;
        this.address=address;
    }


    public void setId(String newId) { id=newId; }


    public void setName(String newName)
    {
        name=newName;
    }


    public void setType(String type)
    {
        this.type=type;
    }


    public void setDescription(String newDescription)
    {
        description=newDescription;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }


    public String getType()
    {
        return type;
    }


    public String getDescription()
    {
        return description;
    }


    public String getAddress() {
        return address;
    }
}
