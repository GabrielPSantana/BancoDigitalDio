package bancodigitaldio;

public class main {
	public static void main(String[] args) {
		
		Cliente gabriel = new Cliente();
		gabriel.setNome("Gabriel Pinheiro");
		
		Conta cc = new ContaCorrente(gabriel);
		Conta poupanca = new ContaPoupanca(gabriel);	
		
		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		
	}
}
