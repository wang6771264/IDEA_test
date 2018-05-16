package test.enums;

public enum Person {
    PERSON((short)1),
    COMPANY((short)2);
    private Short code;

    public Short getCode( ) {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    Person(Short code) {
        this.code = code;
    }
}
