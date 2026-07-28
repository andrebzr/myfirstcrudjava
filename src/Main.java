import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	List<Produto> produtos = new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	int opcao = 0;
	do {
	    System.out.println("\n===== MENU =====");
	    System.out.println("1 - Cadastrar produto");
	    System.out.println("2 - Listar produtos");
	    System.out.println("3 - Atualizar produto");
	    System.out.println("4 - Deletar produto");
	    System.out.println("0 - Sair");
	    System.out.print("Escolha uma opção: ");
	    
	    try {
	    	opcao = scanner.nextInt();
	    } catch (Exception e) {
	    	System.out.println("Erro: digite somente numeros!");
	    	
	    }

	    switch (opcao) {
	        case 1:
	            System.out.println("Digite o nome do produto: ");
	            scanner.nextLine();
	            String nome = scanner.nextLine();
	            
	            if (nome.trim().isEmpty()) {
	            	System.out.println("O nome nao pode estar vazio!");
	            	break;
	            }
	           
	            System.out.println("Digite o preco do produto: ");
	            double preco = scanner.nextDouble();
	            
	            if (preco < 0) {
	            	System.out.println("Erro: Preco nao pode ser negativo!");
	            	break;
	            }
	            
	            int id = produtos.size() + 1;
	            Produto novoProduto = new Produto(id, nome, preco);
	            produtos.add(novoProduto);
	            
	            System.out.println("Produto cadastrado com sucesso!");
	            
	            break;
	        case 2:
	            if (produtos.isEmpty()) {
	            	System.out.println("Nenhum produto cadastrado");
	            } else {
	            	System.out.println("\n --- Lista de produtos ---");
	            	for (Produto p : produtos) {
	            		System.out.println(p);
	            	}
	            }
	            
	            break;
	        case 3: 
	        	System.out.println("Digite o ID do produto que deseja atualizar: ");
	        	int idAtualizar = scanner.nextInt();
	        	
	        	Produto produtoEncontrado = null;
	        	for (Produto p : produtos);{
	        		Produto p = null;
					if (p.getId() == idAtualizar) {
	        			produtoEncontrado = p;
	        			break;
	        		}
	        	}
	        	
			if (produtoEncontrado == null) {
				System.out.println("Produto nao encontrado");
			} else {
				System.out.println("Digite o novo nome: ");
				scanner.nextLine();
				String novoNome = scanner.nextLine();
				
				System.out.println("Digite o novo preeco");
				double novoPreco = scanner.nextDouble();
				
				produtoEncontrado.setNome(novoNome);
				produtoEncontrado.setPreco(novoPreco);
				
				System.out.println("Produto atualizado com sucesso!");
    
			}
			break;
	        case 4:
	        	System.out.println("Digite o nome do produto que deseja deletar: ");
	        	int idDeletar = scanner.nextInt();
	        	
	        	Produto produtoParaDeletar = null;
	        	for (Produto p : produtos) {
	        		if (p.getId() == idDeletar) {
	        			produtoParaDeletar = p;
	        			break;
	        		}
	        	}
	        	if (produtoParaDeletar == null) {
	        		System.out.println("Produto nao encontrado.");
	        	} else {
	        		produtos.remove(produtoParaDeletar);
	        		System.out.println("Produto deletado com sucesso.");
	        	}
	        	break;
	        case 0:
	            System.out.println("Saindo...");
	            break;
	        default:
	            System.out.println("Opção inválida!");
	    }
	} while (opcao != 0);
	
	}
}

	


	


