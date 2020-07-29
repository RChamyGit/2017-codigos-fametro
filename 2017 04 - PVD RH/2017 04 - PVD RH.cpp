#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>


struct dependente {
	char nome[20], status[20];
	int nasc;
};

struct dependente dep[3];


struct trabalhador {
	char nome[20];
    int mat, ndep;
    float sal;
    dependente dep[3];
    
};

struct funcionario {
	char  login[20],senha[20];
};

struct funcionario fun[5];
struct trabalhador trab[20];

char login[20], senha[20];
int i, opcao, opcao2, opcao3,d=0,t=0, f=0, geral=100025, matcmp, depcmp, tpara, aux;
	
void cadcola ();
void dependente();	
void funcionario();
void pesquisa();
void alterar();
main (){
	 setlocale(LC_ALL, "Portuguese");
	 	 
	 strcpy(fun[0].login, "eduardo");
	 strcpy(fun[0].senha, "123");
	  
	   	printf("login:");
	   	fflush(stdin);
	   	gets(login);
	   	
	   	printf("senha:");
	   	fflush(stdin);
	   	gets(senha);
	   	
	   	for (i=0; i<=f;i++) {
		   
	   	if (strcmp(strlwr(login), fun[i].login)==0 && strcmp(strlwr(senha), fun[i].senha)==0){
	   		aux=0;
	   		 do {
         	 strcpy(fun[i].login, login);
         	 system("cls");
	   		 printf("\n\tBem Vindo %s! \n \tSelecione a opção desejada:\n\n", fun[i].login);
	   		 printf("1- Cadastrar Colaborador\n");
	   		 printf("2- Cadastrar Dependente\n");
	   		 printf("3- Cadastrar Outro Agente de RH\n");
	   		 printf("4- Pesquisar\n");
	   		 printf("5- Alterar\n");
	   		 printf("0- Log Out\n");
	   		 fflush(stdin);
	   		 scanf("%i", &opcao);
	   		 switch(opcao){
	   		 	case 1:
	   		 	cadcola();
	   		 	break;
				case 2:
				dependente();	
				break;
				case 3:
				funcionario();	
				break;
				case 4:
				pesquisa();	
				break;
				case 5:
				alterar();	
				break;
				case 0:
				main();	
				break;
				default:
				printf("op invalida ")	;
				system("pause");		
				}
			} while (opcao!=0);
			
		   } else {
		   	aux=1;
		   }
		   }
		   if (aux==1){
		   	printf("Senha ou login invalidos! i=%i f=%i\n\n", i, f);
		 	printf("1- continuar\n");
			printf("2-sair\n");
			scanf("%i", &opcao);
			if (opcao==1){
             main ();
			} else if (opcao==2){
				exit(0);
			} else{
				printf("opcao invalida");		   	
		   }

		   }
	   	
	
	system("pause");

}	
	
	
	
	/*void cabecalho (){
	system("cls");
	system("color f0");
	printf("_______PDV MULTIMARCAS RECURSOS HUMANOS_______\n\n");
	}
	*/
	
void cadcola (){
	if (t<20){
    printf("variáveis t=%i d=%i  ndep=%i\n\n", t, d, trab[t].ndep);
	printf("Digite o nome do colaborador:");
	fflush(stdin);
	gets(trab[t].nome);
	
	printf("Digite seu salário:");
	fflush(stdin);
	scanf("%f", &trab[t].sal);
	
	trab[t].mat = geral +t;   // matricula
	printf("Deseja cadastrar dependente?\n1- Sim\n2-Não\n");
    fflush(stdin);
    scanf("%i", &opcao3);
    switch (opcao3){
    case 1:
    	
    	d=0;
    	printf("Nome do Dependente: ");
    	fflush(stdin);
    	gets(trab[t].dep[d].nome);
    	
    	printf("Ano de nascimento: ");
    	fflush(stdin);
    	scanf("%i", &trab[t].dep[d].nasc);
    	
    	if ( trab[t].dep[d].nasc>=1996){
    		
			trab[t].ndep ++;          // quantos dependentes esse trabalhador tem
            d= trab[t].ndep -1 ;
    		strcpy(trab[t].dep[d].status, "ATIVO");
            printf("\n\nCADASTRO REALIZADO COM SUCESSO!");
            printf("\nColaborador: %s", trab[t].nome);
            printf("\nSalário: %.2f", trab[t].sal);
            printf("\nMatrícula: %i\n", trab[t].mat);
            printf("--------Dependentes de %s-------\n", trab[t].nome);
            
            for (i=0;i<=d;i++){
                printf("variáveis t=%i d=%i  ndep=%i\n\n", t, d, trab[t].ndep);

            	printf("Nome: %s\n", trab[t].dep[i].nome);
            	printf("Ano de Nascimento: %i\n", trab[t].dep[i].nasc);
            	printf("Status: %s\n", trab[t].dep[i].status);
            	
			}
            trab[t].ndep +1;
            t++;  
    		system("pause");
		} else{
			printf("Dependente acima da idade permitida!\n\n");
		}
    
    break;
    case 2:
    printf("CADASTRO REALIZADO COM SUCESSO!\n");
    printf("\nColaborador: %s", trab[t].nome);
    printf("\nSalário: %.2f", trab[t].sal);
    printf("\nMatrícula: %i\n", trab[t].mat);
    t++;

    system("pause");
    break;
    
}
}
}	
	
