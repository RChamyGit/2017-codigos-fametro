#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//regitro dependente
typedef struct dependente{
	char nomeDep[10];
	int anoDep;
}Dependente;

//declarando os registro trab
typedef struct trabalhador{
	char nome[10];
	int mat;
	float sal;
	Dependente Dep[3];
	
}Trabalhador;

//registro login
typedef struct loginAdm{
	char login[10], senha[10];
}LoginAdm;

//registro Rh
typedef struct loginRh{
	char loginRh[10], senhaRh[10];
}LoginRh;

Trabalhador Fun[2];
LoginAdm adm;
LoginRh rh;

//declarando os procedimentos igual
void inicializar_adm();
void telaLogin();
void comparaLogin(char l[],char s[]);
void cadastrarRH();
void menuRH();
void confirmaSaida(int par_saida); //inserir 1 para tela de login, inserir 2 para menu de rh


//MAIN
main(){
	inicializar_adm();
	telaLogin();
	printf("FIM DO PROGRAMA");
	system("pause");
}
//FIM MAIN
								
void inicializar_adm(){
	//atribuindo o valor para login e senha de administrador
	strcpy(adm.login,"admin");
	strcpy(adm.senha,"senha");
}
void telaLogin(){
	char login[10],senha[10];
	printf("Digite o Login: ");
	fflush(stdin);
	gets(login);
	printf("Digite Senha: ");
	fflush(stdin);
	gets(senha);
	comparaLogin(login,senha);
	system("pause");
}

//comparando o Login 
void comparaLogin(char l[], char s[]){

// se login e senha for igual a l e s 
	if(strcmp(l,adm.login)==0 && strcmp(s,adm.senha)==0){
		printf("\n comparou adm e senha adm com sucesso");
		cadastrarRH();
	}
	else if(strcmp(l,rh.loginRh)==0 && strcmp(s,rh.senhaRh)==0){
		menuRH();
		printf("\n Commparacao login - login funcionario ok");
	}
	// BLOCO DE CONFIRMACAO - CONTINUAR OU SAIR
	else {
		printf("login e senha incorretos! Continuar ? \n 1 - Sim \n 0 - Nao");
		confirmaSaida(1);	
	}
	printf("\n SAINDO DO COMPARALOGIN");
	system("pause");
}

void confirmaSaida(int par_saida){ //parametro saida
	int sair;
		//PARAMETRO 1
		if(par_saida==1){
		scanf("%d",&sair);
		
			if(sair==1){
				telaLogin();
			}
			else if(sair==0){
				exit(0);
			}
			else{
				printf("Opcao invalida! Continuar ? \n 1 - Sim \n 0 - Nao");
				confirmaSaida(1);
				}		
		}
		//PARAMETRO 2
		if(par_saida==2){
		scanf("%d",&sair);
		
			if(sair==1){
				menuRH();
			}
			else if(sair==0){
				exit(0);
			}
			else{
				printf("Opcao invalida! Continuar ? \n 1 - Sim \n 0 - Nao");
				confirmaSaida(2);
				}	
				
		}		
}

//FUNCAO CADASTRAR RH
void cadastrarRH(){
	//LoginRh rh;
	printf("\n Cadastre Login do RH: ");
	fflush(stdin);
	gets(rh.loginRh);
	printf("\n Cadastre a Senha do RH: ");
	fflush(stdin);
	gets(rh.senhaRh);
	
	printf("\n RETORNANDO AO LOGIN");
	system("pause");
	telaLogin();
}

void menuRH(){
	int op_rh;
	printf("MENU DO RH");
	printf("\n1. Cadastrar");
	printf("\n2. Pesquisar");
	printf("\n3. Alterar Dependente");
	printf("\n0. Voltar ao menu de administracao");
	scanf("%i",&op_rh);
	switch(op_rh){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 0:
			exit(0);
		default:
			printf("login e senha incorretos! Continuar ? \n 1 - Sim \n 0 - Nao");
			confirmaSaida(2);	
	}
	system("pause");
}





