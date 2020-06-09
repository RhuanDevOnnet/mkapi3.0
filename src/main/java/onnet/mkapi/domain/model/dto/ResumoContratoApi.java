package onnet.mkapi.domain.model.dto;

import java.time.LocalDate;

public class ResumoContratoApi {

    private long NumeroContrato;
    private String Cliente;
    private long TipoPessoa;
    private String RgIe;
    private String Email;
    private String TelefoneI;
    private String TelefoneII;
    private String celular;
    private LocalDate DataNascimento;
    private String NomePai;
    private String NomeMae;
    private LocalDate Adesao;
    private LocalDate Termino;
    private String CpfCnpJ;
    private String Endereco;
    private long Numero;
    private String Bairro;
    private String Complemento;
    private String Cep;
    private String Cidade;
    private String Uf;
    private String Operador;
    private long IdPlanoMk;
    private String PlanoMk;
    private String VelUp;
    private String VelDown;
    private double ValorPlanoMk;
    private String Tecnologia;
    private int DiaVencimento;


    public ResumoContratoApi(long id, String cliente, long tipopessoa, String rgie, String email, String telefone, String telefone2, String celular, LocalDate dataNascimento, String nomePai, String nomeMae, LocalDate adesao, LocalDate previsaoTermino, String cpfCnpj, String endereco, long numero, String bairro, String complemento, String cep, String cidade, String uf, String operador, long codplano, String descricao_plano, String vel_up, String vel_down, double vlr_mensalidade, String tecnologia, int dia_vencimento ){
        this.NumeroContrato = id;
        this.Cliente = cliente;
        this.TipoPessoa = tipopessoa;
        this.RgIe = rgie;
        this.Email = email;
        this.TelefoneI = telefone;
        this.TelefoneII = telefone2;
        this.celular = celular;
        this.DataNascimento = dataNascimento;
        this.NomePai = nomePai;
        this.NomeMae = nomeMae;
        this.Adesao = adesao;
        this.Termino = previsaoTermino;
        this.CpfCnpJ = cpfCnpj;
        this.Endereco = endereco;
        this.Numero = numero;
        this.Bairro = bairro;
        this.Complemento = complemento;
        this.Cep = cep;
        this.Cidade = cidade;
        this.Uf = uf;
        this.Operador = operador;
        this.IdPlanoMk = codplano;
        this.PlanoMk = descricao_plano;
        this.VelUp = vel_up;
        this.VelDown = vel_down;
        this.Tecnologia = tecnologia;
        this.DiaVencimento = dia_vencimento;
        this.ValorPlanoMk = vlr_mensalidade;

    }

    public long getNumeroContrato() {
        return NumeroContrato;
    }

    public void setNumeroContrato(long numeroContrato) {
        NumeroContrato = numeroContrato;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public long getTipoPessoa() {
        return TipoPessoa;
    }

    public void setTipoPessoa(long tipoPessoa) {
        TipoPessoa = tipoPessoa;
    }

    public String getRgIe() {
        return RgIe;
    }

    public void setRgIe(String rgIe) {
        RgIe = rgIe;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefoneI() {
        return TelefoneI;
    }

    public void setTelefoneI(String telefoneI) {
        TelefoneI = telefoneI;
    }

    public String getTelefoneII() {
        return TelefoneII;
    }

    public void setTelefoneII(String telefoneII) {
        TelefoneII = telefoneII;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public String getNomePai() {
        return NomePai;
    }

    public void setNomePai(String nomePai) {
        NomePai = nomePai;
    }

    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String nomeMae) {
        NomeMae = nomeMae;
    }

    public LocalDate getAdesao() {
        return Adesao;
    }

    public void setAdesao(LocalDate adesao) {
        Adesao = adesao;
    }

    public LocalDate getTermino() {
        return Termino;
    }

    public void setTermino(LocalDate termino) {
        Termino = termino;
    }

    public String getCpfCnpJ() {
        return CpfCnpJ;
    }

    public void setCpfCnpJ(String cpfCnpJ) {
        CpfCnpJ = cpfCnpJ;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public long getNumero() {
        return Numero;
    }

    public void setNumero(long numero) {
        Numero = numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String complemento) {
        Complemento = complemento;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getUf() {
        return Uf;
    }

    public void setUf(String uf) {
        Uf = uf;
    }

    public String getOperador() {
        return Operador;
    }

    public void setOperador(String operador) {
        Operador = operador;
    }

    public long getIdPlanoMk() {
        return IdPlanoMk;
    }

    public void setIdPlanoMk(long idPlanoMk) {
        IdPlanoMk = idPlanoMk;
    }

    public String getPlanoMk() {
        return PlanoMk;
    }

    public void setPlanoMk(String planoMk) {
        PlanoMk = planoMk;
    }

    public String getVelUp() {
        return VelUp;
    }

    public void setVelUp(String velUp) {
        VelUp = velUp;
    }

    public String getVelDown() {
        return VelDown;
    }

    public void setVelDown(String velDown) {
        VelDown = velDown;
    }

    public double getValorPlanoMk() {
        return ValorPlanoMk;
    }

    public void setValorPlanoMk(double valorPlanoMk) {
        ValorPlanoMk = valorPlanoMk;
    }

    public String getTecnologia() {
        return Tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        Tecnologia = tecnologia;
    }

    public int getDiaVencimento() {
        return DiaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        DiaVencimento = diaVencimento;
    }


    @Override
    public String toString() {
        return "ResumoContratoApi{" +
                "NumeroContrato=" + NumeroContrato +
                ", Cliente='" + Cliente + '\'' +
                ", TipoPessoa=" + TipoPessoa +
                ", RgIe='" + RgIe + '\'' +
                ", Email='" + Email + '\'' +
                ", TelefoneI='" + TelefoneI + '\'' +
                ", TelefoneII='" + TelefoneII + '\'' +
                ", celular='" + celular + '\'' +
                ", DataNascimento=" + DataNascimento +
                ", NomePai='" + NomePai + '\'' +
                ", NomeMae='" + NomeMae + '\'' +
                ", Adesao=" + Adesao +
                ", Termino=" + Termino +
                ", CpfCnpJ='" + CpfCnpJ + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", Numero=" + Numero +
                ", Bairro='" + Bairro + '\'' +
                ", Complemento='" + Complemento + '\'' +
                ", Cep='" + Cep + '\'' +
                ", Cidade='" + Cidade + '\'' +
                ", Uf='" + Uf + '\'' +
                ", Operador='" + Operador + '\'' +
                ", IdPlanoMk=" + IdPlanoMk +
                ", PlanoMk='" + PlanoMk + '\'' +
                ", VelUp='" + VelUp + '\'' +
                ", VelDown='" + VelDown + '\'' +
                ", ValorPlanoMk=" + ValorPlanoMk +
                ", Tecnologia='" + Tecnologia + '\'' +
                ", DiaVencimento=" + DiaVencimento +
                '}';
    }
}
