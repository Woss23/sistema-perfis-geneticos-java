public class Paciente {

    private int codigo;
    private String nome;
    private int idade;
    private String sexo;
    private String sequenciaDNA;

    public Paciente() {
    }

    public Paciente(int codigo, String nome, int idade, String sexo, String sequenciaDNA) {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.sequenciaDNA = sequenciaDNA;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSequenciaDNA() {
        return sequenciaDNA;
    }

    public void setSequenciaDNA(String sequenciaDNA) {
        this.sequenciaDNA = sequenciaDNA;
    }
}
