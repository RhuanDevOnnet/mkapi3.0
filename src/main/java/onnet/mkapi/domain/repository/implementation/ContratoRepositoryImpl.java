package onnet.mkapi.domain.repository.implementation;

import onnet.mkapi.domain.model.dto.*;
import onnet.mkapi.domain.repository.query.ContratoRepositoryQuery;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

public class ContratoRepositoryImpl implements ContratoRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<ResumoContratoApi> buscarContratoApi() {

        StringBuilder consulta = new StringBuilder();
        String N = "N";
        long tipo = 3;
        LocalDate nullDate = LocalDate.of(1, 1,1);

        consulta.append("SELECT DISTINCT new onnet.mkapi.domain.model.dto.ResumoContratoApi(c.id, p.nome, p.tipo_pessoa, coalesce(p.rg, p.ie, ''), p.email, p.telefone01, p.telefone02, p.celular, p.coalesce(p.nascimento, p.fundacao, :nullDate), p.nomePai, p.nomeMae, c.adesao, c.previsaoVencimento, coalesce(p.cpf, p.cnpj, ''), l.logradouro, b.bairro, p.complemento, p.cep, ci.cidade, es.sigla, usuario.usr_nome, c.previsaoVencimento, plAcesso.id, plAcesso.descricao, plAcesso.vel_up, plAcesso.vel_down, plAcesso.vlr_mensalidade, pltipo.descricao, fr.dia_vencimento) ")
                .append("FROM Contrato c, Pessoa p, Cidade ci, Bairro b, Logradouro l, Estado es, PlanoAcesso plAcesso, PlanoAcessoTipo pltipo, CrmOperadores operador, ViUsuario usuario, FaturamentoRegras fr ")
                .append("WHERE ")
                .append("p.id = c.cliente AND ")
                .append("c.plano = plAcesso.id AND ")
                .append("plAcesso.tipo = pltipo.id AND ")
                .append("p.cidade = ci.id AND ")
                .append("p.logradouro = l.id AND ")
                .append("p.bairro = b.id AND ")
                .append("p.uf = es.id AND ")
                .append("c.consultor_crm = operador.cd_operador AND ")
                .append("c.cancelado = :n AND ")
                .append("usuario.id = c.consultor_crm AND ")
                .append("p.tipo_pessoa != :tipo AND ")
                .append("fr.id = c.faturamento ")
                .append("ORDER BY 1");