void dependente (){
	if (t>0 ) {
	aux=0;
	printf("Digite o Número da Matrícula do colaborador: t=%i\n", t);// T TEM QUE VALER UM
	fflush(stdin);
	scanf("%i", &matcmp);
	    for (i=0;i<=t;i++){
			if (matcmp==trab[i].mat){
			
			printf("\nCadastrar dependentes para colaborador %s\n", &trab[i].nome );
			tpara=i;
			d= trab[tpara].ndep;
			printf("Nome do Dependente:\n");
    		fflush(stdin);
	    	gets(trab[tpara].dep[d].nome);
    	
  		 	printf("Ano de nascimento:\n");
    		fflush(stdin);
    		scanf("%i", &trab[tpara].dep[d].nasc);
    	
    			if ( trab[tpara].dep[d].nasc>=1996){
    		
    			strcpy(trab[tpara].dep[d].status, "ATIVO");
      	   		printf("CADASTRO REALIZADO COM SUCESSO!\n");
                printf("variáveis t=%i d=%i  ndep=%i\n\n", t, d, trab[t].ndep);
      	   		
       		    printf("\nColaborador: %s", trab[tpara].nome);
      			printf("\nSalário: %.2f", trab[tpara].sal);
            	printf("\nMatrícula: %i\n\n", trab[tpara].mat);
            	printf("---------Dependentes de %s----------\n", trab[tpara].nome);
            
           		 for (i=0;i<=d;i++){
            	printf("Nome: %s\n", trab[tpara].dep[i].nome);
            	printf("Ano de Nascimento: %i\n", trab[tpara].dep[i].nasc);
            	printf("Status: %s\n", trab[tpara].dep[i].status);
            	printf("------\n");
					}
					system("pause");
				aux=1;	
				d++; 
				trab[tpara].ndep ++;			
				}
	
			}
		}
		if (aux==0){
		printf("\n\nNão há colaboradores novos cadastrados no sistema!\n Sae Daew!\n\n");
		system("pause");		
		}
	}	
}
	
void funcionario () {
	if (f<5){
		f++;
		printf("Informe O Nome do novo Agente de RH(será o login):\n");
		fflush(stdin);
		gets(fun[f].login);
		
		printf("Informe A senha:\n");
		fflush(stdin);
		gets(fun[f].senha);
	
		
		printf("Cadastro Realizado com Sucesso! f=%i\n", f);
		system("pause");
		
	} else {
	printf("Número de Agentes de Rh Excedido!\n\n")	;
	}
	
}	
	
void pesquisa(){
	aux=0;
	printf("\n1- Pesquisa Colaborador Por Matrícula\n");
	printf("2- Pesqusiar Nome de Dependente\n");
	fflush(stdin);
	scanf("%i", &opcao2);

	switch(opcao2){
		case 1:
			printf("Digite o Número da Matrícula do colaborador t=%i\n", t );
			fflush(stdin);
			scanf("%i", &matcmp);
		
			for  (i=0;i<=t;i++){
			if (matcmp==trab[i].mat){
				aux=1;
				tpara=i;
				d=trab[i].ndep;
				printf("%s\n", trab[i].nome);
				printf("%i\n", trab[i].mat);
				printf("%.2f\n", trab[i].sal);
				
				printf("\t______________Dependentes______________ \n\n");
			    for (i=0;i<d;i++) {                       
				printf("nome:%s\n", trab[tpara].dep[i].nome);
				printf("nascimento:%i\n", trab[tpara].dep[i].nasc);
				printf("status:%s\n", trab[tpara].dep[i].status);
		     	}
		    	system("pause");				
			}
				
			}
				if (aux==0){

				printf("Colaborador Não Encontrado!\n");
				system("pause");
				}
		break;	
		case 2:
			printf("Digite o Nome do Dependente");
			fflush(stdin);
			scanf("%i", &matcmp);			
		break;	
		default:
		printf("op invalida ")	;
		system("pause");
	}
}

void alterar (){

	printf("Digite o Número da Matrícula do colaborador t=%i\n", t );
	fflush(stdin);
	scanf("%i", &matcmp);
	 for  (i=0;i<=t;i++){
		if (matcmp==trab[i].mat){
		aux=1;
		tpara=i;
		printf("%s\n", trab[i].nome);
		printf("%i\n", trab[i].mat);
		printf("%.2f\n", trab[i].sal);
				
		printf("\t______________Dependentes______________ \n\n");
	 		for (i=0;i<d;i++) { 
			printf("Numero: %i\n", i)   ;                   
			printf("nome:%s\n", trab[tpara].dep[i].nome);
			printf("nascimento:%i\n", trab[tpara].dep[i].nasc);
			printf("status:%s\n", trab[tpara].dep[i].status);
			}
			printf("Qual dependente voce gostaria de alterar?\n ");	
			fflush(stdin);
			scanf("%i", &opcao2);	
			if (strcmp(strlwr( trab[tpara].dep[opcao2].status ),  "ativo" )==0 ){
			
			printf("O status de %s será  mudado para 'Inativo' \n ", trab[tpara].dep[opcao2].nome);
			strcpy(trab[tpara].dep[opcao2].status, "INATIVO");
			system("pause");
			
		} else {
	    	printf("O status de %s será mudado para 'ATIVO'  \n", trab[tpara].dep[opcao2].nome);
	    	strcpy(trab[tpara].dep[opcao2].status, "ATIVO");
			system("pause");

		}
			

			
						    system("pause");

			}
	}
	if (aux==0){
	printf("Colaborador Não Encontrado!\n");
	system("pause");
	}
}


   
   
   
   
   
   
   
   
   
    
   









	
