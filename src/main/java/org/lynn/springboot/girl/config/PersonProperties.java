package org.lynn.springboot.girl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "person")
public class PersonProperties {
    private String name;

    private Integer age;

    private List<AddressProperties> addressList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<AddressProperties> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressProperties> addressList) {
        this.addressList = addressList;
    }
}
