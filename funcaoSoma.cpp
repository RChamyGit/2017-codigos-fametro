#include <stdio.h>
#include <stdlib.h>

int soma(int a, int b){  // < variaveis internas da funcao nao precisam ser iguais a origem!
	return a+b; //retorna uma variavel ou equacao
}

int main(){
	int x,y;
	int resultado;
	int opcao;
	
	/* case 1:
		
	   default:
	   	printf("invalida!");
	*/
	printf("leia x");
	scanf("%d",&x);
	
	printf("\nleia y: ");
	scanf("%d",&y);
	
	resultado = soma(x,y);  // > enviando RETURN de soma para resultado
	printf("soma dos valores %d\n",resultado);

	system("pause");
}
