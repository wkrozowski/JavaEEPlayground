package io.github.wkr1u18;

class Lang {
    private Long id ;
    private String welcomeMessage;
    private String code;

    Lang(Long id, String welcomeMessage, String code) {
        this.id = id;
        this.welcomeMessage = welcomeMessage;
        this.code = code;
    }

    Long getId() {
        return id;
    }

    String getWelcomeMessage() {
        return welcomeMessage;
    }

    void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }
}
