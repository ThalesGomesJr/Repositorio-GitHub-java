	//import java.util.Collection;
	import java.util.List;
	import java.util.ArrayList;
	import javax.swing.JOptionPane;

	public class Principal {
		List<Pessoa> vetpessoa = new ArrayList<Pessoa>();
		
		public void buscaPessoa(String nome) {
			String saida="";
			for(Pessoa p:vetpessoa) {
				if(p.getNome().equals(nome))
					saida+=String.format("\n Achou %s",p.getNome());
				}
		if(saida=="") saida+=String.format("\n Nao achou");
		JOptionPane.showMessageDialog(null,saida);
		}
		public void buscaRg(String nome) {
			String saida="";
			for(Pessoa p:vetpessoa) {
				if(p.getRg().equals(nome))
					saida+=String.format("\n Achou %s",p.getRg());
				}
		if(saida=="") saida+=String.format("\n Nao achou");
		JOptionPane.showMessageDialog(null,saida);
		}
		public void exibe() {
			String saida="\nArrayList de pessoas";
			for(Pessoa p:vetpessoa) {
				saida+=p.ToString();
			}
			JOptionPane.showMessageDialog(null, saida);
		}
		public Pessoa inserir() {
			String nome,rg,frase;
			int mes = 0,ano = 0;
			boolean erro = true;
			nome = JOptionPane.showInputDialog(null,"Entre com o Nome:");
			rg = JOptionPane.showInputDialog(null,"Entre com o RG:");
			do {
				try {
					frase = JOptionPane.showInputDialog(null,"Entra com o Mês de nascimento:");
					mes = Integer.parseInt(frase);
					frase = JOptionPane.showInputDialog(null,"Entra com o Ano de nascimento:");
					ano = Integer.parseInt(frase);
					erro = false;
				}catch(NumberFormatException msg) {
					JOptionPane.showMessageDialog(null,"Apenas numeros nas datas!");
					}
		}while(erro);
			Pessoa p = new Pessoa( nome, rg, mes, ano);
			return p;
	}
			
		public static void main(String args[]) {
			Principal p = new Principal();
			char opti='0';
			String nome,rg;
			while(opti!='5') {
				String opcao=JOptionPane.showInputDialog(
					      null,"\n|------------|Cadastro|------------|"+
					           "\n 1 - Inserir nova pessoa"+
							   "\n 2 - Exibir todas pessoa"+
							   "\n 3 - Buscar pessoa pelo nome"+
							   "\n 4 - Buscar um RG"+
							   "\n 5 - Sair");
				opti=opcao.charAt(0);
				switch(opti) {
					case '1': Pessoa x = p.inserir();
							  p.vetpessoa.add(x);
							  break;
					case '2': p.exibe();
							  break;
					case '3': nome = JOptionPane.showInputDialog(null,"Nome da pessoa:");
							  p.buscaPessoa(nome);
							  break;
					case '4': rg = JOptionPane.showInputDialog(null,"RG da pessoa:");
							  p.buscaRg(rg);
							  break;
				}
			}
		}
	}

