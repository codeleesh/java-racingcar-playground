package baseball.domain;

public enum Menu {
    NEW_START("1"),
    GAME_END("2");

    private String number;

    public String value() {
        return number;
    }

    Menu(final String number) {
        this.number = number;
    }
}
