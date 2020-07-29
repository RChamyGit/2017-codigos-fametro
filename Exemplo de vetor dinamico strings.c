//VETOR DINAMICO COM STRINGS

#include <stdio.h>
#include <stdlib.h>
typedef struct participante{
	int tamanho; //impossivel saber tamanho de um vetor dinamico em C com sizeof
	
	char nome[50]; // da erro se for 10 20 pq to lendo um CHAR
	int cartao_respostas[10];
	int cont_respostas;
}Participante;

void imprime(Participante* participante){ //Mesma coisa que participante[]
	int i;
	printf("\n FUNCAO IMPRIME ");
	for(i=0;i<participante->tamanho;i++){
	printf("%s\n",participante[i].nome);
	}
}
//sizeof(participante)/sizeof(participante[0] SO FUNCIONA EM TEMPO DE COMPILACAO, NAO FUNCIONA EM VETOR DINAMICO
int main(){
	int tam;
	int i;
	printf("Digite quantos participantes vc quer neste quiz: ");
	scanf("%d",&tam);
	Participante* participante = malloc(tam * sizeof (*participante)); // vetor dinamico porra 
	//NAO FUNCIONA EM .cpp , usar cast  = (participante*) malloc (tam*sizeof(*participante));
	printf("TAM CADASTRADO");
	printf("DIGITE O VALOR DA PRIMEIRA CASA DO VETOR SE ISSO FUNCIONA MESMO");
	for(i=0;i<tam;i++){
	fflush(stdin);
	gets(participante[i].nome);
	}
	participante->tamanho = tam;
	printf("\n VALOR SALVO NA POSICAO 0 DO VETOR DINAMICO :%s",participante[0].nome);
	printf("\n TAMANHO DO VETOR DINAMICO - VARIAVEL TAMANHO:%d",participante->tamanho);
	printf("\n TAMANHO DO VETOR DINAMICO - SIZEOF PARTICIPANTE: %d",sizeof(participante));
	printf("\n TAMANHO DO VETOR DINAMICO - SIZEOF PARTICIPANTE: %d",sizeof(Participante));
	printf("\n TAMANHO DO VETOR DINAMICO - SIZEOF PARTICIPANTE: %d",));
	imprime(participante);
}