        try{
            return this.manager.createQuery(consulta.toString() , ResumoContratoApi.class)
                                .setParameter("n" ,  N)
                                .setParameter("tipo", tipo)
                                .setParameter("nullDate", nullDate)
                                .getResultList();
        }catch (NoResultException e){
            System.out.println(e);
            System.out.println("Not found any register");
            return null;
        }

    }

    @Override
    public List<ResumoContratoApi> buscarContratoMaior(long contractId) {

        StringBuilder consulta = new StringBuilder();
        String N = "N";
        LocalDate nullDate = LocalDate.of(1,1,1);
        System.out.println(nullDate);
        System.out.println(N);

        consulta.append("SELECT DISTINCT new onnet.mkapi.domain.model.dto.ResumoContratoApi(c.id, p.nome, p.tipo_pessoa, coalesce(p.rg, p.ie, ''), p.email, p.telefone01, p.telefone02, p.celular, coalesce(p.nascimento, p.fundacao, :nullDate), p.nomePai, p.nomeMae, c.adesao, c.previsaoVencimento, coalesce(p.cpf, p.cnpj, ''), l.logradouro, p.numero, b.bairro, p.complemento, p.cep, ci.cidade, es.sigla, user.usr_nome, plAcesso.id, plAcesso.descricao, plAcesso.vel_up, plAcesso.vel_down, plAcesso.vlr_mensalidade, pltipo.descricao, fr.dia_vencimento ) ")
                .append("FROM Contrato c ")
                .append("INNER JOIN c.cliente p ")
                .append("INNER JOIN c.plano plAcesso ")
                .append("LEFT JOIN c.consultor_crm user ")
                .append("INNER JOIN p.logradouro l ")
                .append("INNER JOIN p.cidade ci ")
                .append("INNER JOIN p.bairro b ")
                .append("INNER JOIN p.uf es ")
                .append("INNER JOIN plAcesso.tipo pltipo ")
                .append("INNER JOIN c.faturamento fr ")
                .append("WHERE c.cancelado = :n ")
                .append("AND ")
                .append("c.id > :contratoNum ")
                .append("ORDER BY 1");

        try {
            return this.manager.createQuery(consulta.toString() , ResumoContratoApi.class)
                                .setParameter("n", N)
                                .setParameter("contratoNum", contractId)
                                .setParameter("nullDate", nullDate)
                                .getResultList();
        }catch (NoResultException e){
            System.out.println("Not found any register on database ");
            return null;
        }

    }

    @Override
    public VelocidadeUpDown buscarVelocidadeUpDown(long plano) {

        StringBuilder consulta = new StringBuilder();

        consulta.append("SELECT new onnet.mkapi.domain.model.dto.VelocidadeUpDown(plAcesso.vel_up, plAcesso.vel_down) ")
                .append("FROM CrmProdutoComposicao item ")
                .append("LEFT JOIN item.cd_produto produto ")
                .append("INNER JOIN item.cd_plano plAcesso ")
                .append("WHERE ")
                .append("produto.cd_plano = :plano ");

        try{
            return this.manager.createQuery(consulta.toString(), VelocidadeUpDown.class)
                               .setParameter("plano", plano).getSingleResult();
        }catch (NoResultException e){
            VelocidadeUpDown zeroResult = new VelocidadeUpDown("OM" , "OM");
            return zeroResult;
        }


    }

    @Override
    public ResumoOsAgenda searchOsNumber(long os) {
        StringBuilder consulta = new StringBuilder();

        consulta.append("SELECT new onnet.mkapi.domain.model.dto.ResumoOsAgenda(pessoa.nome , ostipo.descricao) ").append("FROM Pessoa pessoa, Os os, OsTipo ostipo ").append("WHERE os.cliente = pessoa.id ").append("AND ").append("os.tipoos = ostipo.id ").append("AND ").append("os.id = :os ");

        try{
            return this.manager.createQuery(consulta.toString(), ResumoOsAgenda.class)
                               .setParameter("os", os)
                               .getSingleResult();
        } catch (NoResultException e){
            System.out.println(e);
            return null;
        }
    }

    @Override
    public TotalSemFidelidade buscarSemFidelidade() {
        StringBuilder consulta = new StringBuilder();
        String cancelado = "N";
        int defeito = 4;
        LocalDate dataInterval = LocalDate.now().minusMonths(12);

        consulta.append("SELECT new onnet.mkapi.domain.model.dto.TotalSemFidelidade(COUNT(contrato.id)) FROM Contrato contrato ")
                .append("INNER JOIN contrato.cliente pessoa on (pessoa.id = contrato.cliente) ")
                .append("AND ")
                .append("contrato.adesao < :dataInterval ")
                .append("AND ")
                .append("NOT EXISTS(SELECT os.id FROM Os os where os.defeitoAssociado = :defeito AND os.dataAbertura >= :dataInterval AND os.dataAbertura <= CURRENT_DATE AND os.cliente = pessoa.id )");

        try{
            return this.manager.createQuery(consulta.toString(), TotalSemFidelidade.class).setParameter("N", cancelado).setParameter("dataInterval", dataInterval)
                    .setParameter("defeito", defeito ).getSingleResult();
        }catch (NoResultException ex){
            System.out.println("Nãp foi encontrato nenhum resultado ");
            return null;
        }

    }

    @Override
    public ResumoContratoAtivo buscarContratoAtivo() {
        StringBuilder consulta = new StringBuilder();
        String cancelado =  "N";

        consulta.append("SELECT new onnet.mkapi.domain.dto.ResumoContratoAtivo(COUNT(contrato.id)) ")
                .append("FROM Contrato contrato ")
                .append("INNER JOIN contrato.cliente  pessoa ON (pessoa.id = contrato.cliente )")
                .append("WHERE contrato.cancelado = :N ");

        try{
            return this.manager.createQuery(consulta.toString(), ResumoContratoAtivo.class)
                                .setParameter("N" , cancelado)
                                .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public ResumoContratoApi updateContratos(long id) {
       StringBuilder consulta = new StringBuilder();
       String n = "N";
       LocalDate nullDate = LocalDate.of(1,1,1);

        consulta
                .append("SELECT DISTINCT new onnet.mkapi.domain.model.dto.ResumoContratoApi(c.id, p.nome, p.tipo_pessoa, coalesce(p.rg, p.ie, ''), p.email, p.telefone01, p.telefone02, p.celular, coalesce(p.nascimento, p.fundacao, :nullDate ), p.nomePai, p.nomeMae, c.adesao, c.previsaoVencimento, coalesce(p.cpf, p.cnpj, ''), l.logradouro, p.numero, b.bairro, p.complemento, p.cep, ci.cidade, es.sigla, user.usr_nome, plAcesso.id, plAcesso.descricao, plAcesso.vel_up, plAcesso.vel_down, plAcesso.vlr_mensalidade, pltipo.descricao, fr.dia_vencimento) ")
                .append("FROM Contrato c ")
                .append("INNER JOIN c.cliente p ")
                .append("INNER JOIN c.plano plAcesso ")
                .append("LEFT JOIN c.consultor_crm user ")
                .append("INNER JOIN p.logradouro l ")
                .append("INNER JOIN p.cidade ci ")
                .append("INNER JOIN p.bairro b ")
                .append("INNER JOIN p.uf es ")
                .append("INNER JOIN plAcesso.tipo pltipo ")
                .append("INNER JOIN c.faturamento fr ")
                .append("WHERE c.cancelado = :n ")
                .append("AND ")
                .append("c.id = :contratoNum ");

        try{
            return this.manager.createQuery(consulta.toString(), ResumoContratoApi.class)
                    .setParameter("n", n)
                    .setParameter("contratoNum", id)
                    .setParameter("nullDate", nullDate)
                    .getSingleResult();

        }catch (NoResultException e){
            return null;
        }


    }
}
