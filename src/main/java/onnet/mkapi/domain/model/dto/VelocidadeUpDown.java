package onnet.mkapi.domain.model.dto;

public class VelocidadeUpDown {

    private String velocidade_up;
    private String velocidade_down;

    public VelocidadeUpDown(String velocidade_up , String velocidade_down){
        this.velocidade_up = velocidade_up;
        this.velocidade_down = velocidade_down;
    }

    public String getVelocidade_up() {
        return velocidade_up;
    }

    public void setVelocidade_up(String velocidade_up) {
        this.velocidade_up = velocidade_up;
    }

    public String getVelocidade_down() {
        return velocidade_down;
    }

    public void setVelocidade_down(String velocidade_down) {
        this.velocidade_down = velocidade_down;
    }

    @Override
    public String toString() {
        return "VelocidadeUpDown{" +
                "velocidade_up='" + velocidade_up + '\'' +
                ", velocidade_down='" + velocidade_down + '\'' +
                '}';
    }
}
