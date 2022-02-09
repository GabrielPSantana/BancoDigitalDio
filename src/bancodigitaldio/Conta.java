package bancodigitaldio;

public abstract class Conta implements IConta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	private Cliente cliente;
	
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}
	
	public int getAgencia() {
		return agencia;
	}
	public int getNumero() {
		return numero;
	}
	public double getSaldo() {
		return saldo;
	}
	
	@Override
	public void sacar(double valor) {
		
		if(this.saldo < valor) {
			System.out.println("Seu saldo é insuficiente");
			System.out.println("Saldo Atual: " + saldo);
		}else {
			this.saldo -= valor;
		}
		
	}
	
	@Override
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Saldo: " + saldo);
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		
		if(this.saldo  < valor) {
			System.out.println("Seu saldo é insuficiente");
			System.out.println("Saldo: " + saldo);
		}else {	
			this.sacar(valor);
			valor -= valor * 0.03; 
			contaDestino.depositar(valor);			
		}
		
	}
	
	public void transferirPix(double valor, Conta contaDestino) {
		
		if(this.saldo  < valor) {
			System.out.println("Seu saldo é insuficiente");
			System.out.println("Saldo: " + saldo);
		}else {
			this.sacar(valor);
			contaDestino.depositar(valor);			
		}
		
	}
	
	protected void imprimirInfoComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}


}

