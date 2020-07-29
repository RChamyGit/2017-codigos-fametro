#include <stdio.h>
#include <stdlib.h>

typedef struct vetor{
	int vet[5];
	int j;
}Vetor;

int main(){
   Vetor vetor[10];
   int i,j = 0;
   int n; // tamanho definido pelo usuario
   int decisao;
   
   printf("escolha o tamanho do vetor");
   scanf("%d",&n);
   
   for(i=0;i<n;i++){
   printf("Laco externo");
   vetor[i].j=0;
		   do{
			   printf("Laco interno");
  			   scanf("%d",&vetor[i].vet[vetor[i].j]);
		   	   system("pause");
			   printf("\nDESEJA CONTINUAR? 1 - SIM ; QUALQUER COISA - NAO");
			   scanf("%d",&decisao);
			   vetor[i].j++;
			
			}while(decisao==1&&j<6);
		   }
	for(i=0;i<n;i++){
   		printf("Laco externo\n");
   		printf("\nvalor do i: %d\n",i);
   		for(j=0;j<5;j++){
   			printf("\nvalor do j: %d\n",j);
			printf("Laco interno\n");
  			printf("\n%d",vetor[i].vet[j]);
		   }	
	// nao funciona direito, imprime endereco de memoria no final.
   }	
}	
   // imprime o que foi inserido
   
   
