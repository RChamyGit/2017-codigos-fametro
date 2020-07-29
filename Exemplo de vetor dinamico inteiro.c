// VETOR DINAMICO SEM USO DE PONTEIROS
#include <stdio.h>
#include <stdlib.h>
typedef struct participante{
	int tamanho; //impossivel saber tamanho de um vetor dinamico em C com sizeof
	int nome;
}Participante;

void imprime(Participante* participante){
	int i;
	printf("\n FUNCAO IMPRIME ");
	for(i=0;i<participante->tamanho;i++){
		printf("VALOR DO I: %d\n",i);
		printf("%d\n",participante[i].nome); //ponteiro de ponteiro
	}
}

// UPDATE - USAR SOMENTE UM CONTADOR DE QUESTOES REALIZADAS + ACERTOS

int main(){
	int tam;
	printf("Digite quantos participantes vc quer neste quiz: ");
	scanf("%d",&tam);
	
	Participante* participante = malloc(tam * sizeof (*participante)); // vetor dinamico porra 
	//NAO FUNCIONA EM .cpp , usar cast  = (participante*) malloc (tam*sizeof(*participante));
	printf("\nTAM CADASTRADO");
	printf("\nDIGITE O VALOR DA PRIMEIRA CASA DO VETOR SE ISSO FUNCIONA MESMO");
	//PRECISA INICIALIZAR A VARIAVEL INTERNA
	scanf("%d",&participante[0].nome);
	scanf("%d",&participante[1].nome);
	
	printf("salvou variaveis");
	participante->tamanho = tam;
	printf("\n VALOR SALVO NA POSICAO 0 DO VETOR DINAMICO :%d",participante[0].nome);
	printf("\n TAMANHO DO VETOR DINAMICO : %d",participante->tamanho);
	imprime(participante);
}

