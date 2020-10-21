package quesado.prado.saramaria.miwok;

public class Word {
    private String word_miwok,word_ingles;
    private int imagenResourceId;
    private int audio_palabra;

    public Word(String word_ingles,String word_miwok,int audio_palabra){
        this.word_ingles = word_ingles;
        this.word_miwok = word_miwok;
        this.imagenResourceId=-1;
        this.audio_palabra=audio_palabra;

    }
    public Word(String word_ingles,String word_miwok,int imagenResourceId,int audio_palabra){
        this.word_miwok=word_miwok;
        this.word_ingles=word_ingles;
        this.imagenResourceId=imagenResourceId;
        this.audio_palabra=audio_palabra;
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

    public int getImagenResourceId() {
        return imagenResourceId;
    }

    public void setImagenResourceId(int imagenResourceId) {
        this.imagenResourceId = imagenResourceId;
    }

    public int getAudio_palabra() {
        return audio_palabra;
    }

    public void setAudio_palabra(int audio_palabra) {
        this.audio_palabra = audio_palabra;
    }

    public boolean tieneImagen(){
        return imagenResourceId!=-1;
    }
}
