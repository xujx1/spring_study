package com.elasticsearch.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
@Document(indexName = "user_index", type = "user")
public class User {

    @Id
    private Long id;

    //中文
    private String chaName;

    //英文
    private String engName;

    //拼音
    private String spellName;

    public User() {

    }

    public User(Long id, String chaName, String engName, String spellName) {
        this.id = id;
        this.chaName = chaName;
        this.engName = engName;
        this.spellName = spellName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChaName() {
        return chaName;
    }

    public void setChaName(String chaName) {
        this.chaName = chaName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
