package quesado.prado.saramaria.miwok;

public class Word {
    private String word_miwok,word_ingles;

    public Word(String word_ingles,String word_miwok){
        this.word_ingles = word_ingles;
        this.word_miwok = word_miwok;
    }

    public Word() {
    }

    public String getWord_ingles() {
        return word_ingles;
    }

    public void setWord_ingles(String word_ingles) {
        this.word_ingles = word_ingles;
    }

    public String getWord_miwok() {
        return word_miwok;
    }

    public void setWord_miwok(String word_miwok) {
        this.word_miwok = word_miwok;
    }
}
