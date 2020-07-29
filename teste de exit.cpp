#include <stdio.h>
#include <stdlib.h>

int main()
{
	int op;
	do{
		printf("\n1 - 1 ; 2 - 2 ; 0 - sair");
		
	scanf("%d",&op);
		switch(op){
			case 1:
			printf("opcao 1");
			system("pause");
			break;
			case 2:
			printf("opcao 2");
			system("pause");
			break;
			case 0:
			exit(0);
			break;
			default:
				printf("opcao invalida abestado");
				system("pause");
			
	}
	}while(op!=0);
	printf("erro de logica");
	system("pause");
}
