package com.auditoria.testando;

import java.util.Scanner;

public class CarrinhoWipro {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String resposta = "";
		int entradaOp2 = 0;

		Integer[] codigo = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] produto = { "Arroz", "Azeite", "Café", "Farinha", "Feijão", "Macarrão", "Óleo", "Manteiga", "Queijo", "Salame" };
		Double[] preco = { 20.0, 16.0, 16.50, 5.10, 5.25, 3.50, 2.10, 6.99, 7.50, 9.99 };
		Integer[] estoque = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		double[] precoSubTotal = new double[10];
		int[] qtNoCarrinho = new int[10];
		double total = 0;
		double totalImp = 0;
		double totalDesc = 0;

		System.out.println("====================================Wipro Store=========================================\n");
		
		System.out.println("CÓDIGO \t \t \t" + "PRODUTO \t \t " + "PREÇO \t \t \t" + "QTE.PRODUTO \n");
		
			for (Integer i = 0; i < codigo.length; i++) {
				System.out.printf("%-15d \t %-15s \t %-15.2f \t %-15d \t \n", codigo[i], produto[i], preco[i], estoque[i]);
			}
		
			System.out.println("========================================================================================\n");

			do { System.out.println("Digite o código do produto desejado: ");
			
			int entrada = scan.nextInt();
			for (int i = 0; i < codigo.length; i++) {

				if (codigo[i] == entrada) {
					System.out.println(produto[i] + " Adicionado! \n");

					System.out.println("Digite a quantidade do produto desejado: ");
					int entrada2 = scan.nextInt();

					if (entrada2 > estoque[i]) {
						System.out.println(
								"Quantidade do Produto indisponível! A quantidade disponivel no estoque para este produto é de: "
										+ estoque[i]); 
						continue;
					}

					System.out.println("Foi adicionado ao seu carrinho de compras " + entrada2 + " unidades de " + produto[i] +"\n");
					estoque[i] = estoque[i] - entrada2;

					qtNoCarrinho[i] = qtNoCarrinho[i] + entrada2;
					precoSubTotal[i] = qtNoCarrinho[i] * preco[i];
					total = total + precoSubTotal[i];
					totalImp = (total * 0.09);
				
					}
				
				}
			
			System.out.println("Deseja continuar suas compras? Digite 'S/s' para continuar ou encerre com outra tecla: ");
			resposta = scan.next();

		} while (resposta.equals("S") || resposta.equals("s"));

		System.out
				.println("========================================================================================\n");

		System.out.println("ITENS NO CARRINHO: \n ");

		System.out.printf("Nome" + "\t \t" + "Qtde. no carrinho" + "\t" + "Preço unit.(R$)" + "\t \t" + "Preço Total(R$) \n");
		for (int i = 0; i < codigo.length; i++) {
			
			System.out.printf("%-15s \t %-15d \t %-15.2f \t %-15.2f \t \n", produto[i], qtNoCarrinho[i], preco[i], precoSubTotal[i]);

		}

		System.out.println("\n Preço Total da compra: \n" + "\t" + (String.format("%.2f", total)));
	

		System.out.println("========================================================================================\n");

		
		System.out.println("Valor do imposto sobre a compra é de 9%, que será calculado e observado em nota fiscal! \n");
		System.out.println("Escolha uma das formas de pagamento: \n");

		System.out.println("Digite [1] Para pagamento à vista em dinheiro, pix ou cartão MASTERCARD, recebe 20% de desconto. \n");
		System.out.println("Digite [2] Para pagamento à vista no cartão de crédito, recebe 10% de desconto. \n");
		System.out.println("Digite [3] Para pagamento em 3x no cartão, não há desconto. \n");

		do { System.out.println("Digite a opção escolhida: \n");
		
			int entradaOp = scan.nextInt();
			if (entradaOp == 1) {
				totalDesc = (total * 0.20);
				System.out.println("Seu desconto será de R$ " + (String.format("%.2f", totalDesc))  + " reais. \n");
				break;
				
			} else if (entradaOp == 2) {
				totalDesc = (total * 0.10);
				System.out.println("Seu desconto será de R$ " + (String.format("%.2f", totalDesc)));
				break;
				
			} else if (entradaOp == 3) {
				System.out.println("Valor total de R$ " + (String.format("%.2f", total)) + " Parcelado em 3x de R$ "
						+ (String.format("%.2f", total / 3)) + " reais. \n");
				break;
			
			} else {

				System.out.println("Digite uma opção válida!");
				entradaOp2 = scan.nextInt();
			}
			
		} while (entradaOp2 > 3 || entradaOp2 < 1);

		System.out.println("====================================Wipro Store Endereço=========================================\n");
		
		System.out.println("Rua Jardim Itália, nº 150 - Mercadinho - LTDA \n");
		System.out.println("CNPJ: 85.976.381/0001-00 \n");

		System.out.println("====================================NOTA FISCAL=========================================\n");

		System.out.printf("Nome" + "\t \t" + "Qtde. de produtos" + "\t" + "Preço unit.(R$)" + "\t \t \n");
		
		for (int i = 0; i < codigo.length; i++) {
			System.out.printf("%-15s \t %-15d \t %-15.2f \t \n", produto[i], qtNoCarrinho[i], preco[i]);
		}
		
		System.out.println("\n Preço Total da compra sem descontos ou acréscimos: \n" + "\t R$ " + (String.format("%.2f", total)));

		System.out.println("\n Desconto na compra: \n" + "\t R$ " + (String.format("%.2f", totalDesc)));

		System.out.println("\n Valor tributário: \n" + "\t R$ " + (String.format("%.2f", totalImp)));

		System.out.println("\n Valor total a ser pago: \n" + "\t R$ " + (String.format("%.2f",(total - totalDesc + totalImp))));
		
		System.out.println("====================================NOTA FISCAL=========================================\n");

	}
}
