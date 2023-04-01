package olisaude.desafiobackend;

public enum Grade {
    ONE(1),
    TWO(2);

    private final int value;

    Grade(int value) {
        this.value = value;
    }

    public int getValor() {
        return value;
    }

}
