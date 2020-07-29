#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<locale.h>
                   

struct aux        {
	int lcli;
};

struct aux  auxcli[4];


struct produtos   {
	char nomeprod[20], mot[150];
	float valprod;
	};

struct anunciante {
	char nomeanun[20];
};

struct cliente    {
	char nomecli[20], telcli[20];
	
	aux auxcli[4];
};

struct login      {
	char login[20], tel[20];
	
};

struct produtos regp [4];
struct anunciante rega[4];
struct cliente regcli[4];
struct login regl;

void cabecalho ();
void cliente ();
void anunciante();
void produto();

int i=0 , opcao, opcao2, contp, contc=0;
 	
 main ( ){

 	setlocale(LC_ALL, "Portuguese");
    regcli[i].auxcli[i].lcli=0;
    
     
        cabecalho ();
     	printf("Escolha uma opção:\n ");
     	printf("\n1- Já tenho cadastro\n2- Cadastrar\n");
     	scanf("%i", &opcao);
     	switch (opcao){
     		case 1:
			 cabecalho ();
		     printf("Digite seu nome: ");
			 fflush(stdin);
			 gets(regl.login);
			 
			 printf("Digite o telefone:"); 
			 fflush(stdin);
			 gets(regl.tel);        
			 
			  if (strcmp(strlwr(regl.login), regcli[i].nomecli)== 0 &&  strcmp(strlwr(regl.tel), regcli[i].telcli)== 0 && regcli[i].auxcli[i].lcli== 0) {
			   cabecalho ();
			   printf("Listando Protudos:\n");
               printf("%s", regp[i].nomeprod);
               printf("%.2f", &regp[i].valprod);
               printf("%s", regp[i].mot);
               regcli[i].auxcli[i].lcli ++;
               system("pause");
             
			   }else if (strcmp(strlwr(regl.login), regcli[i].nomecli)== 0 && strcmp(strlwr(regl.tel), regcli[i].telcli)== 0 && regcli[i].auxcli[i].lcli!= 0) {
		      cabecalho ();
            
			  } else {
			  cabecalho ();
              printf("Cadastro Não Encontrado\n");
			 }
			  break;
			case 2:
			 cabecalho ();
             do {
			 
			 printf("Escolha uma opção:\n ");
             printf("\n1- Cadastrar Anúncio\n2- Cadastrar Cliente\n0- Voltar ao menu principal\n");
   			 scanf("%i", &opcao2);   
			 switch(opcao2){
			  case 1:  
			  cabecalho ();
			  anunciante();  
			  break; 
			  case 2:
     	      cabecalho ();
              cliente ();  
			  break;     
              case 0:
              	main (); /// espia !
              break;
              default:
              
         	  printf("opcao invalida\n");
                   }
                }while (opcao2!=0);
			  break;
		      default:
		      printf("Opção Inválida!\n");
		      system("pause");
		   	  main ();          	
              
              
         	 } 
 	         system("pause");	
 }


void cabecalho (){
	system("cls");
	system("color f0");
	printf("_______EOF COMPRA E VENDAS_______\n\n");
	}

void cliente ()  {
	if ( contc>4){
		
	printf("Digite o nome a ser cadastrado:\n");
	fflush(stdin);
	gets(regcli[i].nomecli); 
	
	printf("Digite o telefone a ser cadastrado:\n");
	fflush(stdin);
	gets(regcli[i].telcli);
	
	printf("Cadastro realizado com sucesso!\n Boas compras!!!\n");
	system("pause");	
    }
	}

void anunciante(){
	if (contp<4){
	
	printf("Digite seu nome:\n");
	fflush(stdin);
	gets(rega[i].nomeanun);
	
	printf("Digite o nome do produto:\n");
	fflush(stdin);
	gets(regp[i].nomeprod);	           
	              
	
	printf("Digite o motivo da venda:\n");
	fflush(stdin);	
	gets(regp[i].mot);
	
	printf("Digite o valor proposto:\n");
	fflush(stdin);	
	scanf("%f", &regp[i].valprod);
	contp ++;
	printf("Produto Cadastrado com sucesso!\n _____Boa sorte!!_____\n");
}
}

void produto ()  {
	if ( contp>4){
	
	printf("Digite o nome do produto:\n");
	fflush(stdin);
	gets(regp[i].nomeprod);	            // perguntar como chama uma vaiavel de outros struct
	              
	
	printf("Digite o motivo da venda:\n");
	fflush(stdin);	
	gets(regp[i].mot);
	
	printf("Digite o valor proposto:\n");
	fflush(stdin);	
	scanf("%.2f", &regp[i].valprod);
	contp ++;
    printf("Produto Cadastrado com sucesso!\n _____Boa sorte!!_____\n");
	system("pause");
}
}



