#include <stdio.h>
#include <stdlib.h>

typedef struct vetor{
	int vet[5];
}Vetor;

int main(){
   Vetor vetor[10];
   int i,j;
   int n; // tamanho definido pelo usuario
   
   printf("escolha o tamanho do vetor");
   scanf("%d",&n);
   
   for(i=0;i<n;i++){
   printf("Laco externo");
   		for(j=0;j<5;j++){
			   printf("Laco interno");
  			   scanf("%d",&vetor[i].vet[j]);
		   }	
	   
   }	
   
   // imprime o que foi inserido
   
   for(i=0;i<n;i++){
   printf("Laco externo\n");
   printf("\nvalor do i: %d\n",i);
   		for(j=0;j<5;j++){
   		printf("\nvalor do j: %d\n",j);
			   printf("Laco interno\n");
  			   printf("\n%d",vetor[i].vet[j]);
		   }	
	   
   }	
}
