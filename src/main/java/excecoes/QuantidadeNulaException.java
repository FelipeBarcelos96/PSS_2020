package excecoes;

public class QuantidadeNulaException extends Exception{
    private String mensagem;

    public QuantidadeNulaException(String mensagem) {
        this.mensagem = mensagem;
    }
    
    @Override
    public String getMessage(){
        return this.mensagem;
    }

    @Override
    public String toString() {
        return "QuantidadeNulaException{" + mensagem + '}';
    }
    
    
}
