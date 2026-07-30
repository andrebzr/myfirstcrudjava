import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;


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
	    System.out.println("5 - Ordenar por preco (crescente)");
	    System.out.println("6 - Ordernar por preco (decrescente)");
	    System.out.println("0 - Sair");
	    System.out.print("Escolha uma opção: ");
	    
	    try {
	    	opcao = scanner.nextInt();
	    } catch (Exception e) {
	    	System.out.println("Erro: digite somente numeros!");
	    	scanner.nextLine();
	    	continue;	    	
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
	            double preco = 0;
	            try {
	            	preco = scanner.nextDouble();
	            } catch (Exception e) {
	            	System.out.println("Erro: digite um valor numerico valido para o preco.");
	            	scanner.nextLine();
	            	break;
	            }
	            
	            
	            if (preco < 0) {
	            	System.out.println("Erro: Preco nao pode ser negativo!");
	            	break;
	            }
	            
	            try (Connection conexao = Conexao.conectar()) {
	            	String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
	            	PreparedStatement stmt = conexao.prepareStatement(sql);
	            	stmt.setString(1, nome);
	            	stmt.setDouble(2, preco);
	            	stmt.executeUpdate();
	            	System.out.println("Produto cadastrado com sucesso!");
	            } catch (SQLException e) {
	            	System.out.println("Erro ao cadastrar: " + e.getMessage());
	            	
	            } break;
	            
	        case 2:
	            try (Connection conexao = Conexao.conectar()) {
	                String sql = "SELECT * FROM produtos";
	                PreparedStatement stmt = conexao.prepareStatement(sql);
	                ResultSet rs = stmt.executeQuery();

	                System.out.println("\n--- Lista de produtos ---");
	                boolean encontrouAlgum = false;
	                while (rs.next()) {
	                    encontrouAlgum = true;
	                    int id = rs.getInt("id");
	                    String nomeProduto = rs.getString("nome");
	                    double precoProduto = rs.getDouble("preco");
	                    System.out.println("ID: " + id + " | Nome: " + nomeProduto + " | Preço: R$ " + precoProduto);
	                }
	                if (!encontrouAlgum) {
	                    System.out.println("Nenhum produto cadastro!");
	                }
	            } catch (SQLException e) {
	                System.out.println("Erro ao listar: " + e.getMessage());
	            }
	            break;
	            
	           
	            
		case 3: 
	        	System.out.print("Digite o ID do produto que deseja atualizar: ");
	            int idAtualizar;
	            try {
	                idAtualizar = scanner.nextInt();
	            } catch (Exception e) {
	                System.out.println("Erro: digite um ID válido!");
	                scanner.nextLine();
	                break;
	            }

	            System.out.print("Digite o novo nome: ");
	            scanner.nextLine();
	            String novoNome = scanner.nextLine();

	            System.out.print("Digite o novo preço: ");
	            double novoPreco;
	            try {
	                novoPreco = scanner.nextDouble();
	            } catch (Exception e) {
	                System.out.println("Erro: digite um valor numérico válido!");
	                scanner.nextLine();
	                break;
	            }

	            try (Connection conexao = Conexao.conectar()) {
	                String sql = "UPDATE produtos SET nome = ?, preco = ? WHERE id = ?";
	                PreparedStatement stmt = conexao.prepareStatement(sql);
	                stmt.setString(1, novoNome);
	                stmt.setDouble(2, novoPreco);
	                stmt.setInt(3, idAtualizar);

	                int linhasAfetadas = stmt.executeUpdate();

	                if (linhasAfetadas > 0) {
	                    System.out.println("Produto atualizado com sucesso!");
	                } else {
	                    System.out.println("Produto não encontrado.");
	                }
	            } catch (SQLException e) {
	                System.out.println("Erro ao atualizar: " + e.getMessage());
	            }
			break;
	        case 4:
	        	System.out.println("Digite o nome do produto que deseja deletar: ");
	        	int idDeletar;
	        	try {
	        		idDeletar = scanner.nextInt();
	        	} catch (Exception e) {
	        		System.out.println("Erro: digite um id valido");
	        		scanner.nextLine();
	        	    break;
	        	}
	        	try (Connection conexao = Conexao.conectar()) {
	        		String sql = "DELETE FROM produtos WHERE id = ?";
	        		PreparedStatement stmt = conexao.prepareStatement(sql);
	        		stmt.setInt(1, idDeletar);
	        		
	        		int linhasAfetadas = stmt.executeUpdate();
	        		
	        		if (linhasAfetadas < 0) {
	        			System.out.println("Produto deletado com sucesso!");
	        		} else {
	        			System.out.println("Produto nao encontrado");
	        		}
	        	} catch (SQLException e) {
	        		System.out.println("Erro ao deletar: " + e.getMessage());
	        	}
	        	break;
	        	
	        case 5:
	        	produtos.sort(Comparator.comparingDouble(Produto::getPreco));
	        	System.out.println("Produtos ordenados por preco (crescente)!");
	        	break;
	        case 6:
	        	produtos.sort(Comparator.comparingDouble(Produto::getPreco).reversed());
	        	System.out.println("Produtos ordenados por preco (decrescente)!");
	        case 0:
	            System.out.println("Saindo...");
	            break;
	        default:
	            System.out.println("Opção inválida!");
	    }
	} while (opcao != 0);
	
	}

	private static Connection conectar() {
		// TODO Auto-generated method stub
		return null;
	}
}

	


	


