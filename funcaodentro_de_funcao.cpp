
// PROCEDIMENTO DENTRO DE PROCEDIMENTO

#include <stdlib.h>
#include <stdio.h>

void a();
void b();

int main(){
	b();
	system("pause");
}


void a(){
	printf("HOJE NAO TEM AULA\n");
}
void b(){
	a();
}

