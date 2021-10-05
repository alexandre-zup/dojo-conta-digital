package br.com.zup.edu.dojo.contadigital.transacao;

public enum TipoTransacao {
    DEBITO {
        @Override
        public Transacao getTransacao() {
            return new Debito();
        }
    },
    CREDITO {
        @Override
        public Transacao getTransacao() {
            return new Credito();
        }
    };

    public abstract Transacao getTransacao();
}
