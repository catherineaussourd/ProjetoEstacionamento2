package br.com.unicap.estacionamento;

public class Registro extends Aluno { //corrigir
	
    private Automovel aAutomovel;
    private TipoVeiculo aTipo;
    
    public Registro(String pNome, int pIdade, int pMatricula, int pSenha, boolean pEspecial,
                    String pMarcaAutomovel,
                    String pPlacaAutomovel, boolean isMoto) throws InvalidDataException{

        super(pNome,pIdade,pMatricula,pSenha,pEspecial);

        aAutomovel = new Automovel(pMarcaAutomovel, pPlacaAutomovel, isMoto);

        this.getaAutomovel().setMarca(pMarcaAutomovel);
        this.getaAutomovel().setPlaca(pPlacaAutomovel);
        this.getaAutomovel().setMoto(isMoto);

        if(pEspecial) {
        	this.setaTipo(TipoVeiculo.ESPECIAL);
        }else if(isMoto) {
        	this.setaTipo(TipoVeiculo.MOTO);
        }else {
        	this.setaTipo(TipoVeiculo.CARRO);
        }
    }
    
    public int getMatricula(){
        return super.getMatricula();
    }
    
    public boolean getEspecial(){
        return super.getEspecial();
    }
    
    public String getPlaca(){
        return getaAutomovel().getPlaca();
    }
    
    public String getMarca(){
        return getaAutomovel().getMarca();
    }
    
    public boolean isMoto(){
        return getaAutomovel().isMoto();
    }

    public TipoVeiculo getaTipo() {
        return aTipo;
    }

    public void setaTipo(TipoVeiculo aTipo) {
        this.aTipo = aTipo;
    }

    public Automovel getaAutomovel() {
        return aAutomovel;
    }

    public void setaAutomovel(Automovel aAutomovel) {
        this.aAutomovel = aAutomovel;
    }
}
