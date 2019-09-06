package io.github.wkr1u18;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "languages" )
class Lang {
    @Id
    @GeneratedValue(generator="inc")
    @GenericGenerator(name="inc", strategy = "increment")
    private Integer id ;
    private String welcomeMsg;
    private String code;

    /**
     * Hibernate uses it.
     */
    @SuppressWarnings("unused")
    Lang() {

    }
    Lang(Integer id, String welcomeMessage, String code) {
        this.id = id;
        this.welcomeMsg = welcomeMessage;
        this.code = code;
    }

    Integer getId() {
        return id;
    }

    String getWelcomeMsg() {
        return welcomeMsg;
    }

    void setWelcomeMsg(String welcomeMessage) {
        this.welcomeMsg = welcomeMessage;
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }
}
